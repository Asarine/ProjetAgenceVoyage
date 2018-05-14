package fr.adaming.model;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "destinations")
public class Destination implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id_d")
	private Long id;
	private String continent;
	private String pays;

	
	@Transient
	private List<String> photos;
	
	//association avec image :
	@OneToMany(cascade= CascadeType.DETACH)
	private List<Image> listeImage;
	
	
	// Association UML en Java
	@OneToMany(mappedBy = "destination", cascade= CascadeType.DETACH)
	private List<Voyage> listeVoyage;

	public List<Voyage> getListeVoyage() {
		return listeVoyage;
	}

	public void setListeVoyage(List<Voyage> listeVoyage) {
		this.listeVoyage = listeVoyage;
	}

	public Destination() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Destination(String continent, String pays) {
		super();
		this.continent = continent;
		this.pays = pays;
	}

	public Destination(Long id, String continent, String pays) {
		super();
		this.id = id;
		this.continent = continent;
		this.pays = pays;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getContinent() {
		return continent;
	}

	public void setContinent(String continent) {
		this.continent = continent;
	}

	public String getPays() {
		return pays;
	}

	public void setPays(String pays) {
		this.pays = pays;
	}
	
	

	public List<Image> getListeImage() {
		return listeImage;
	}

	public void setListeImage(List<Image> listeImage) {
		this.listeImage = listeImage;
	}
	
	
	

	public List<String> getPhotos() {
		return photos;
	}

	public void setPhotos(List<String> photos) {
		this.photos = photos;
	}

	@Override
	public String toString() {
		return "Destination [id=" + id + ", continent=" + continent + ", pays=" + pays + "]";
	}

}
