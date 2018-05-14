package fr.adaming.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import fr.adaming.model.Client;
import fr.adaming.model.Conseiller;

@Repository
@EnableTransactionManagement
public class ConseillerDaoImpl implements IConseillerDao {
	@PersistenceContext(unitName = "PU")
	private EntityManager em;

	@Override
	public Conseiller getConseillerById(long id) {
		// Création de la requête
		String req = "SELECT c FROM Conseiller as c WHERE c.id=:pId";

		// Création du query
		Query query = em.createQuery(req);

		// Passage des params
		query.setParameter("pId", id);

		return (Conseiller) query.getSingleResult();
	}

}
