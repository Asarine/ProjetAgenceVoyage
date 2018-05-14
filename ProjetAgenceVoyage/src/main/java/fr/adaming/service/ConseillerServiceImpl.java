package fr.adaming.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.IConseillerDao;
import fr.adaming.model.Conseiller;

@Service
@Transactional
public class ConseillerServiceImpl implements IConseillerService {
	@Autowired
	private IConseillerDao conseilDao;

	@Override
	public Conseiller getConseillerById(long id) {
		return conseilDao.getConseillerById(id);
	}

}
