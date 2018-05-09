package fr.adaming.service;

import java.util.List;

import fr.adaming.model.Client;

public interface IClientService {
	
	public Client addClient(Client cl);
	
	public List<Client> getAllClient();
	
	public int updateClient(Client cl);
	
	public int deleteClient(long id);
	
	public Client getClientById(long id);

}
