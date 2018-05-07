package fr.adaming.model;

import java.io.Serializable;

import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
	private boolean pdj;
	private boolean dj;
	private boolean diner;

	// Constructeurs

	public Hebergement() {
		super();
	}

	public Hebergement(long id_h, boolean pdj, boolean dj, boolean diner) {
		super();
		this.id_h = id_h;
		this.pdj = pdj;
		this.dj = dj;
		this.diner = diner;
	}

	// setters et getters

	public long getId_h() {
		return id_h;
	}

	public void setId_h(long id_h) {
		this.id_h = id_h;
	}

	public boolean isPdj() {
		return pdj;
	}

	public void setPdj(boolean pdj) {
		this.pdj = pdj;
	}

	public boolean isDj() {
		return dj;
	}

	public void setDj(boolean dj) {
		this.dj = dj;
	}

	public boolean isDiner() {
		return diner;
	}

	public void setDiner(boolean diner) {
		this.diner = diner;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Hebergement [id_h=" + id_h + ", pdj=" + pdj + ", dj=" + dj + ", diner=" + diner + "]";
	}

}
