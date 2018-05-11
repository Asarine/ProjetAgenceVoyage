package fr.adaming.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.adaming.dao.ICommentaireDao;
import fr.adaming.model.Commentaire;

@Service
@Transactional
public class CommentaireServiceImpl implements ICommentaireService {
	
	@Autowired
	private ICommentaireDao comDao;

	@Override
	public Commentaire addCommentaire(Commentaire com) {
		return comDao.addCommentaire(com);
		
	}


	@Override
	public List<Commentaire> getAllCommentaires() {
		return comDao.getAllCommentaires();
	}


	@Override
	public void signalerCommentaire(long id) {
		Commentaire comOut=comDao.getCommentaireById(id);
		comOut.setSignalements(comOut.getSignalements()+1);
		if (comOut.getSignalements()<10){
			comDao.updateCommentaire(comOut);
		}else{
			comDao.deleteCommentaire(id);
		}
		
	}


}
