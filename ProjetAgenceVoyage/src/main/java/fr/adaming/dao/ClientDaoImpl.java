package fr.adaming.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import fr.adaming.model.Client;

@EnableTransactionManagement
@Repository
public class ClientDaoImpl implements IClientDao {
	
	@PersistenceContext(unitName="PU")
	private EntityManager em;
		

	@Override
	public Client addClient(Client cl) {
		
		em.persist(cl);
		
		return cl;
	}

	@Override
	public List<Client> getAllClient() {
		
		// Création de la requête
		String req = "SELECT cl FROM Client cl";
		
		// Création du query
		Query query=em.createQuery(req);
		
		return query.getResultList();
	}

	@Override
	public int updateClient(Client cl) {
		
		// Création de la requête
		String req="UPDATE Client cl SET cl.nom=:pNom, cl.prenom=:pPrenom, cl.civilite=:pCivilite, cl.tel=:pTel, cl.dn=:pDn, cl.mail=:pMail, cl.numcb=:pNumcb, cl.mdp=:pMdp WHERE cl.id=:pId";
		
		// Création du query
		Query query =em.createQuery(req);
		
		// Passage des params
		query.setParameter("pNom", cl.getNom());
		query.setParameter("pPrenom", cl.getPrenom());
		query.setParameter("pCivilite", cl.getCivilite());
		query.setParameter("pTel", cl.getTel());
		query.setParameter("pDn", cl.getDn());
		query.setParameter("pMail", cl.getMail());
		query.setParameter("pNumcb", cl.getNumcb());
		query.setParameter("pMdp", cl.getMdp());
		query.setParameter("pId", cl.getId());
		
		return query.executeUpdate();
	}

	@Override
	public int deleteClient(long id) {
	
		String req="DELETE  Client cl WHERE cl.id=:pId";
		
		Query query=em.createQuery(req);
		
		query.setParameter("pId", id);
		
		return query.executeUpdate();
	}

	@Override
	public Client getClientById(long id) {
		
		// Création de la requête
		String req="SELECT cl FROM Client as cl WHERE cl.id=:pId";
		
		// Création du query
		Query query=em.createQuery(req);
		
		// Passage des params
		query.setParameter("pId", id);

		
		return (Client) query.getSingleResult();
	}
	
	

}
