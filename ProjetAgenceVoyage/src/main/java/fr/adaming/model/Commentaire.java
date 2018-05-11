package fr.adaming.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="commentaires")
public class Commentaire implements Serializable {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_com")
	private long idCom;
	private String contenu;
	private int signalements;
	private int note;
	
	
	public Commentaire() {
		super();
	}
	
	public Commentaire(String contenu, int signalements, int note) {
		super();
		this.contenu = contenu;
		this.signalements = signalements;
		this.note = note;
	}
	
	

	public Commentaire(long idCom, String contenu, int signalements, int note) {
		super();
		this.idCom = idCom;
		this.contenu = contenu;
		this.signalements = signalements;
		this.note = note;
	}

	public long getIdCom() {
		return idCom;
	}
	public void setIdCom(long idCom) {
		this.idCom = idCom;
	}
	public String getContenu() {
		return contenu;
	}
	public void setContenu(String contenu) {
		this.contenu = contenu;
	}
	public int getSignalements() {
		return signalements;
	}
	public void setSignalements(int signalements) {
		this.signalements = signalements;
	}
	
	
	
	public int getNote() {
		return note;
	}

	public void setNote(int note) {
		this.note = note;
	}

	@Override
	public String toString() {
		return "Commentaire [idCom=" + idCom + ", contenu=" + contenu + ", signalements=" + signalements + "]";
	}
	
	

	
}
