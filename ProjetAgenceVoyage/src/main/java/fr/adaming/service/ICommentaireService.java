package fr.adaming.service;

import java.util.List;

import fr.adaming.model.Commentaire;

public interface ICommentaireService {
	
	public Commentaire addCommentaire(Commentaire com);
	
	public void signalerCommentaire(long id);
	
	public List<Commentaire> getAllCommentaires();

}
