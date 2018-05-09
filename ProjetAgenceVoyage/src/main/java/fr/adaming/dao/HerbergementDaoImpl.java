package fr.adaming.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import fr.adaming.model.Hebergement;

@Repository
@EnableTransactionManagement
public class HerbergementDaoImpl implements IHebergementDao {

	@PersistenceContext
	private EntityManager em;

	@Override
	public List<Hebergement> getAllhebergment() {
		String req = "SELECT hbg FROM Hebergement hbg";
		Query q = em.createQuery(req);
		return q.getResultList();
	}

	@Override
	public Hebergement addhebergement(Hebergement hbg) {
		em.persist(hbg);
		return hbg;
	}

	@Override
	public long updatehebergement(Hebergement hbg) {
		String req = "UPDATE Herbergement as hbg SET hbg.selectionhbg=:pSlcHbg WHERE hbg.id_h=:pId";
		Query q = em.createQuery(req);
		q.setParameter("pId", hbg.getId_h());
		long verif = q.executeUpdate();

		return verif;
	}

	@Override
	public long deletehebergement(long id_h) {
		String req = "DELETE FROM Hergement as hbg WHERE hbg.id_h=:pId";
		Query q = em.createQuery(req);
		q.setParameter("pId", id_h);
		long verif = q.executeUpdate();
		return verif;
	}

	@Override
	public Hebergement findhebergementById(long id_h) {
		String req = "SELECT hbg FROM Hebergement as hbg WHERE hbg.id_h=:pId";
		Query q = em.createQuery(req);
		q.setParameter("pId", id_h);
		return (Hebergement) q.getSingleResult();
	}

}
