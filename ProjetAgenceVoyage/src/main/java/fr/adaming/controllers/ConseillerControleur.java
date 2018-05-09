package fr.adaming.controllers;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/conseiller")
@Scope("session")
public class ConseillerControleur {
	
	@RequestMapping(value="/accueil",method=RequestMethod.GET)
	public ModelAndView pageAccueil(){
		return new ModelAndView("accueilConseiller","message","Vous êtes dans l'accueil client");
	}

}
