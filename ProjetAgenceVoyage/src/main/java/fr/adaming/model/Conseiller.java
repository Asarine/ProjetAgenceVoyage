package fr.adaming.model;


import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="conseillers")
public class Conseiller implements Serializable {
	
	// Attributs
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id_co;
	private String nom;
	private String prenom;
	private String mail;
	private String mdp;
	
	@Column(columnDefinition= "TINYINT(1)")
	private boolean active;
	
	// Transformation de l'association UML en Java
	@OneToMany(mappedBy = "conseiller")
	private List<Service> listeService;
	
	@OneToMany(mappedBy = "conseiller")
	private List<Role> listeRole;

	// Constructeurs
	public Conseiller() {
		super();
	}

	public Conseiller(String nom, String prenom, String mail, String mdp, boolean active) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.mail = mail;
		this.mdp = mdp;
		this.active = active;
	}

	public Conseiller(int id_co, String nom, String prenom, String mail, String mdp, boolean active) {
		super();
		this.id_co = id_co;
		this.nom = nom;
		this.prenom = prenom;
		this.mail = mail;
		this.mdp = mdp;
		this.active = active;
	}

	// Getters et setters
	public long getId_co() {
		return id_co;
	}

	public void setId_co(long id_co) {
		this.id_co = id_co;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getMdp() {
		return mdp;
	}

	public void setMdp(String mdp) {
		this.mdp = mdp;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public List<Service> getListeService() {
		return listeService;
	}

	public void setListeService(List<Service> listeService) {
		this.listeService = listeService;
	}
	
	
	public List<Role> getListeRole() {
		return listeRole;
	}

	public void setListeRole(List<Role> listeRole) {
		this.listeRole = listeRole;
	}

	@Override
	public String toString() {
		return "Conseillers [id_co=" + id_co + ", nom=" + nom + ", prenom=" + prenom + ", mail=" + mail + ", mdp=" + mdp
				+ ", active=" + active + "]";
	}
	
	

}
