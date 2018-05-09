package fr.adaming.service;

import java.util.List;

import fr.adaming.model.Hebergement;

public interface IHebergementService {
	
	public List<Hebergement> getAllhebergment();
	public Hebergement addhebergement(Hebergement hbg);
	public long updatehebergement(Hebergement hbg);
	public long deletehebergement(long id_h);
	public Hebergement findhebergementById(long id_h);

}
