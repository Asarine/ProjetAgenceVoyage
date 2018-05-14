package fr.adaming.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.IClientDao;
import fr.adaming.model.Client;

@Service
@Transactional
public class ClientServiceImpl implements IClientService {

	@Autowired
	private IClientDao clientDao;
	
	
	@Override
	public Client addClient(Client cl) {
		// recup du conseeiller par son id et l'associzer au client avant d'ajouteer le client 
		
		return clientDao.addClient(cl);
	}

	@Override
	public List<Client> getAllClient() {
		
		return clientDao.getAllClient();
	}

	@Override
	public int updateClient(Client cl) {
		
		return clientDao.updateClient(cl);
	}

	@Override
	public int deleteClient(long id) {
		
		return clientDao.deleteClient(id);
	}

	@Override
	public Client getClientById(long id) {
		
		return clientDao.getClientById(id);
	}

	@Override
	public Client isExistClient(String mail) {
		return clientDao.isExistClient(mail);
	}

}
