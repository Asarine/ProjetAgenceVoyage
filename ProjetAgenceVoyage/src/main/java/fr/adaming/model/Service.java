package fr.adaming.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Service implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_s")
	private Long id;
	private String questionnaire;

	public Service() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Service(String questionnaire) {
		super();
		this.questionnaire = questionnaire;
	}

	public Service(int id, String questionnaire) {
		super();
		this.id = id;
		this.questionnaire = questionnaire;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
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
