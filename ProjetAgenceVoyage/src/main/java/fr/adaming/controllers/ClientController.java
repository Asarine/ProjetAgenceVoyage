package fr.adaming.controllers;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import fr.adaming.model.Client;
import fr.adaming.service.IClientService;

@Controller
@RequestMapping("/conseiller/clCTRL")
@Scope("session")
public class ClientController {
	
	@Autowired
	private IClientService clServ;
	
	@InitBinder
	public void initBinder(WebDataBinder binder)
	{
		//l'objet WebDataBinde sert � � faire le lien entre les parametres de la requete et les objets Java
		DateFormat df=new SimpleDateFormat("yyyy-MM-dd");
		
		df.setLenient(false);
		
		//la methode registerCustomEditor sert � configurer la conversion du parametre re�u au type de l'attribut
		//l'objet  CustomDateEditor sert � lier (mapper) la date re�u comme parametre de la requete � l'attribut de l'objet �tudiant
		binder.registerCustomEditor(Date.class, new CustomDateEditor(df, false));
	}
	
	//---------------------------------------------------------Afficher liste------------------------------------------------------------------------
	
	@RequestMapping(value="/listeClient",method=RequestMethod.GET)
	public ModelAndView afficherListe(Client cl){
		
		// appel methode liste pour r�cup�rer la liste
		List<Client> liste=clServ.getAllClient();
		
		return new ModelAndView("accueilCl","listeClient",liste);
	}
	
	//---------------------------------------------------------Ajouter Client------------------------------------------------------------------------

	
	// Afficher le formulaire d'ajout
	
	@RequestMapping(value="/formAjout",method = RequestMethod.GET)
	public ModelAndView afficherForm() {
		return new ModelAndView("ajoutCl", "clAjout", new Client());
	}
	
	// M�thode pour soumettre le formulaire apr�s remplissage
	@RequestMapping(value="/soumettreAjout", method=RequestMethod.POST)
	public String soumettreFormAjout(ModelMap modele, @ModelAttribute("clAjout")Client cl) {
		
		// Appel de la m�thode Ajout de Service
		Client clOut = clServ.addClient(cl);
		
		if(clOut.getId()!=0){
			//Redirection � la methode liste pour afficher new liste
			return "redirect:listeClient";
		} else {
			return "redirect:formAjout";
		}
	}
	
	//---------------------------------------------------------Modifier client------------------------------------------------------------------------
	
	// M�thode afficher formulaire modification
	@RequestMapping(value="/formModif", method=RequestMethod.GET)
	public ModelAndView modifForm(){
		return new ModelAndView("modifCl", "clModif", new Client());
	}

	// M�thode pour soumettre formulaire 
	@RequestMapping(value="/soumettreModif", method=RequestMethod.POST)
	public String soumFormModif(@ModelAttribute("clModif")Client cl){
		int clOut = clServ.updateClient(cl);
		if (clOut!=0){
			// On va rediriger avec la m�thode / liste
			return "redirect:listeClient";
		}else {
			return "redirect:formModif";
		}
	
	}
	
	//---------------------------------------------------------Supprimer Client------------------------------------------------------------------------

	// M�thode afficher formulaire suppression
	@RequestMapping(value="/formSupp", method=RequestMethod.GET)
	public ModelAndView suppForm(){
		return new ModelAndView("suppCl", "clSupp", new Client());
	}
	
	// M�thode pour soumettre formulaire 
	@RequestMapping(value="/soumettreSupp", method=RequestMethod.POST)
	public String soumSuppForm(@ModelAttribute("clSupp")Client cl){
		clServ.deleteClient(cl.getId());
			return "redirect:listeClient";

	}
	
	//---------------------------------------------------------Rechercher Client par id------------------------------------------------------------------------
	
	// M�thode afficher formulaire recherche
	@RequestMapping(value="/formRech",method=RequestMethod.GET)
	public ModelAndView rechercherClient(Client cl){
		
		return new ModelAndView("rechCl","clRech", new Client());
		
	}
	
	// M�thode pour soumettre formulaire de recherche
	@RequestMapping(value="/soumettreRech",method=RequestMethod.POST)
	public String soumettreFormulaire(ModelMap modele, @ModelAttribute("clRech") Client cl,BindingResult result){

		// Appel de la methode rechercher de service
		Client clOut = clServ.getClientById(cl.getId());
		
		if(result.hasErrors()){
			return "rechCl";
		}
		
		
		modele.addAttribute("clFind", clOut);
		return "resultatCl";
		
	}
	

}
