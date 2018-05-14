package fr.adaming.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import fr.adaming.model.Dossier;
import fr.adaming.service.IDossierService;

@Controller
@RequestMapping("/dosClCTRL")
@Scope("session")
public class DossierClientController {
	
	@Autowired
	private IDossierService dosServ;
	
	@RequestMapping(value="/affichePage",method=RequestMethod.GET)
	public String afficherListe(Dossier dos){
		return "accueilDos2";
	}

	@RequestMapping(value="/soumettreAjout",method=RequestMethod.POST)
	public ModelAndView afficherDossiers(@RequestParam("pId") long id){
		ModelAndView model=new ModelAndView("accueilDos2");
		model.addObject("liste",dosServ.getDossiersByIdClient(id));
		return model;
	}
}
