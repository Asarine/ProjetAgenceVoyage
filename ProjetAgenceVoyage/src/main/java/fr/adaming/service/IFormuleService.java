package fr.adaming.service;

import java.util.List;

import fr.adaming.model.Formule;

public interface IFormuleService {
	public List<Formule> getAllFormule();
	public Formule addFormule (Formule f);
	public int updateFormule (Formule f);
	public int deleteFormule (Formule f);
	public Formule getFormuleById (Formule f);

}
