package fr.adaming.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="roles")
public class Role implements Serializable {
	
	// Attributs
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id_r;
	private String rolename;
	
	//Transformation de l'association UML en JAVA
	@ManyToOne
	@JoinColumn(name="co_id", referencedColumnName="id_co")
	private Conseiller conseiller;
//	
//	@ManyToOne
//	@JoinColumn(name="cl_id", referencedColumnName="id_cl")
//	private Client client;
	
	// Constructeurs
	
	public Role() {
		super();
	}

	public Role(String rolename) {
		super();
		this.rolename = rolename;
	}

	public Role(long id_r, String rolename) {
		super();
		this.id_r = id_r;
		this.rolename = rolename;
	}

	// Getters et setters
	public long getId_r() {
		return id_r;
	}

	public void setId_r(long id_r) {
		this.id_r = id_r;
	}

	public String getRolename() {
		return rolename;
	}

	public void setRolename(String rolename) {
		this.rolename = rolename;
	}
	

	public Conseiller getConseiller() {
		return conseiller;
	}

	public void setConseiller(Conseiller conseiller) {
		this.conseiller = conseiller;
	}

	@Override
	public String toString() {
		return "Role [id_r=" + id_r + ", rolename=" + rolename + "]";
	}

}
