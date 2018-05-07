package fr.adaming.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "destinations")
public class Destination implements Serializable {

	@Id
	@Column(name = "id_d")
	private int id;
	private String continent;
	private String pays;

	// Association UML en Java
	@OneToMany(mappedBy = "destination")
	private List<Voyage> listeVoyage;

	public List<Voyage> getListeVoyage() {
		return listeVoyage;
	}

	public void setListeVoyage(List<Voyage> listeVoyage) {
		this.listeVoyage = listeVoyage;
	}

	public Destination() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Destination(String continent, String pays) {
		super();
		this.continent = continent;
		this.pays = pays;
	}

	public Destination(int id, String continent, String pays) {
		super();
		this.id = id;
		this.continent = continent;
		this.pays = pays;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getContinent() {
		return continent;
	}

	public void setContinent(String continent) {
		this.continent = continent;
	}

	public String getPays() {
		return pays;
	}

	public void setPays(String pays) {
		this.pays = pays;
	}

	@Override
	public String toString() {
		return "Destination [id=" + id + ", continent=" + continent + ", pays=" + pays + "]";
	}

}
