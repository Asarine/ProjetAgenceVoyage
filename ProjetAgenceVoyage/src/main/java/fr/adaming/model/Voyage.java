package fr.adaming.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
@Table(name = "voyages")
public class Voyage implements Serializable {

	// d�claration des attributs :
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id_v;
	@Temporal(TemporalType.DATE)
	private Date dateD;
	@Temporal(TemporalType.DATE)
	private Date dateR;
	private int nbPlaces;
	private int tarif;
	private String disponibilite;

	// transformation des associations uml en java :

	// avec hebergement :
	@ManyToOne
	@JoinColumn(name = "h_id", referencedColumnName = "id_h")
	private Hebergement hebergement;

	// avec destination :
	@ManyToOne
	@JoinColumn(name = "d_id", referencedColumnName = "id_d")
	private Destination destination;

	// avec formule :
	@ManyToOne
	@JoinColumn(name = "f_id", referencedColumnName = "id_f")
	private Formule formule;

	// association avec image :
	@OneToMany(cascade = CascadeType.DETACH)
	private List<Image> listeImage;

	@Transient
	private List<String> photos;

	/*
	 * @OneToMany(mappedBy="voyage") private List<Client> client;
	 */

	// @ManyToMany(mappedBy="voyagesDos")
	// private List<Dossier> listeDossier;

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

	@OneToMany(mappedBy = "voyageDos")
	private List<Dossier> listeDossier;

	// les constructeurs :

	public Voyage() {
		super();
	}

	public Voyage(Date dateD, Date dateR, int nbPlaces, int tarif, String disponibilite) {
		super();
		this.dateD = dateD;
		this.dateR = dateR;
		this.nbPlaces = nbPlaces;
		this.tarif = tarif;
		this.disponibilite = disponibilite;
	}

	public Voyage(long id_v, Date dateD, Date dateR, int nbPlaces, int tarif, String disponibilite) {
		super();
		this.id_v = id_v;
		this.dateD = dateD;
		this.dateR = dateR;
		this.nbPlaces = nbPlaces;
		this.tarif = tarif;
		this.disponibilite = disponibilite;
	}

	// les getters et les setters :

	public long getId_v() {
		return id_v;
	}

	public Hebergement getHebergement() {
		return hebergement;
	}

	public void setHebergement(Hebergement hebergement) {
		this.hebergement = hebergement;
	}

	public Destination getDestination() {
		return destination;
	}

	public void setDestination(Destination destination) {
		this.destination = destination;
	}

	public Formule getFormule() {
		return formule;
	}

	public void setFormule(Formule formule) {
		this.formule = formule;
	}

	/*
	 * public List<Client> getClient() { return client; } public void
	 * setClient(List<Client> client) { this.client = client; }
	 */
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

	public List<Dossier> getListeDossier() {
		return listeDossier;
	}

	public void setListeDossier(List<Dossier> listeDossier) {
		this.listeDossier = listeDossier;
	}

	// m�thodes toString sans les attributs d'associations:
	@Override
	public String toString() {
		return "Voyage [id_v=" + id_v + ", dateD=" + dateD + ", dateR=" + dateR + ", nbPlaces=" + nbPlaces + ", tarif="
				+ tarif + ", disponibilite=" + disponibilite + "]";
	}

}
