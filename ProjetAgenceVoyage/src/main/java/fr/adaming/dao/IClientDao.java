package fr.adaming.dao;

import java.util.List;

import fr.adaming.model.Client;


public interface IClientDao {
	
	public Client addClient(Client cl);
	
	public List<Client> getAllClient();
	
	public int updateClient(Client cl);
	
	public int deleteClient(long id);
	
	public Client getClientById(long id);

}
