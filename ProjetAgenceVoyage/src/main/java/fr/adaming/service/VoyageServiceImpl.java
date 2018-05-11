package fr.adaming.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.annotation.Propagation;


import fr.adaming.dao.IVoyageDao;
import fr.adaming.model.Voyage;

@Service("vServ")
@Transactional/*(propagation=Propagation.REQUIRED)*/
public class VoyageServiceImpl implements IVoyageService {
	
	@Autowired
	private IVoyageDao voyDao;

	@Override
	public List<Voyage> getAllVoyage() {
		// TODO Auto-generated method stub
		return voyDao.getAllVoyage();
	}

	@Override
	public Voyage addVoyage(Voyage v) {
		// TODO Auto-generated method stub
		return voyDao.addVoyage(v);
	}

	@Override
	public int updateVoyage(Voyage v) {
		// TODO Auto-generated method stub
		return voyDao.updateVoyage(v);
	}

	@Override
	public int deleteVoyage(Voyage v) {
		// TODO Auto-generated method stub
		return voyDao.deleteVoyage(v);
	}

	@Override
	public Voyage getVoyageById(Voyage v) {
		// TODO Auto-generated method stub
		return voyDao.getVoyageById(v);
	}

	@Override
	public List<Voyage> getbymotcle(String mc) {
		// TODO Auto-generated method stub
		return voyDao.getbymotcle(mc);
	}

}
