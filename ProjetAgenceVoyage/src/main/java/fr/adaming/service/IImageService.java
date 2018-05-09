package fr.adaming.service;

import java.util.List;

import fr.adaming.model.Image;

public interface IImageService {
	
	public void addImage(Image img);
	
	public List<Image> getImageByVoiture();

}
