package fr.adaming.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.IImageDaoSophie;
import fr.adaming.model.Image;

@Service
@Transactional
public class ImageServiceImpl implements IImageService{
	
	@Autowired
	private IImageDaoSophie imageDao;

	@Override
	public void addImage(Image img) {
		imageDao.addImage(img);
		
	}

	@Override
	public List<Image> getImageByVoiture() {
		// TODO Auto-generated method stub
		return null;
	}

}
