package fr.adaming.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;


@Entity
@Table(name="clients")
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorValue(value="cl")
public class Client extends Participant implements Serializable  {
	

	private String statutdossier;
	private long numcb;
	private String mdp;
	
	//Constructeur
	
	public Client(String statutdossier, long numcb, String mdp) {
		super();
		this.statutdossier = statutdossier;
		this.numcb = numcb;
		this.mdp = mdp;
	}


	public Client() {
		super();
	}


	//G+S
	
	public String getStatutdossier() {
		return statutdossier;
	}


	public void setStatutdossier(String statutdossier) {
		this.statutdossier = statutdossier;
	}


	public long getNumcb() {
		return numcb;
	}


	public void setNumcb(long numcb) {
		this.numcb = numcb;
	}


	public String getMdp() {
		return mdp;
	}


	public void setMdp(String mdp) {
		this.mdp = mdp;
	}


	@Override
	public String toString() {
		return "Client [statutdossier=" + statutdossier + ", numcb=" + numcb + ", mdp=" + mdp + "]";
	}


	
	
	
	

}
