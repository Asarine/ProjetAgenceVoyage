package fr.adaming.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import fr.adaming.model.Voiture;

@Repository
@EnableTransactionManagement
public class VoitureDaoImpl implements IVoitureDao{

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public Voiture addVoiture(Voiture vo) {
		em.persist(vo);
		return vo;
	}

	@Override
	public void deleteVoiture(long idVo) {
		Voiture vSupp=em.find(Voiture.class, idVo);
		em.remove(vSupp);
	}

	@Override
	public Voiture updateVoiture(Voiture vo) {
		Voiture vModif=em.find(Voiture.class, vo.getId());
		vModif.setCategorie(vo.getCategorie());
		vModif.setLoueur(vo.getLoueur());
		em.merge(vModif);
		return vModif;
	}

	@Override
	public Voiture getById(long idVo) {
		return em.find(Voiture.class, idVo);
	}


	@Override
	public List<Voiture> getAllVoiture() {
		String req="SELECT v FROM Voiture AS v";
		Query query=em.createQuery(req);
		return query.getResultList();
	}

	@Override
	public List<Voiture> getByMotCle(String mot) {
		String req="SELECT v FROM Voiture AS v WHERE v.categorie LIKE :pkeyword OR v.loueur LIKE :pkeyword";
		Query query=em.createQuery(req);
		query.setParameter("pkeyword", "%"+mot+"%");
		return query.getResultList();
	}

}
