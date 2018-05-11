package fr.adaming.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.JoinColumn;

@Entity
@Table(name = "dossiers")
public class Dossier implements Serializable {

	// Attributs
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_dos")
	private long id;
	private String statutdossier;
	@Column(columnDefinition = "TINYINT(1)")
	private boolean assurance;
	private double prixTotal;
	
	// Transformation de l'association UML en JAVA
	@ManyToMany
	@JoinTable(name="voy_dos_jointure", joinColumns=@JoinColumn(name="dos_id"),inverseJoinColumns=@JoinColumn(name="voy_id"))
	private List<Client> clientDos;
	
	@ManyToMany
	@JoinTable(name="cl_dos_jointure", joinColumns=@JoinColumn(name="dos_id"),inverseJoinColumns=@JoinColumn(name="cl_id"))
	private List<Voyage> voyagesDos;

	// Constructeurs
	public Dossier() {
		super();
	}

	public Dossier(String statutdossier, boolean assurance,double prixTotal) {
		super();
		this.statutdossier = statutdossier;
		this.assurance = assurance;
		this.prixTotal=prixTotal;
	}

	public Dossier(long id, String statutdossier, boolean assurance, double prixTotal) {
		super();
		this.id = id;
		this.statutdossier = statutdossier;
		this.assurance = assurance;
		this.prixTotal=prixTotal;
	}

	//G+S
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getStatutdossier() {
		return statutdossier;
	}

	public void setStatutdossier(String statutdossier) {
		this.statutdossier = statutdossier;
	}

	
	public boolean isAssurance() {
		return assurance;
	}

	public void setAssurance(boolean assurance) {
		this.assurance = assurance;
	}
	
	

	public double getPrixTotal() {
		return prixTotal;
	}

	public void setPrixTotal(double prixTotal) {
		this.prixTotal = prixTotal;
	}

	public List<Client> getClientDos() {
		return clientDos;
	}

	public void setClientDos(List<Client> clientDos) {
		this.clientDos = clientDos;
	}

	public List<Voyage> getVoyagesDos() {
		return voyagesDos;
	}

	public void setVoyagesDos(List<Voyage> voyagesDos) {
		this.voyagesDos = voyagesDos;
	}
	
	
	

}
