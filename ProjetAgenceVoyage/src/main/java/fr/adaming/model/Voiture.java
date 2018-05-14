package fr.adaming.model;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "voitures")
public class Voiture implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id_vo")
	private Long id;
	private String categorie;
	private String loueur;
	
	@OneToOne(mappedBy="voitureLouer")
	private Formule formule;
	
	@OneToMany(cascade= CascadeType.DETACH)
	private List<Image> imageVo;

	
	@Transient
	private List<String> photos;
	
	
	


	public Formule getFormule() {
		return formule;
	}

	
	public void setFormule(Formule formule) {
		this.formule = formule;
	}

	public Voiture() {
		super();
	}

	public Voiture(String categorie, String loueur) {
		super();
		this.categorie = categorie;
		this.loueur = loueur;
	}

	public Voiture(Long id, String categorie, String loueur) {
		super();
		this.id = id;
		this.categorie = categorie;
		this.loueur = loueur;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCategorie() {
		return categorie;
	}

	public void setCategorie(String catégorie) {
		this.categorie = catégorie;
	}

	public String getLoueur() {
		return loueur;
	}

	public void setLoueur(String loueur) {
		this.loueur = loueur;
	}


	public List<Image> getImageVo() {
		return imageVo;
	}


	public void setImageVo(List<Image> imageVo) {
		this.imageVo = imageVo;
	}
	
	public List<String> getPhotos() {
		return photos;
	}

	public void setPhotos(List<String> photos) {
		this.photos = photos;
	}

	@Override
	public String toString() {
		return "Voiture [id=" + id + ", catégorie=" + categorie + ", loueur=" + loueur + "]";
	}

	
}
