package fr.adaming.dao;

import java.util.List;

import fr.adaming.model.Voyage;

public interface IVoyageDao {
	
	public List<Voyage> getAllVoyage();
	public Voyage addVoyage (Voyage v);
	public int updateVoyage (Voyage v);
	public int deleteVoyage (Voyage v);
	public Voyage getVoyageById (Voyage v);

}
