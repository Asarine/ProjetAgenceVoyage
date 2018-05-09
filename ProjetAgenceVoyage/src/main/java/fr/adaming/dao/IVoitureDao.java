package fr.adaming.dao;

import java.util.List;

import fr.adaming.model.Voiture;

public interface IVoitureDao {
	
	public Voiture addVoiture(Voiture vo);
	
	public void deleteVoiture(long idVo);
	
	public Voiture updateVoiture(Voiture vo);
	
	public Voiture getById(long idVo);
	
	public List<Voiture> getByMotCle(String mot);
	
	public List<Voiture> getAllVoiture();

}
