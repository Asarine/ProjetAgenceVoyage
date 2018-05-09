package fr.adaming.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import fr.adaming.model.Formule;

@EnableTransactionManagement
@Repository
public class FormuleDaoImpl implements IFormuleDao{
	
	@PersistenceContext(unitName = "PU")
	private EntityManager em;

	public void setEm(EntityManager em) {
		this.em = em;
	}

	@Override
	public List<Formule> getAllFormule() {
		// requete jpql :
		String req = "select f from Formule as f";
		
		//création d'un query :
				Query query=em.createQuery(req);
				
		List<Formule> listeForm=query.getResultList();		 
		
		return listeForm;
	}

	@Override
	public Formule addFormule(Formule f) {
		em.persist(f);
		return f;
	}

	@Override
	public int updateFormule(Formule f) {
		// requete jpql :
		String req="update Formule as f set f.avion=:pAvion, f.hotel=:pHotel, f.voiture=:pVoiture, f.voitureLouer.id=:pIdVoitureLouer where f.id_f=:pId";
		
		//création d'un query :
		Query query=em.createQuery(req);
		
		//passage des paramètres :
		query.setParameter("pAvion", f.isAvion());
		query.setParameter("pHotel", f.isHotel());
		query.setParameter("pVoiture", f.isVoiture());
		query.setParameter("pIdVoitureLouer", f.getVoitureLouer().getId());
		query.setParameter("pId", f.getId_f());


		
		return (int) query.executeUpdate();
	}

	@Override
	public int deleteFormule(Formule f) {
		// requete jpql :
		String req="delete from Formule as f where f.id_f=:pId";
		
		//création du query:
				Query query= em.createQuery(req);
				
		//passage des parametres :
		query.setParameter("pId", f.getId_f());
		
		return (int) query.executeUpdate();
	}

	@Override
	public Formule getFormuleById(Formule f) {
		// requete jpql :
		String req= "select f from Formule as f where f.id_f=:pId";
		
		//création du query:
		Query query= em.createQuery(req);
		
   //passage des parametres :
     query.setParameter("pId", f.getId_f());

		return (Formule) query.getSingleResult();
	}
	
	

}
