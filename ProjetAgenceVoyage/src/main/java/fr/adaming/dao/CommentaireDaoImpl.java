package fr.adaming.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import fr.adaming.model.Commentaire;

@Repository
@EnableTransactionManagement
public class CommentaireDaoImpl implements ICommentaireDao {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public Commentaire addCommentaire(Commentaire com) {
		em.persist(com);
		return com;
		
	}

	@Override
	public void deleteCommentaire(long idCom) {
		String req="DELETE Commentaire AS com WHERE com.id=:pId";
		Query query=em.createQuery(req);
		query.setParameter("pId", idCom);
		query.executeUpdate();
		
	}

	@Override
	public void updateCommentaire(Commentaire com) {
		String req="UPDATE Commentaire AS com SET com.contenu=:pContenu, com.signalements=:pSignalement, com.note=:pNote WHERE com.id=:pId";
		Query query=em.createQuery(req);
		query.setParameter("pContenu", com.getContenu());
		query.setParameter("pSignalement", com.getSignalements());
		query.setParameter("pNote", com.getNote());
		query.setParameter("pId", com.getIdCom());
		query.executeUpdate();
		
	}

	@Override
	public List<Commentaire> getAllCommentaires() {
		String req="SELECT com FROM Commentaire AS com";
		Query query=em.createQuery(req);
		return query.getResultList();
	}

	@Override
	public Commentaire getCommentaireById(long idCom) {
		String req="SELECT com FROM Commentaire AS com WHERE com.id=:pId";
		Query query=em.createQuery(req);
		query.setParameter("pId", idCom);
		return (Commentaire) query.getSingleResult();
	}

}
