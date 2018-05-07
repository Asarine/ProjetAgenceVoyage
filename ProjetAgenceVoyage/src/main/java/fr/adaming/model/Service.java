package fr.adaming.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="services")
public class Service implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_s")
	private Long id;
	private String questionnaire;

	// Transformation association UML en Java
	@ManyToOne
	@JoinColumn(name = "co_id", referencedColumnName = "id_co")
	private Conseiller conseiller;
	
	@ManyToOne
	@JoinColumn(name = "cl_id", referencedColumnName = "id_cl")
	private Client client;
	

	public Conseiller getConseiller() {
		return conseiller;
	}

	public void setConseiller(Conseiller conseiller) {
		this.conseiller = conseiller;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Service() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Service(String questionnaire) {
		super();
		this.questionnaire = questionnaire;
	}

	public Service(Long id, String questionnaire) {
		super();
		this.id = id;
		this.questionnaire = questionnaire;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getQuestionnaire() {
		return questionnaire;
	}

	public void setQuestionnaire(String questionnaire) {
		this.questionnaire = questionnaire;
	}

	@Override
	public String toString() {
		return "Service [id=" + id + ", questionnaire=" + questionnaire + "]";
	}

}
