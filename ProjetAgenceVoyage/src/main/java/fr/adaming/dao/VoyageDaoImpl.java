
package fr.adaming.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import fr.adaming.model.Voyage;

 @EnableTransactionManagement
@Repository
public class VoyageDaoImpl implements IVoyageDao {
	
	@PersistenceContext(unitName = "PU")
	private EntityManager em;
	
	

	public void setEm(EntityManager em) {
		this.em = em;
	}

	
	@Override
	public List<Voyage> getAllVoyage() {
		// requete jpql :
		String req= "Select v from Voyage as v";
		
		//création d'un query :
		Query query=em.createQuery(req);
		
		List<Voyage> listeVoy=query.getResultList();
		
		return listeVoy;
	}

	@Override
	public Voyage addVoyage(Voyage v) {
		
		em.persist(v);
		return v;
	}

	@Override
	public int updateVoyage(Voyage v) {
		// requete jpql :
		String req ="update Voyage as v set v.dateD=:pDateD , v.dateR=:pDateR,"
				+ "v.nbPlaces=:pNbPlaces, v.tarif=:pTarif,"
				+ "v.disponibilite=:pDisponibilite, v.assurance=:pAssurance,"
				+ "v.hebergement.id_h=:pHebergementId,"
				+ "v.destination.id=:pDestinationId,"
				+ "v.formule.id_f=:pFormuleId where v.id_v=:pId";
		
		//creation du query :
		Query query= em.createQuery(req);

		//passage des parametres :
		query.setParameter("pDateD", v.getDateD());
		query.setParameter("pDateR", v.getDateR());
		query.setParameter("pNbPlaces", v.getNbPlaces());
		query.setParameter("pTarif", v.getTarif());
		query.setParameter("pDisponibilite", v.getDisponibilite());
		query.setParameter("pAssurance", v.isAssurance());
		query.setParameter("pHebergementId", v.getHebergement().getId_h());
		query.setParameter("pDestinationId", v.getDestination().getId());
		query.setParameter("pFormuleId", v.getFormule().getId_f());
		query.setParameter("pId", v.getId_v());


		return (int) query.executeUpdate();
	}

	@Override
	public int deleteVoyage(Voyage v) {
		// requete JPQL :
		String req="delete from Voyage as v where v.id_v=:pId";
		
		//création du query:
		Query query= em.createQuery(req);
		
		//passage des parametres :
		query.setParameter("pId", v.getId_v());
		
		return (int) query.executeUpdate();
	}

	@Override
	public Voyage getVoyageById(Voyage v) {
		// requete jpql
		String req ="select v from Voyage as v where v.id_v=:pId";
		
		//création du query:
		Query query= em.createQuery(req);
		
		//passage des paramètres :
		query.setParameter("pId", v.getId_v());
		
		return (Voyage) query.getSingleResult();
	}

	

	@Override
	public List<Voyage> getbymotcle(String mc) {
		String req="FROM Voyage v WHERE v.destination.continent LIKE :pMc OR v.destination.pays LIKE :pMc OR v.disponibilite LIKE :pMc";
		Query q=em.createQuery(req);
		q.setParameter("pMc", "%"+mc+"%");
		return q.getResultList();
	}

	
}
