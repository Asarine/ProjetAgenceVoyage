package fr.adaming.service;

public interface IServiceBancaireService {
	
	public int retirerTarif(String numCB, double sommeTotale);
	
	public int rembourserClient(String numCB, double sommeRemboursee);

}
