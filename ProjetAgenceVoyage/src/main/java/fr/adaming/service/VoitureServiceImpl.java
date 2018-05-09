package fr.adaming.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.IVoitureDao;
import fr.adaming.model.Voiture;

@Service
@Transactional
public class VoitureServiceImpl implements IVoitureService{
	
	@Autowired
	private IVoitureDao voitureDao;

	@Override
	public Voiture addVoiture(Voiture vo) {
		return voitureDao.addVoiture(vo);
	}

	@Override
	public void deleteVoiture(long idVo) {
		voitureDao.deleteVoiture(idVo);
	}

	@Override
	public Voiture updateVoiture(Voiture vo) {
		return voitureDao.updateVoiture(vo);
	}

	@Override
	public Voiture getById(long idVo) {
		return voitureDao.getById(idVo);
	}

	@Override
	public List<Voiture> getAllVoiture() {
		return voitureDao.getAllVoiture();
	}

	@Override
	public List<Voiture> getByMotCle(String mot) {
		return voitureDao.getByMotCle(mot);
	}

}
