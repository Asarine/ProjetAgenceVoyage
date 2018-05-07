package fr.adaming.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="participants")
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="statut")
public class Participant implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_p")
	private long id;
	private String prenom;
	private String nom;
	private String civilite;
	private String tel;
	@Temporal(TemporalType.DATE)
	private Date dn;
	private String mail;
	
	
	//Constructeurs
	public Participant() {
		super();
	}
	public Participant(String prenom, String nom, String civilite, String tel, Date dn, String mail) {
		super();
		this.prenom = prenom;
		this.nom = nom;
		this.civilite = civilite;
		this.tel = tel;
		this.dn = dn;
		this.mail = mail;
	}
	public Participant(long id, String prenom, String nom, String civilite, String tel, Date dn, String mail) {
		super();
		this.id = id;
		this.prenom = prenom;
		this.nom = nom;
		this.civilite = civilite;
		this.tel = tel;
		this.dn = dn;
		this.mail = mail;
	}
	
	
	//G+S
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getCivilite() {
		return civilite;
	}
	public void setCivilite(String civilite) {
		this.civilite = civilite;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public Date getDn() {
		return dn;
	}
	public void setDn(Date dn) {
		this.dn = dn;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	//Generate to String
	@Override
	public String toString() {
		return "Participant [id=" + id + ", prenom=" + prenom + ", nom=" + nom + ", civilite=" + civilite + ", tel="
				+ tel + ", dn=" + dn + ", mail=" + mail + "]";
	}
	
	
	

}
