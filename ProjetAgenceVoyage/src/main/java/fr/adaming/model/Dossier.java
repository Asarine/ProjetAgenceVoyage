package fr.adaming.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "dossiers")
public class Dossier implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_dos")
	private long id;
	private String statutdossier;

	// Constructeurs
	public Dossier() {
		super();
	}

	public Dossier(String statutdossier) {
		super();
		this.statutdossier = statutdossier;
	}

	public Dossier(long id, String statutdossier) {
		super();
		this.id = id;
		this.statutdossier = statutdossier;
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
	
	
	

}
