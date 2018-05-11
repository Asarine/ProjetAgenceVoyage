package fr.adaming.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "clients")
public class Client implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_cl")
	private long id;
	private String prenom;
	private String nom;
	private String civilite;
	private String tel;
	@Temporal(TemporalType.DATE)
	private Date dn;
	private String mail;
	private String numcb;
	private String mdp;

	// transformation UML en Java
//	@ManyToOne
//	@JoinColumn(name = "v_id", referencedColumnName = "id_v")
//	private Voyage voyage;

	@ManyToOne
	@JoinColumn(name = "co_id", referencedColumnName = "id_co")
	private Conseiller conseiller;

	@OneToMany(mappedBy = "client")
	private List<Service> listeService;

	@OneToMany(mappedBy = "client")
	private List<Participant> listeParticipant;

	@OneToMany(mappedBy="clientDos")
	private List<Dossier> dossier;

	public Client() {
		super();
	}

	public Client(String prenom, String nom, String civilite, String tel, Date dn, String mail, String numcb,
			String mdp) {
		super();
		this.prenom = prenom;
		this.nom = nom;
		this.civilite = civilite;
		this.tel = tel;
		this.dn = dn;
		this.mail = mail;
		this.numcb = numcb;
		this.mdp = mdp;
	}

	public Client(long id, String prenom, String nom, String civilite, String tel, Date dn, String mail, String numcb,
			String mdp) {
		super();
		this.id = id;
		this.prenom = prenom;
		this.nom = nom;
		this.civilite = civilite;
		this.tel = tel;
		this.dn = dn;
		this.mail = mail;
		this.numcb = numcb;
		this.mdp = mdp;
	}

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

	public String getNumcb() {
		return numcb;
	}

	public void setNumcb(String numcb) {
		this.numcb = numcb;
	}

	public String getMdp() {
		return mdp;
	}

	public void setMdp(String mdp) {
		this.mdp = mdp;
	}

//	public Voyage getVoyage() {
//		return voyage;
//	}
//
//	public void setVoyage(Voyage voyage) {
//		this.voyage = voyage;
//	}

	public Conseiller getConseiller() {
		return conseiller;
	}

	public void setConseiller(Conseiller conseiller) {
		this.conseiller = conseiller;
	}

	public List<Service> getListeService() {
		return listeService;
	}

	public void setListeService(List<Service> listeService) {
		this.listeService = listeService;
	}

	public List<Participant> getListeParticipant() {
		return listeParticipant;
	}

	public void setListeParticipant(List<Participant> listeParticipant) {
		this.listeParticipant = listeParticipant;
	}

	public List<Dossier> getDossier() {
		return dossier;
	}

	public void setDossier(List<Dossier> dossier) {
		this.dossier = dossier;
	}

	@Override
	public String toString() {
		return "Client [id=" + id + ", prenom=" + prenom + ", nom=" + nom + ", civilite=" + civilite + ", tel=" + tel
				+ ", dn=" + dn + ", mail=" + mail + ", numcb=" + numcb + ", mdp=" + mdp + "]";
	}

}
