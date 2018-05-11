package fr.adaming.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import fr.adaming.service.IRetraitBancaireService;

@Controller
@RequestMapping("/retrait")
@Scope("session")
public class RetraitController {
	
	@Autowired
	private IRetraitBancaireService banqserv;
	
	@RequestMapping(value="/a",method=RequestMethod.GET)
	public String afficheForm(){
		return "essaiWS";
	}
	
	@RequestMapping(value="/b",method=RequestMethod.POST)
	public String soumettreForm(@RequestParam("pPrix") int prix, @RequestParam("pNumCb") String numCB){
		int verif=banqserv.retirerTarif(numCB, prix);
		System.out.println(verif);
		return "essaiWS";
	}

}
