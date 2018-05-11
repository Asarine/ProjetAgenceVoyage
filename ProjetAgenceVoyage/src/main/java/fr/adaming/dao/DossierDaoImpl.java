package fr.adaming.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import fr.adaming.model.Dossier;

@EnableTransactionManagement
@Repository
public class DossierDaoImpl implements IDossierDao {

	@PersistenceContext(unitName="PU")
	private EntityManager em;
	
	@Override
	public Dossier addDossier(Dossier dos) {
		
		em.persist(dos);
		
		return dos;
	}

	@Override
	public List<Dossier> getAllDossier() {
		
		// Cr�ation de la requ�te
		String req = "SELECT ds from Dossier ds";
		
		// Cr�ation du query
		Query query = em.createQuery(req);
		
		return query.getResultList();
	}

	@Override
	public int updateDossier(Dossier dos) {
		
		// Cr�ation de la requ�te
		String req = "UPDATE Dossier ds SET ds.statutdossier=:pStatutdossier WHERE ds.id=:pId";
		
		// Cr�ation du query
		Query query = em.createQuery(req);
		
		// Passage des params
		query.setParameter("pStatutdossier", dos.getStatutdossier());
		query.setParameter("pId", dos.getId());
		
		return query.executeUpdate();
	}

	@Override
	public int deleteDossier(long id) {
		
		// Cr�ation de la requ�te
		String req = "DELETE Dossier ds WHERE ds.id=:pId ";
		
		// Cr�ation du query
		Query query = em.createQuery(req);
		
		// Passage des params
		query.setParameter("pId", id);
		
		return query.executeUpdate();
	}

	@Override
	public Dossier getDossierById(long id) {
		
		// Cr�ation de la requ�te
		String req = "SELECT ds FROM Dossier ds WHERE ds.id=:pId";
		
		// Cr�ation du query
		Query query = em.createQuery(req);
		
		// Passage des params
		query.setParameter("pId", id);
		
		return (Dossier) query.getSingleResult();
	}

}
