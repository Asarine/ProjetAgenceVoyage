package fr.adaming.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import fr.adaming.model.Dossier;
import fr.adaming.model.Voyage;
import fr.adaming.service.IDossierService;

@Controller
@RequestMapping("/conseiller/dosCTRL")
@Scope("session")
public class DossierController {
	
	@Autowired
	private IDossierService dosService;
	
	//---------------------------------------------------------Afficher liste------------------------------------------------------------------------
	
	@RequestMapping(value="/listeDossier",method=RequestMethod.GET)
	public ModelAndView afficherListe(Dossier dos){
		
		// appel methode liste pour récupérer la liste
		List<Dossier> liste=dosService.getAllDossier();
		
		return new ModelAndView("accueilDos","listeDossier",liste);
	}
	
	//---------------------------------------------------------Ajouter Client------------------------------------------------------------------------

	
	// Afficher le formulaire d'ajout
	
	@RequestMapping(value="/formAjout",method = RequestMethod.GET)
	public ModelAndView afficherForm() {
		return new ModelAndView("ajoutDos", "dosAjout", new Dossier());
	}
	
	// Méthode pour soumettre le formulaire après remplissage
	@RequestMapping(value="/soumettreAjout", method=RequestMethod.POST)
	public String soumettreFormAjout(ModelMap modele, @ModelAttribute("dosAjout")Dossier dos) {
		
		// Appel de la méthode Ajout de Service
		Dossier dosOut = dosService.addDossier(dos);
		
		if(dosOut.getId()!=0){
			//Redirection à la methode liste pour afficher new liste
			return "redirect:listeDossier";
		} else {
			return "redirect:formAjout";
		}
	}
	
	//---------------------------------------------------------Modifier client------------------------------------------------------------------------
	
	// Méthode afficher formulaire modification
	@RequestMapping(value="/formModif", method=RequestMethod.GET)
	public ModelAndView modifForm(){
		return new ModelAndView("modifDos", "dosModif", new Dossier());
	}

	// Méthode pour soumettre formulaire 
	@RequestMapping(value="/soumettreModif", method=RequestMethod.POST)
	public String soumFormModif(@ModelAttribute("dosModif")Dossier dos){
		int dosOut = dosService.updateDossier(dos);
		if (dosOut!=0){
			// On va rediriger avec la méthode / liste
			return "redirect:listeDossier";
		}else {
			return "redirect:formModif";
		}
	
	}
	
	//---------------------------------------------------------Supprimer Client------------------------------------------------------------------------

	// Méthode afficher formulaire suppression
	@RequestMapping(value="/formSupp", method=RequestMethod.GET)
	public ModelAndView suppForm(){
		return new ModelAndView("suppDos", "dosSupp", new Dossier());
	}
	
	// Méthode pour soumettre formulaire 
	@RequestMapping(value="/soumettreSupp", method=RequestMethod.POST)
	public String soumSuppForm(@ModelAttribute("dosSupp")Dossier dos){
		dosService.deleteDossier(dos.getId());
			return "redirect:listeDossier";

	}
	
	//---------------------------------------------------------Rechercher Client par id------------------------------------------------------------------------
	
	// Méthode afficher formulaire recherche
	@RequestMapping(value="/formRech",method=RequestMethod.GET)
	public ModelAndView rechercherDossier(Dossier dos){
		
		return new ModelAndView("rechDos","dosRech", new Dossier());
		
	}
	
	// Méthode pour soumettre formulaire de recherche
	@RequestMapping(value="/soumettreRech",method=RequestMethod.POST)
	public String soumettreFormulaire(ModelMap modele, @ModelAttribute("dosRech") Dossier dos,BindingResult result){

		// Appel de la methode rechercher de service
		Dossier dosOut = dosService.getDossierById(dos.getId());
		
		if(result.hasErrors()){
			return "rechDos";
		}
		
		
		modele.addAttribute("dosFind", dosOut);
		return "resultatDos";
		
	}
	
	
	
	
	//Lien modifier un dossier :
	@RequestMapping(value="/updateLinkDossier", method=RequestMethod.GET)
	public String modifLien(ModelMap modele, @RequestParam("pIdD") int id)
	{
		Dossier dIn= new Dossier();
		dIn.setId(id);
		
		//appel de la meth service pour ecup le voyage :
		Dossier dOut=dosService.getDossierById(dIn.getId());
		
		//mettre a jour la liste :
		modele.addAttribute("dosModif", dOut);
		
		return "modifDos";
	}
	

}
