package fr.adaming.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.CMYKColor;
import com.itextpdf.text.pdf.PdfWriter;

import fr.adaming.dao.IDossierDao;
import fr.adaming.model.Client;
import fr.adaming.model.Conseiller;
import fr.adaming.model.Dossier;
import fr.adaming.model.Formule;
import fr.adaming.model.Hebergement;
import fr.adaming.model.Participant;
import fr.adaming.model.Voiture;
import fr.adaming.model.Voyage;
import fr.adaming.util.MailSendPdf;

@Service
@Transactional
public class DossierServiceImpl implements IDossierService {

	@Autowired
	private IDossierDao dossierDao;

//	private MailSendPdf smpdf;

	@Override
	public Dossier addDossier(Dossier dos) {
		// Le dossier doit être examiné par Bovoyage
		dos.setStatutdossier("En attente");

		Dossier dOut = dossierDao.addDossier(dos);

		// Informer le client et le client
		if (dOut.getId() != 0) {
			System.out.println("envoyer mail ?");
			sendMail2Client(dos);
			sendMail2Conseiller(dos);
		}

		return dOut;
	}

	@Override
	public List<Dossier> getAllDossier() {

		return dossierDao.getAllDossier();
	}

	@Override
	public int updateDossier(Dossier dos) {
		Dossier dOld = dossierDao.getDossierById(dos.getId());

		int verif = dossierDao.updateDossier(dos);

		if (verif != 0) {
			if (dOld.getStatutdossier() != dos.getStatutdossier()) {

				// Si le dossier est validé, générer le PDF
				if (dos.getStatutdossier() == "Accepté") {
					genererPDF(dos);
				}

				// Prévenir le client de la modification
				sendMail2Client(dos);
			}
		}

		// Si le dossier ne peut être accepté
		if (dos.getStatutdossier() == "Annulé" || dos.getStatutdossier() == "Refusé") {
			verif = dossierDao.deleteDossier(dos.getId());
		}

		return verif;
	}

	@Override
	public int deleteDossier(long id) {

		return dossierDao.deleteDossier(id);
	}

	@Override
	public Dossier getDossierById(long id) {

		return dossierDao.getDossierById(id);
	}

	@Override
	public List<Dossier> getDossiersByIdClient(long idCl) {
		return dossierDao.getDossiersByIdClient(idCl);
	}

	public String getFile(Dossier dossier) {
		Long id = dossier.getId();
		StringBuilder sOut = new StringBuilder();
		String input = System.getProperty("user.home");
		for (int i = 0; i < input.length(); i++) {
			if (i > 0 && input.charAt(i) == '\\') {

				sOut.append("\\");
			}
			sOut.append(input.charAt(i));
		}

		sOut.append("\\\\Desktop\\\\Voyage_" + String.format("%03d", id) + ".pdf");

		String path = sOut.toString();
		System.out.println(path);
		return path;
	}

	public String getQR() {
		StringBuilder sOut = new StringBuilder();
		String input = System.getProperty("user.home");
		for (int i = 0; i < input.length(); i++) {
			if (i > 0 && input.charAt(i) == '\\') {

				sOut.append("\\");
			}
			sOut.append(input.charAt(i));
		}

		sOut.append("\\\\ProjetAgenceVoyage\\\\src\\\\main\\\\webapp\\\\resources\\\\image\\\\static_qr_code.jpg");

		String path = sOut.toString();
		System.out.println(path);
		return path;
	}

