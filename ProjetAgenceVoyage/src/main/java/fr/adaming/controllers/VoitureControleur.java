package fr.adaming.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import fr.adaming.model.Voiture;
import fr.adaming.service.IVoitureService;

@Controller
@RequestMapping("/voiture")
@Scope("session")
public class VoitureControleur {

	@Autowired
	private IVoitureService voitureService;

	// --------------------------Fonctionnalité afficher------------------------

	@RequestMapping(value = "/listeVoitures", method = RequestMethod.GET)
	public ModelAndView afficherListeVoiture() {
		List<Voiture> liste = voitureService.getAllVoiture();
		return new ModelAndView("accueilVoiture", "listeVoiture", liste);
	}
	
	@RequestMapping(value = "/listeVoituresRech", method = RequestMethod.POST)
	public ModelAndView afficherListeVoitureRecherchees(@RequestParam("pMotCle") String motCle) {
		List<Voiture> liste = voitureService.getByMotCle(motCle);
		return new ModelAndView("accueilVoiture", "listeVoiture", liste);
	}

	// --------------------------Fonctionnalité ajouter------------------------
	@RequestMapping(value = "/formAjoutVoit", method = RequestMethod.GET)
	public String afficherFormAjoutVoiture(Model modele) {
		modele.addAttribute("voitureAjoutee", new Voiture());
		return "ajoutVoiture";
	}

	@RequestMapping(value = "/ajoutVoiture", method = RequestMethod.POST)
	public String ajoutVoiture(Model modele, @ModelAttribute("voitureAjoutee") Voiture voit) {
		// Appel de la méthode service
		Voiture vOut = voitureService.addVoiture(voit);
		if (vOut.getId() != 0) {
			return "redirect:listeVoitures";
		} else {
			return "ajoutVoiture";
		}
	}

	// --------------------------Fonctionnalité supprimer------------------------
	@RequestMapping(value = "/deleteVoit/{pId}", method = RequestMethod.GET)
	public String supprimeVoiture(Model modele, @PathVariable("pId") long id) {
		voitureService.deleteVoiture(id);
		modele.addAttribute("listeVoiture", voitureService.getAllVoiture());
		return "accueilVoiture";
	}

	// --------------------------Fonctionnalité modifier-----------------------
	@RequestMapping(value = "/updateVoit", method = RequestMethod.GET)
	public String afficherVoitureModif(Model modele, @RequestParam("pId") long id) {
		modele.addAttribute("voitureModifiee", voitureService.getById(id));
		return "modifVoiture";
	}

	
	@RequestMapping(value = "/formModifVoit", method = RequestMethod.GET)
	public String afficherFormModifVoiture(Model modele) {
		modele.addAttribute("voitureModifiee", new Voiture());
		return "modifVoiture";
	}
	
	@RequestMapping(value = "/modifVoiture", method = RequestMethod.POST)
	public String modifierVoiture(Model modele, @ModelAttribute("voitureModifiee") Voiture voit) {
		// Appel de la méthode service
		Voiture vOut = voitureService.updateVoiture(voit);
		return "redirect:listeVoitures";

	}
}
