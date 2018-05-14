package fr.adaming.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.IDossierDao;
import fr.adaming.model.Dossier;

@Service
@Transactional
public class DossierServiceImpl implements IDossierService {
	
	@Autowired
	private IDossierDao dossierDao;

	@Override
	public Dossier addDossier(Dossier dos) {
		
		return dossierDao.addDossier(dos);
	}

	@Override
	public List<Dossier> getAllDossier() {
		
		return dossierDao.getAllDossier();
	}

	@Override
	public int updateDossier(Dossier dos) {
		
		return dossierDao.updateDossier(dos);
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
