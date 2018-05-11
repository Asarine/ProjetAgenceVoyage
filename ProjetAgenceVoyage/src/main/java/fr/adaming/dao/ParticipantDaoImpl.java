package fr.adaming.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import fr.adaming.model.Participant;

@Repository
@EnableTransactionManagement
public class ParticipantDaoImpl implements IParticipantDao {
	@PersistenceContext(name = "PU")
	private EntityManager em;

	@Override
	public int addParticipant(Participant p) {
		em.persist(p);

		if (p.getId() != 0) {
			return 1;
		} else {
			return 0;
		}
	}

	@Override
	public int updateParticipant(Participant p) {
		// Requete JPQL
		String req = "UPDATE Participant par SET par.prenom=:pPrenom, par.nom=:pNom, "
				+ "par.civilite=:pCivil, par.tel=:pTel, par.dn=:pDn, par.mail=:pMail, par.client.id=:pIdCl WHERE par.id=:pId";

		// Objet pour envoyer la requete
		Query query = em.createQuery(req);

		// Passage des parametres
		query.setParameter("pPrenom", p.getPrenom());
		query.setParameter("pNom", p.getNom());
		query.setParameter("pCivil", p.getPrenom());
		query.setParameter("pTel", p.getTel());
		query.setParameter("pDn", p.getDn());
		query.setParameter("pMail", p.getMail());
		query.setParameter("pIdCl ", p.getClient().getId());
		query.setParameter("pId", p.getId());

		// Envoyer la requete et récupérer le résultat
		int verif = query.executeUpdate();

		return verif;
	}

	@Override
	public int deleteParticipant(Long id) {
		// Trouver l'objet à supprimer
		Participant parOut = em.find(Participant.class, id);

		// Supprimer le participant
		em.remove(parOut);

		// Vérifier que le participant est bien supprimé
		Participant parTest = em.find(Participant.class, id);

		if (parTest == null) {
			return 1;
		} else {
			return 0;
		}
	}

	@Override
	public Participant searchParticipant(Long id) {
		// Requete JPQL
		String req = "SELECT par FROM Participant par WHERE par.id = :pId";

		// Objet pour envoyer la requete
		Query query = em.createQuery(req);

		// passage des parametres :
		query.setParameter("pId", id);

		// Envoyer la requete
		Participant p = (Participant) query.getSingleResult();
		return p;
	}

	@Override
	public List<Participant> getAllParticipant() {
		// Requete JPQL
		String req = "SELECT par FROM Participant par";

		// Objet pour envoyer la requete
		Query query = em.createQuery(req);

		// Envoyer la requete
		List<Participant> listeOut = query.getResultList();
		return listeOut;
	}

	@Override
	public List<Participant> getParticipantByClient(Long id) {
		// Requete JPQL
		String req = "SELECT par FROM Participant par WHERE par.client.id = :pId";
		
		// Objet pour envoyer la requete
		Query query = em.createQuery(req);
		
		// passage des parametres :
		query.setParameter("pId", id);
		
		// Envoyer la requete
		List<Participant> listeOut = query.getResultList();
		return listeOut;
	}
}
