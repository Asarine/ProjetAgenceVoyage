package fr.adaming.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="voyages")
public class Voyage implements Serializable {
	
	//déclaration des attributs :
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id_v;
	private Date dateD;
	private Date dateR;
	private int nbPlaces;
	private int tarif;
	private String disponibilite;
	@Column(columnDefinition = "TINYINT(1)")
	private boolean assurance;
	
	//transformation des associations uml en java :
	
	  //avec hebergement :
	
	  //avec destination :
	  
	 //avec formule :
	
	
	//constructeurs :

	public Voyage() {
		super();
	}
	public Voyage(Date dateD, Date dateR, int nbPlaces, int tarif, String disponibilite, boolean assurance) {
		super();
		this.dateD = dateD;
		this.dateR = dateR;
		this.nbPlaces = nbPlaces;
		this.tarif = tarif;
		this.disponibilite = disponibilite;
		this.assurance = assurance;
	}
	public Voyage(long id_v, Date dateD, Date dateR, int nbPlaces, int tarif, String disponibilite, boolean assurance) {
		super();
		this.id_v = id_v;
		this.dateD = dateD;
		this.dateR = dateR;
		this.nbPlaces = nbPlaces;
		this.tarif = tarif;
		this.disponibilite = disponibilite;
		this.assurance = assurance;
	}
	
	
	
	//les getters et les setters :

	public long getId_v() {
		return id_v;
	}
	public void setId_v(long id_v) {
		this.id_v = id_v;
	}
	public Date getDateD() {
		return dateD;
	}
	public void setDateD(Date dateD) {
		this.dateD = dateD;
	}
	public Date getDateR() {
		return dateR;
	}
	public void setDateR(Date dateR) {
		this.dateR = dateR;
	}
	public int getNbPlaces() {
		return nbPlaces;
	}
	public void setNbPlaces(int nbPlaces) {
		this.nbPlaces = nbPlaces;
	}
	public int getTarif() {
		return tarif;
	}
	public void setTarif(int tarif) {
		this.tarif = tarif;
	}
	public String getDisponibilite() {
		return disponibilite;
	}
	public void setDisponibilite(String disponibilite) {
		this.disponibilite = disponibilite;
	}
	public boolean isAssurance() {
		return assurance;
	}
	public void setAssurance(boolean assurance) {
		this.assurance = assurance;
	}
	
	
	//méthodes toString sans les attributs d'associations:
	@Override
	public String toString() {
		return "Voyage [id_v=" + id_v + ", dateD=" + dateD + ", dateR=" + dateR + ", nbPlaces=" + nbPlaces + ", tarif="
				+ tarif + ", disponibilite=" + disponibilite + ", assurance=" + assurance + "]";
	}
	
	
	
	
	
	
	
	
	

}
