package fr.adaming.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import fr.adaming.model.Destination;

@Repository
@EnableTransactionManagement
public class DestinationDaoImpl implements IDestinationDao {

	@PersistenceContext
	private EntityManager em;

	@Override
	public Destination addDestination(Destination ds) {
		em.persist(ds);
		return ds;
	}

	@Override
	public long updateDestination(Destination ds) {
		String req = "UPDATE Destination ds SET ds.continent=:pContinent, ds.pays=:pPays WHERE ds.id=:pId";
		Query query = em.createQuery(req);

		query.setParameter("pContinent", ds.getContinent());
		query.setParameter("pPays", ds.getPays());
		query.setParameter("pId", ds.getId());
		int verif = query.executeUpdate();

		return verif;
	}

	@Override
	public Destination getDestinationbyId(long id_d) {
		String req="SELECT ds FROM Destination as ds WHERE ds.id=:pId";
		Query query=em.createQuery(req);
		query.setParameter("pId", id_d);
		return (Destination) query.getSingleResult();
	}

	@Override
	public long deleteDestination(long id_d) {

		String req = "DELETE FROM Destination as ds WHERE ds.id=:pId";
		Query query = em.createQuery(req);
		query.setParameter("pId", id_d);
		int verif = query.executeUpdate();
		return verif;
	}

	
	@Override
	public List<Destination> getAllDestination() {
		String req="SELECT ds FROM Destination ds";
		Query query=em.createQuery(req);
		return query.getResultList();
	}

}
