package fr.adaming.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name="clients")
@DiscriminatorValue(value="cl")
public class Client extends Participant implements Serializable  {
	

	private String statutdossier;
	private long numcb;
	private String mdp;
	
	//transformation UML en Java
	@ManyToOne
	@JoinColumn(name = "v_id", referencedColumnName = "id_v")
	private  Voyage voyage;
	
	@ManyToOne
	@JoinColumn(name = "co_id", referencedColumnName = "id_co")
	private Conseiller conseiller;
	
	@OneToMany(mappedBy="client")
	private List<Service> listeService;
	//Constructeur
	
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


	public Voyage getVoyage() {
		return voyage;
	}


	public void setVoyage(Voyage voyage) {
		this.voyage = voyage;
	}


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