	public void genererPDF(Dossier dossier) {
		try {
			Client cl = dossier.getClientDos();
			List<Participant> listeP = dossier.getParticipantsDos();
			Voyage voyage = dossier.getVoyageDos();
			Formule form = voyage.getFormule();

			Document document = new Document(PageSize.A4, 75, 75, 75, 75);

			String path = getFile(dossier);

			PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(path));

			Paragraph titre = new Paragraph("BoVoyage : Récapitulatif du dossier n°" + dossier.getId() + "\n",
					FontFactory.getFont(FontFactory.HELVETICA_BOLD, 18, Font.UNDERLINE,
							new CMYKColor(54, 255, 201, 0)));
			titre.setSpacingAfter(20);
			document.add(titre);

			Paragraph parag1 = new Paragraph(
					"Destination : " + voyage.getDestination().getPays() + "\nDépart : " + voyage.getDateD()
							+ "\nRetour : " + voyage.getDateR(),
					FontFactory.getFont(FontFactory.HELVETICA_OBLIQUE, 15));
			parag1.setSpacingAfter(20);
			document.add(parag1);

			String partie2 = "Formule : ";
			String sep = "";
			String partie3 = "";
			int verif = 0;

			if (form.isAvion()) {
				partie2 = partie2 + "avion ";
				verif++;
				sep = ", ";
			}

			if (form.isVoiture()) {
				partie2 = partie2 + sep + "voiture";

				Voiture voiture = form.getVoitureLouer();

				partie3 = "\n\nVOITURE Catégorie " + voiture.getCategorie() + " - Loueur " + voiture.getLoueur();

				verif++;
				sep = ", ";
			}

			if (form.isHotel()) {
				partie2 = partie2 + sep + "hotel ";
				Hebergement heb = voyage.getHebergement();

				partie3 = partie3 + "\n\n Mode d'hébergement  " + heb.getSelectionhbg();
			}

			Paragraph parag2 = new Paragraph(partie2 + partie3, FontFactory.getFont(FontFactory.HELVETICA_OBLIQUE, 15));
			parag2.setSpacingAfter(20);
			document.add(parag2);

			// TODO inserer image
			Image img = Image.getInstance(getQR());

			document.add(img);

			document.close();

		} catch (FileNotFoundException | DocumentException e) {
			e.printStackTrace();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void sendMail2Conseiller(Dossier dossier) {
		Client cl = dossier.getClientDos();
		List<Participant> listeP = dossier.getParticipantsDos();
		Voyage voyage = dossier.getVoyageDos();

		Conseiller c = cl.getConseiller();
		System.out.println("Conseiller" + c);

		// TODO Auto-generated method stub
		final String username = "clear.skies928@gmail.com";
		final String password = /*
								 * Ne soyez pas trop curieux !
								 * aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa */ "BubblyClouds8?";

		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");

		// Get Session object.
		Session session = Session.getInstance(props, new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});

		String clientString = "Client <div align='center'><table class='table table-bordered'><div align='center'><table class='table table-bordered'><tr><th>ID</th><th>Nom</th><th>Prenom</th><th>Civilité</th><th>Tel</th><th>Date de naissance</th><th>Mail</th><th>Statut dossier</th></tr>"
				+ "<tr><td>" + cl.getId() + "</td><td>" + cl.getNom() + "</td><td>" + cl.getPrenom() + "</td><td>"
				+ cl.getCivilite() + "</td><td>" + cl.getTel() + "</td><td>" + cl.getDn() + "</td><td>" + cl.getMail()
				+ "</td><td>" + dossier.getStatutdossier() + "</td></tr></table></div>";

		// TODO
		String participantString = "";

		if (dossier.getParticipantsDos() != null){
			participantString = "Participants <div align='center'><table class='table table-bordered'><tr><th>ID</th><th>Civilité</th><th>Nom</th><th>Prenom</th><th>Numéro de <br/> téléphone</th><th>Date de<br/> naissance</th><th>Mail</th></tr>";

			for (Participant p : listeP) {
				participantString = participantString + "<tr><td>" + p.getId() + "</td><td>" + p.getCivilite()
						+ "</td><td>" + p.getNom() + "</td><td>" + p.getPrenom() + "</td><td>" + p.getTel()
						+ "</td><td><fmt:formatDate pattern='dd/MM/yyyy' value=" + p.getDn() + " /></td><td>"
						+ p.getMail() + "</td></tr>";
			}
			participantString = participantString + "</table></div>";
		}
		
//		System.out.println(voyage.getDestination().getPays());
		
		String voyageString = "";

//		String voyageString = "Voyage <div align='center'><table class='table table-bordered'><br/><tr><th>ID</th><th>Date depart</th><th>Date retour</th><th>Nombre de place</th><th>Tarif</th><th>Disponibilité</th><th>Assurance</th><th>Pays de la destination</th><th>ID de l'hébergement</th><th>ID de la formule</th></tr>"
//				+ "<tr><td>" + voyage.getId_v() + "</td>" + "<td> <fmt:formatDate pattern='dd/MM/yyyy' value='"
//				+ voyage.getDateD() + "'/></td><td> <fmt:formatDate pattern='dd/MM/yyyy' value='" + voyage.getDateR()
//				+ "'/></td><td>" + voyage.getNbPlaces() + "</td><td>" + voyage.getTarif() + "</td><td>"
//				+ voyage.getDisponibilite() + "</td>" + "<td>" + dossier.getStatutdossier() + "</td>" 
//				+ "<td>" + voyage.getDestination().getPays() + "</td><td>"
//				+ voyage.getHebergement().getId_h() + "</td><td>" + voyage.getFormule().getId_f() + "</td></tr></table></div>";

		try {
			// Create a default MimeMessage object.
			Message message = new MimeMessage(session);
			Multipart multipart = new MimeMultipart();

			// Set From: header field of the header.
			message.setFrom(new InternetAddress(username));

			// Set To: header field of the header.
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(c.getMail()));

			// Set Subject: header field
			message.setSubject("Réservation à programmer pour le voyage " + voyage.getDestination() + " du "
					+ voyage.getDateD() + " au " + voyage.getDateR());

			MimeBodyPart messageBodyPart = new MimeBodyPart();
			messageBodyPart.setContent(
					"Bonjour M. ou Mme " + c.getPrenom() + " " + c.getNom() + ",<br/> "
							+ "Une réservation pour le voyage " + voyage.getDestination() + " du " + voyage.getDateD()
							+ " au " + voyage.getDateR() + "a été effectuée par un client.<br/>"
							+ "Voici les détails pour la réservation : <br/>" + clientString + "<br/>"
							+ participantString + "<br/>" + voyageString + "<br/>"
							+ "Veuillez effectuer le nécessaire pour vérifier la solvabilité de ce client, puis vérifier s'il est possible de valider cette réservation.<br/> "
							+ "" + "<br/><br/>PS : Ceci est un mail généré automatiquement, merci de ne pas y répondre",
					"text/html");

			// adds parts to the multipart
			multipart.addBodyPart(messageBodyPart);

			// sets the multipart as message's content
			message.setContent(multipart);

			// Send message
			Transport.send(message, message.getAllRecipients());
			System.out.println("Sent message successfully....");

		} catch (MessagingException mex) {
			mex.printStackTrace();
		}

	}

	public void sendMail2Client(Dossier dossier) {
		Client cl = dossier.getClientDos();
		List<Participant> listeP = dossier.getParticipantsDos();
		Voyage voyage = dossier.getVoyageDos();

		Conseiller c = cl.getConseiller();

		// TODO Auto-generated method stub
		final String username = "clear.skies928@gmail.com";
		final String password = /*
								 * Ne soyez pas trop curieux !
								 * aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa*/ "BubblyClouds8?";

		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");

		// Get Session object.
		Session session = Session.getInstance(props, new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});

		try {
			System.out.println("test4");

			// Create a default MimeMessage object.
			Message message = new MimeMessage(session);
			Multipart multipart = new MimeMultipart();

			// Set From: header field of the header.
			message.setFrom(new InternetAddress(username));

			// Set To: header field of the header.
			System.out.println(cl);
			System.out.println(cl.getMail());
			
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(cl.getMail()));

			String enTete = " de la réservation pour le voyage " + voyage.getDestination() + " du " + voyage.getDateD()
					+ " au " + voyage.getDateR();

			String voyageEtat = "";

			System.out.println("test4");
			if (dossier.getStatutdossier() == "En attente") {
				voyageEtat = "Votre demande de voyage va être examinée par nos services. </br>"
						+ "Lorsqu'elle sera validée, nous débuterons la négociation avec l'agence concernée par le voyage, et vous tiendrons informés du résultat dans les prochaines 24h. <br/><br/>"
						+ "A bientôt sur notre site pour un prochain beau voyage !";

				enTete = "Etude " + enTete;
			}
			if (dossier.getStatutdossier() == "Annulé") {
				voyageEtat = "Votre demande de voyage a été examinée par nos services. Malheureusement, celle-ci a été rejetée par notre service comptabilité."
						+ "Votre compte n'a pas été débité au cours de cette opération.<br/><br/>"
						+ "A bientôt sur notre site pour un prochain beau voyage !";

				enTete = "Annulation " + enTete;
			}

			if (dossier.getStatutdossier() == "En cours") {
				voyageEtat = "Votre demande de voyage a été examinée et validée par nos services. "
						+ "<br/>Nous sommes à présent en cours de négociations avec l'agence concernée par le voyage, et vous tiendrons informés de l'évolution du dossier dans un délai de 48h. <br/>"
						+ "Votre compte ne sera pas débité au cours de cette opération. <br/><br/>"
						+ "A bientôt sur notre site pour un prochain beau voyage !";

				enTete = "Evolution " + enTete;
			}

			if (dossier.getStatutdossier() == "Accepté") {
				voyageEtat = "Votre réservation a bien pu être effectuée auprès de l'agence, nous vous confirmons donc votre réservation. <br/>"
						+ "Votre compte sera débité prochaine de la somme de " + voyage.getTarif() + "€. <br/>"
						+ "Veuillez trouver ci-joint votre billet d'avion.<br/><br/>"
						+ "BoVoyage vous souhaite un agréable séjour, et espère vous retrouver bientôt pour un prochain voyage !";

				enTete = "Validation " + enTete;

				System.out.println("test5");
				// creates body part for the attachment
				MimeBodyPart attachPart = new MimeBodyPart();

				// ajouter la PJ
				String attachFile = getFile(dossier);

				DataSource source = new FileDataSource(attachFile);
				attachPart.setDataHandler(new DataHandler(source));
				attachPart.setFileName(new File(attachFile).getName());

				multipart.addBodyPart(attachPart);

			}

			if (dossier.getStatutdossier() == "Refusé") {
				voyageEtat = "Votre demande de réservation n'a pas pu aboutir, car le nombre de places restantes pour ce trajet est insuffisant<br/>"
						+ "Votre compte n'a pas été débité en conséquence. <br/><br/>"
						+ "Nous espérons vous retrouver bientôt pour planifier un prochain voyage !";

				enTete = "Annulation " + enTete;
			}

			System.out.println("test6");
			// Set Subject: header field
			message.setSubject(enTete);

			MimeBodyPart messageBodyPart = new MimeBodyPart();
			messageBodyPart.setContent(
					"Bonjour " + cl.getCivilite() + " " + cl.getPrenom() + " " + cl.getNom() + ",<br/>" + voyageEtat,
					"text/html");

			// adds parts to the multipart
			multipart.addBodyPart(messageBodyPart);

			// sets the multipart as message's content
			message.setContent(multipart);

			System.out.println("test7");
			// Send message
			Transport.send(message, message.getAllRecipients());
			System.out.println("Sent message successfully....");

		} catch (MessagingException mex) {
			System.out.println("test00");
			mex.printStackTrace();
		}
	}

}
