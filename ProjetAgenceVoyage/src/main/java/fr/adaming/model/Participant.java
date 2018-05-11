package fr.adaming.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "participants")
public class Participant implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_p")
	private long id;
	private String prenom;
	private String nom;
	private String civilite;
	private String tel;
	@Temporal(TemporalType.DATE)
	private Date dn;
	private String mail;

	// Transformation UML en Java
	@ManyToOne
	@JoinColumn(name = "cl_id", referencedColumnName = "id_cl")
	private Client client;
	
	@ManyToMany
	@JoinTable(name = "p_dos_jointure", joinColumns = @JoinColumn(name = "p_id"), inverseJoinColumns = @JoinColumn(name = "dos_id"))
	private List<Dossier> dossiers;
	
//	@JoinColumn(name = "p_id", referencedColumnName = "id_p")
	
	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	// Constructeurs
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

	// G+S
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

	// Generate to String
	@Override
	public String toString() {
		return "Participant [id=" + id + ", prenom=" + prenom + ", nom=" + nom + ", civilite=" + civilite + ", tel="
				+ tel + ", dn=" + dn + ", mail=" + mail + "]";
	}

}
