package fr.adaming.service;

import java.util.List;

import fr.adaming.model.Dossier;

public interface IDossierService {
	
	public Dossier addDossier(Dossier dos);
	
	public List<Dossier> getAllDossier();
	
	public int updateDossier(Dossier dos);
	
	public int deleteDossier(long id);
	
	public Dossier getDossierById(long id);
	
	public List<Dossier> getDossiersByIdClient(long idCl);


}
