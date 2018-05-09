package fr.adaming.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "hebergements")
public class Hebergement implements Serializable {

	/**
	*
	*/
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id_h;
	// @Column(columnDefinition= "TINYINT(1)")
	// private boolean pdj;
	// @Column(columnDefinition= "TINYINT(1)")
	// private boolean dj;
	// @Column(columnDefinition= "TINYINT(1)")
	// private boolean diner;
	private String selectionhbg;

	// Transformation association
	@OneToMany(mappedBy = "hebergement")
	List<Voyage> listevoyage;

	// Constructeurs

	public Hebergement() {
		super();
	}

	public Hebergement(long id_h, String selectionhbg) {
		super();
		this.id_h = id_h;
		this.selectionhbg = selectionhbg;
	}

	public Hebergement(String selectionhbg) {
		super();
		this.selectionhbg = selectionhbg;
	}

	//G+S
	public long getId_h() {
		return id_h;
	}

	public void setId_h(long id_h) {
		this.id_h = id_h;
	}

	public String getSelectionhbg() {
		return selectionhbg;
	}

	public void setSelectionhbg(String selectionhbg) {
		this.selectionhbg = selectionhbg;
	}

	public List<Voyage> getListevoyage() {
		return listevoyage;
	}

	public void setListevoyage(List<Voyage> listevoyage) {
		this.listevoyage = listevoyage;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Hebergement [id_h=" + id_h + ", selectionhbg=" + selectionhbg + ", listevoyage=" + listevoyage
				+ "]";
	}


	
}
