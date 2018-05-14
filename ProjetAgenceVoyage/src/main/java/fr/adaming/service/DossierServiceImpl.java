package fr.adaming.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.IDossierDao;
import fr.adaming.model.Dossier;
import fr.adaming.util.MailSendPdf;

@Service
@Transactional
public class DossierServiceImpl implements IDossierService {
	
	@Autowired
	private IDossierDao dossierDao;
	
	private MailSendPdf smpdf;

	@Override
	public Dossier addDossier(Dossier dos) {
		// Le dossier doit être examiné par Bovoyage
		dos.setStatutdossier("En attente");

		Dossier dOut = dossierDao.addDossier(dos);

		// Informer le client et le client
		if (dOut.getId() != 0) {
			smpdf.sendMail2Client(dos);
			smpdf.sendMail2Conseiller(dos);
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
					smpdf.genererPDF(dos);
				}

				// Prévenir le client de la modification
				smpdf.sendMail2Client(dos);
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


}
