package fr.adaming.model;

import java.io.Serializable;
import java.util.Arrays;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "voitures")
public class Voiture implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id_vo")
	private Long id;
	private String catégorie;
	private String loueur;
	@Lob
	private byte[] photo;
//	
//	@OneToOne
//	private Formule formule;
//
//	public Formule getFormule() {
//		return formule;
//	}
//
//	public void setFormule(Formule formule) {
//		this.formule = formule;
//	}

	public Voiture() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Voiture(String catégorie, String loueur, byte[] photo) {
		super();
		this.catégorie = catégorie;
		this.loueur = loueur;
		this.photo = photo;
	}

	public Voiture(int id, String catégorie, String loueur, byte[] photo) {
		super();
		this.id = id;
		this.catégorie = catégorie;
		this.loueur = loueur;
		this.photo = photo;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCatégorie() {
		return catégorie;
	}

	public void setCatégorie(String catégorie) {
		this.catégorie = catégorie;
	}

	public String getLoueur() {
		return loueur;
	}

	public void setLoueur(String loueur) {
		this.loueur = loueur;
	}

	public byte[] getPhoto() {
		return photo;
	}

	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}

	@Override
	public String toString() {
		return "Voiture [id=" + id + ", catégorie=" + catégorie + ", loueur=" + loueur + "]";
	}

	
}
