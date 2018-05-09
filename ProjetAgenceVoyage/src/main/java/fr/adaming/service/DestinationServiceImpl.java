package fr.adaming.service;

import java.util.List;

import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import fr.adaming.dao.IDestinationDao;
import fr.adaming.model.Destination;

@Service
@Transactional
public class DestinationServiceImpl implements IDestinationService {

	@Autowired
	IDestinationDao destinationDao;
	
	@Override
	public Destination addDestination(Destination ds) {
		
		return destinationDao.addDestination(ds);
	}

	@Override
	public long updateDestination(Destination ds) {
		// TODO Auto-generated method stub
		return destinationDao.updateDestination(ds);
	}

	@Override
	public Destination getDestinationbyId(long id_d) {
		// TODO Auto-generated method stub
		return destinationDao.getDestinationbyId(id_d);
	}

	@Override
	public long deleteDestination(long id_d) {
		// TODO Auto-generated method stub
		return destinationDao.deleteDestination(id_d);
	}

	@Override
	public List<Destination> getAllDestination() {
		// TODO Auto-generated method stub
		return destinationDao.getAllDestination();
	}

}
