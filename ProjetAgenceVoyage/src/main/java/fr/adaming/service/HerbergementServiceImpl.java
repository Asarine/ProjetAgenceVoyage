package fr.adaming.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.adaming.dao.IHebergementDao;
import fr.adaming.model.Hebergement;

@Service
@Transactional
public class HerbergementServiceImpl implements IHebergementService {

	@Autowired
	IHebergementDao hergementDao;
	
	@Override
	public List<Hebergement> getAllhebergment() {
		// TODO Auto-generated method stub
		return hergementDao.getAllhebergment();
	}

	@Override
	public Hebergement addhebergement(Hebergement hbg) {
		// TODO Auto-generated method stub
		return hergementDao.addhebergement(hbg);
	}

	@Override
	public long updatehebergement(Hebergement hbg) {
		// TODO Auto-generated method stub
		return hergementDao.updatehebergement(hbg);
	}

	@Override
	public long deletehebergement(long id_h) {
		// TODO Auto-generated method stub
		return hergementDao.deletehebergement(id_h);
	}

	@Override
	public Hebergement findhebergementById(long id_h) {
		// TODO Auto-generated method stub
		return hergementDao.findhebergementById(id_h);
	}

}
