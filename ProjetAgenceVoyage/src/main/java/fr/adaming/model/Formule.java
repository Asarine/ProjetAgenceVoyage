package fr.adaming.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="formules")
public class Formule implements Serializable {
	
	//Attributs :
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id_f;
	@Column(columnDefinition = "TINYINT(1)")
	private boolean avion;
	@Column(columnDefinition = "TINYINT(1)")
	private boolean hotel;
	@Column(columnDefinition = "TINYINT(1)")
	private boolean voiture;
	
	
	
	//transformation des associations uml en java :
	
	  //avec voyage :
	@OneToMany(mappedBy="formule" , cascade= CascadeType.REMOVE, fetch=FetchType.EAGER)
	private List<Voyage> listeVoyage;
	
	
	 //avec voiture :
	@OneToOne
	@JoinColumn(name="vo_id", referencedColumnName="id_vo")
	private Voiture voitureLouer;
	
	
	
	//constructeurs :	
	public Formule() {
		super();
	}



	public Formule(boolean avion, boolean hotel, boolean voiture) {
		super();
		this.avion = avion;
		this.hotel = hotel;
		this.voiture = voiture;
	}



	public Formule(long id_f, boolean avion, boolean hotel, boolean voiture) {
		super();
		this.id_f = id_f;
		this.avion = avion;
		this.hotel = hotel;
		this.voiture = voiture;
	}


	//getters et setters :
	
	
	public long getId_f() {
		return id_f;
	}



	public List<Voyage> getListeVoyage() {
		return listeVoyage;
	}



	public void setListeVoyage(List<Voyage> listeVoyage) {
		this.listeVoyage = listeVoyage;
	}



	public Voiture getVoitureLouer() {
		return voitureLouer;
	}



	public void setVoitureLouer(Voiture voitureLouer) {
		this.voitureLouer = voitureLouer;
	}



	public void setId_f(long id_f) {
		this.id_f = id_f;
	}



	public boolean isAvion() {
		return avion;
	}



	public void setAvion(boolean avion) {
		this.avion = avion;
	}



	public boolean isHotel() {
		return hotel;
	}



	public void setHotel(boolean hotel) {
		this.hotel = hotel;
	}



	public boolean isVoiture() {
		return voiture;
	}



	public void setVoiture(boolean voiture) {
		this.voiture = voiture;
	}



	//méthode to string sans les attributs des associations :

	@Override
	public String toString() {
		return "Formule [id_f=" + id_f + ", avion=" + avion + ", hotel=" + hotel + ", voiture=" + voiture + "]";
	}
		
	

}
