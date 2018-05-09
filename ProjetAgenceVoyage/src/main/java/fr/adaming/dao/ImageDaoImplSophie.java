package fr.adaming.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import fr.adaming.model.Image;

@Repository
@EnableTransactionManagement
public class ImageDaoImplSophie implements IImageDaoSophie {

	@PersistenceContext
	private EntityManager em;

	@Override
	public void addImage(Image img) {
		em.persist(img);
	}

	@Override
	public List<Image> getImageByVoiture() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
