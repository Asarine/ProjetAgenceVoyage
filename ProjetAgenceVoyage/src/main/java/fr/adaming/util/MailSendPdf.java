package fr.adaming.util;
import java.io.File;
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

import fr.adaming.model.Client;
import fr.adaming.model.Conseiller;
import fr.adaming.model.Dossier;
import fr.adaming.model.Participant;
import fr.adaming.model.Voyage;

public class MailSendPdf {

	public String getFile(Voyage voyage) {
		Long id = voyage.getId_v();
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

	public void sendMail2Conseiller(Dossier dossier) {
		Client cl = dossier.getClientDos();
		List<Participant> listeP = dossier.getParticipantsDos();
		Voyage voyage = dossier.getVoyageDos();
		
		Conseiller c = cl.getConseiller();

		// TODO Auto-generated method stub
		final String username = "clear.skies928@gmail.com";
		final String password = /*
								 * Ne soyez pas trop curieux !
								 * aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa*/ "BubblyClouds8?";

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

		String clientString = "Client <br/><th>ID</th><th>Nom</th><th>Prenom</th><th>Civilit�</th><th>Tel</th><th>Date de naissance</th><th>Mail</th><th>Statut dossier</th><th>Numero compte bancaire</th>"
				+ "<td>" + cl.getId() + "</td><td>" + cl.getNom() + "</td><td>" + cl.getPrenom() + "</td><td>"
				+ cl.getCivilite() + "</td><td>" + cl.getTel() + "</td><td>" + cl.getDn() + "</td><td>" + cl.getMail()
//				+ "</td><td>" + cl.getStatutdossier() + "</td><td>" + cl.getNumcb() + "</td>"
				;

		// TODO
		String participantString = "Participants <br/><th>ID</th><th>Civilit�</th><th>Nom</th><th>Prenom</th><th>Num�ro de <br/> t�l�phone</th><th>Date de<br/> naissance</th><th>Mail</th>";
		String voyageString = "Voyage <br/><tr><th>ID</th><th>Date depart</th><th>Date retour</th><th>Nombre de place</th><th>Tarif</th><th>Disponibilit�</th><th>Assurance</th><th>Id de la destination</th><th>Pays de la destination</th><th>ID de l'h�bergement</th><th>ID de la formule</th></tr>"
				+ "<tr><td>" + voyage.getId_v() + "</td>" + "<td> <fmt:formatDate pattern='dd/MM/yyyy' value='"
				+ voyage.getDateD() + "'/></td><td> <fmt:formatDate pattern='dd/MM/yyyy' value='" + voyage.getDateR()
				+ "'/></td><td>" + voyage.getNbPlaces() + "</td><td>" + voyage.getTarif() + "</td><td>"
				+ voyage.getDisponibilite() + "</td>"
				 + "<td>" + dossier.getStatutdossier() + "</td>"
				+ "<td>" + voyage.getDestination().getId() + "</td><td>" + voyage.getDestination().getPays()
				+ "</td><td>" + voyage.getHebergement().getId_h() + "</td><td>" + voyage.getFormule().getId_f()
				+ "</td></tr>";

		for (Participant p : listeP) {
			participantString = participantString + "<tr><td>" + p.getId() + "</td><td>" + p.getCivilite() + "</td><td>"
					+ p.getNom() + "</td><td>" + p.getPrenom() + "</td><td>" + p.getTel()
					+ "</td><td><fmt:formatDate pattern='dd/MM/yyyy' value='" + p.getDn() + "' /></td><td>"
					+ p.getMail() + "</td></tr>";
		}

		try {
			// Create a default MimeMessage object.
			Message message = new MimeMessage(session);
			Multipart multipart = new MimeMultipart();

			// Set From: header field of the header.
			message.setFrom(new InternetAddress(username));

			// Set To: header field of the header.
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(c.getMail()));

			// Set Subject: header field
			message.setSubject("R�servation � programmer pour le voyage " + voyage.getDestination() + " du "
					+ voyage.getDateD() + " au " + voyage.getDateR());

			MimeBodyPart messageBodyPart = new MimeBodyPart();
			messageBodyPart.setContent(
					"Bonjour M. ou Mme " + c.getPrenom() + " " + c.getNom() + ",<br/> "
							+ "Une r�servation pour le voyage " + voyage.getDestination() + " du " + voyage.getDateD()
							+ " au " + voyage.getDateR() + "a �t� effectu�e par un client.<br/>"
							+ "Voici les d�tails pour la r�servation : <br/>" + clientString + "<br/>"
							+ participantString + "<br/>" + voyageString + "<br/>"
							+ "Veuillez effectuer le n�cessaire pour v�rifier la solvabilit� de ce client, puis v�rifier s'il est possible de valider cette r�servation.<br/> "
							+ "" + "<br/><br/>PS : Ceci est un mail g�n�r� automatiquement, merci de ne pas y r�pondre",
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
								 * aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa*/ "BubblyClouds8?";

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

		String clientString = "Client <br/><th>ID</th><th>Nom</th><th>Prenom</th><th>Civilit�</th><th>Tel</th><th>Date de naissance</th><th>Mail</th><th>Statut dossier</th><th>Numero compte bancaire</th>"
				+ "<td>" + cl.getId() + "</td><td>" + cl.getNom() + "</td><td>" + cl.getPrenom() + "</td><td>"
				+ cl.getCivilite() + "</td><td>" + cl.getTel() + "</td><td>" + cl.getDn() + "</td><td>" + cl.getMail()
				+ "</td><td>" + dossier.getStatutdossier() + "</td><td>" + cl.getNumcb() + "</td>"
				;

		// TODO
		String participantString = "Participants <br/><th>ID</th><th>Civilit�</th><th>Nom</th><th>Prenom</th><th>Num�ro de <br/> t�l�phone</th><th>Date de<br/> naissance</th><th>Mail</th>";
		String voyageString = "Voyage <br/>";

		for (Participant p : listeP) {
			participantString = participantString + "<tr><td>" + p.getId() + "</td><td>" + p.getCivilite() + "</td><td>"
					+ p.getNom() + "</td><td>" + p.getPrenom() + "</td><td>" + p.getTel()
					+ "</td><td><fmt:formatDate pattern='dd/MM/yyyy' value=" + p.getDn() + " /></td><td>" + p.getMail()
					+ "</td></tr>";
		}

		try {

			// Create a default MimeMessage object.
			Message message = new MimeMessage(session);
			Multipart multipart = new MimeMultipart();

			// Set From: header field of the header.
			message.setFrom(new InternetAddress(username));

			// Set To: header field of the header.
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(cl.getMail()));
			
			String enTete = " de la r�servation pour le voyage " + voyage.getDestination() + " du "
					+ voyage.getDateD() + " au " + voyage.getDateR();
			
			String voyageEtat = "";

			if (dossier.getStatutdossier() == "En attente") {
				voyageEtat = "Votre demande de voyage va �tre examin�e par nos services. </br>"
						+ "Lorsqu'elle sera valid�e, nous d�buterons la n�gociation avec l'agence concern�e par le voyage, et vous tiendrons inform�s du r�sultat dans les prochaines 24h. <br/><br/>"
						+ "A bient�t sur notre site pour un prochain beau voyage !";
				
				enTete = "Etude " + enTete;
			}
			if (dossier.getStatutdossier() == "Annul�") {
				voyageEtat = "Votre demande de voyage a �t� examin�e par nos services. Malheureusement, celle-ci a �t� rejet�e par notre service comptabilit�."
						+ "Votre compte n'a pas �t� d�bit� au cours de cette op�ration.<br/><br/>"
						+ "A bient�t sur notre site pour un prochain beau voyage !";
				
				enTete = "Annulation " + enTete;
			}

			if (dossier.getStatutdossier() == "En cours") {
				voyageEtat = "Votre demande de voyage a �t� examin�e et valid�e par nos services. "
						+ "<br/>Nous sommes � pr�sent en cours de n�gociations avec l'agence concern�e par le voyage, et vous tiendrons inform�s de l'�volution du dossier dans un d�lai de 48h. <br/>"
						+ "Votre compte ne sera pas d�bit� au cours de cette op�ration. <br/><br/>"
						+ "A bient�t sur notre site pour un prochain beau voyage !";
				
				enTete = "Evolution " + enTete;
			}

			if (dossier.getStatutdossier() == "Accept�") {
				voyageEtat = "Votre r�servation a bien pu �tre effectu�e aupr�s de l'agence, nous vous confirmons donc votre r�servation. <br/>"
						+ "Votre compte sera d�bit� prochaine de la somme de " + voyage.getTarif() + "�. <br/>" 
						+ "Veuillez trouver ci-joint votre billet d'avion.<br/><br/>"
						+ "BoVoyage vous souhaite un agr�able s�jour, et esp�re vous retrouver bient�t pour un prochain voyage !";
				
				enTete = "Validation " + enTete;
				
				// creates body part for the attachment
				MimeBodyPart attachPart = new MimeBodyPart();
				
				// ajouter la PJ
				String attachFile = getFile(voyage);

				DataSource source = new FileDataSource(attachFile);
				attachPart.setDataHandler(new DataHandler(source));
				attachPart.setFileName(new File(attachFile).getName());
				
				multipart.addBodyPart(attachPart);
				
			}

			if (dossier.getStatutdossier() == "Refus�") {
				voyageEtat = "Votre demande de r�servation n'a pas pu aboutir, car le nombre de places restantes pour ce trajet est insuffisant<br/>"
						+ "Votre compte n'a pas �t� d�bit� en cons�quence. <br/><br/>"
						+ "Nous esp�rons vous retrouver bient�t pour planifier un prochain voyage !";
				
				enTete = "Annulation " + enTete;
			}
			
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

			// Send message
			Transport.send(message, message.getAllRecipients());
			System.out.println("Sent message successfully....");

		} catch (MessagingException mex) {
			mex.printStackTrace();
		}
	}

}
