package fr.adaming.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.IFormuleDao;
import fr.adaming.model.Formule;

@Service("fServ")
@Transactional
public class FormuleServiceImpl implements IFormuleService {
	
	@Autowired
	private IFormuleDao formDao;

	@Override
	public List<Formule> getAllFormule() {
		// TODO Auto-generated method stub
		return formDao.getAllFormule();
	}

	@Override
	public Formule addFormule(Formule f) {
		// TODO Auto-generated method stub
		return formDao.addFormule(f);
	}

	@Override
	public int updateFormule(Formule f) {
		// TODO Auto-generated method stub
		return formDao.updateFormule(f);
	}

	@Override
	public int deleteFormule(Formule f) {
		// TODO Auto-generated method stub
		return formDao.deleteFormule(f);
	}

	@Override
	public Formule getFormuleById(Formule f) {
		// TODO Auto-generated method stub
		return formDao.getFormuleById(f);
	}

}
