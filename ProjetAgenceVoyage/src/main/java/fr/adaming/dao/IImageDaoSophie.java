package fr.adaming.dao;

import java.util.List;

import fr.adaming.model.Image;

public interface IImageDaoSophie {
	
	public void addImage(Image img);
	
	public List<Image> getImageByVoiture();

}
