package fr.adaming.model;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public class Fichiers {
	
	private List<MultipartFile> images;

	public Fichiers(List<MultipartFile> images) {
		super();
		this.images = images;
	}

	public Fichiers() {
		super();
	}

	public List<MultipartFile> getImages() {
		return images;
	}

	public void setImages(List<MultipartFile> images) {
		this.images = images;
	}
	
	

}
