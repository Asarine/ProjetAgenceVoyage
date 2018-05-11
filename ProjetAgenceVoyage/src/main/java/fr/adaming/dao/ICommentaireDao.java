package fr.adaming.dao;

import java.util.List;

import fr.adaming.model.Commentaire;

public interface ICommentaireDao {
	
	public Commentaire addCommentaire(Commentaire com);
	
	public void deleteCommentaire(long idCom);
	
	public void updateCommentaire(Commentaire com);
	
	public List<Commentaire> getAllCommentaires();
	
	public Commentaire getCommentaireById(long idCom);

}
