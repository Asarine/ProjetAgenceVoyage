package fr.adaming.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.commons.codec.binary.Base64;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import fr.adaming.model.Destination;
import fr.adaming.model.Image;

@Repository
@EnableTransactionManagement
public class DestinationDaoImpl implements IDestinationDao {

	@PersistenceContext
	private EntityManager em;

	@Override
	public Destination addDestination(Destination ds) {
		for (Image image : ds.getListeImage()) {
			em.persist(image);
		}

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
		Destination dest = em.find(Destination.class, id_d);
		List<String> images = new ArrayList<String>();

		for (Image photo : dest.getListeImage()) {
			String img = "data:image/png;base64," + Base64.encodeBase64String(photo.getContents());
			images.add(img);
		}
		dest.setPhotos(images);

		return dest;
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
		String req = "SELECT ds FROM Destination ds";
		Query query = em.createQuery(req);

		List<Destination> listeDs = query.getResultList();
		
		for (Destination dest : listeDs) {
			List<String> images = new ArrayList<String>();

			for (Image photo : dest.getListeImage()) {
				String img = "data:image/png;base64," + Base64.encodeBase64String(photo.getContents());
				images.add(img);
			}
			dest.setPhotos(images);
		}
		return listeDs;
	}

}
