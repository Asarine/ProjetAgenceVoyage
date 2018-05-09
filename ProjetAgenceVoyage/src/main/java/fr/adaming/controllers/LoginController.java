package fr.adaming.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {
	
	@RequestMapping(value="/login",method=RequestMethod.GET)
	public String afficheLogin(){
		return "loginPage";
	}

	@RequestMapping(value="/loginEchec",method=RequestMethod.GET)
	public String echecLogin(Model modele){
		modele.addAttribute("erreur", true);
		return "loginPage";
	}
	
	@RequestMapping(value="/accessDenied",method=RequestMethod.GET)
	public String nonDroitLogin(Model modele){
		modele.addAttribute("nonDroit", true);
		return "loginPage";
	}
	
	@RequestMapping(value="/logout",method=RequestMethod.GET)
	public String deconnexion(){
		return "redirect:login";
	}
}
