package fr.adaming.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.IParticipantDao;
import fr.adaming.model.Participant;

@Service("parService")
@Transactional
public class ParticipantServiceImpl implements IParticipantService {
	@Autowired
	IParticipantDao partiDao;
	
	// le setter pour l'injection de dépendance
	public void setPartiDao(IParticipantDao partiDao) {
		this.partiDao = partiDao;
	}

	@Override
	public int addParticipant(Participant p) {
		return partiDao.addParticipant(p);
	}

	@Override
	public int updateParticipant(Participant p) {
		// TODO Auto-generated method stub
		return partiDao.updateParticipant(p);
	}

	@Override
	public int deleteParticipant(Long id) {
		return partiDao.deleteParticipant(id);
	}

	@Override
	public Participant searchParticipant(Long id) {
		return partiDao.searchParticipant(id);
	}

	@Override
	public List<Participant> getAllParticipant() {
		// TODO Auto-generated method stub
		return partiDao.getAllParticipant();
	}

	@Override
	public List<Participant> getParticipantByClient(Long id) {
		return partiDao.getParticipantByClient(id);
	}
	
}
