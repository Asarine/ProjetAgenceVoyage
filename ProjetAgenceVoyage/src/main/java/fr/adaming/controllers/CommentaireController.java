package fr.adaming.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import fr.adaming.model.Commentaire;
import fr.adaming.service.ICommentaireService;

@Controller
@RequestMapping("/comCTRL")
@Scope("session")
public class CommentaireController {

	@Autowired
	private ICommentaireService comServ;

	// --------------------------------------Fonctionnalité
	// afficher------------------------------------
	@RequestMapping(value = "/afficheListe", method = RequestMethod.GET)
	public ModelAndView afficherCommentaires() {
		List<Commentaire> liste = comServ.getAllCommentaires();
		return new ModelAndView("accueilCom", "listeComs", liste);
	}

	// --------------------------------------Fonctionnalité
	// ajouter------------------------------------
	@RequestMapping(value = "/afficheFormAjout", method = RequestMethod.GET)
	public ModelAndView formulaireAjoutCommentaires() {
		return new ModelAndView("ajoutCom", "comAjout", new Commentaire());
	}

	@RequestMapping(value = "/ajoutCommentaire", method = RequestMethod.POST)
	public String ajoutCommentaires(ModelMap modele, @ModelAttribute("comAjout") Commentaire comAjout,@RequestParam("rating") int note) {
		comAjout.setNote(note);
		Commentaire comOut = comServ.addCommentaire(comAjout);
		if (comOut.getIdCom() != 0) {
			return "redirect:afficheListe";
		} else {
			return "ajoutCom";
		}

	}

	@RequestMapping(value = "/ajoutSignal", method = RequestMethod.GET)
	public String afficherVoitureModif(@RequestParam("pId") long id) {
		comServ.signalerCommentaire(id);
		return "redirect:afficheListe";
	}

}
