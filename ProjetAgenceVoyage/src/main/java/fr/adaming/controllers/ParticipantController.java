package fr.adaming.controllers;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.context.annotation.Scope;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import fr.adaming.model.Conseiller;
import fr.adaming.model.Participant;
import fr.adaming.service.IParticipantService;

@Controller
@RequestMapping("/conseiller/pCTRL")
// @Scope("session")
public class ParticipantController {
	@Autowired
	IParticipantService parService;
	// @Autowired
	// IConseillerService conseilService;

	Conseiller c;

	public void setParService(IParticipantService parService) {
		this.parService = parService;
	}

	public void setC(Conseiller c) {
		this.c = c;
	}

	@PostConstruct
	public void init() {
		// TODO
		// R�cuperer le context spring security
		// Authentication auth =
		// SecurityContextHolder.getContext().getAuthentication();
		//
		// String mail = auth.getName();

		// Recuperer le infos du formateur
		// c = conseilService.getAdminByMail(mail);
		c = new Conseiller("nom", "prenom", "a@a", "a", true);

	}

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		// L'objet webdatabinder sert � faire le lien entre les params dela
		// requete et les objets java
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");

		df.setLenient(false);

		binder.registerCustomEditor(Date.class, new CustomDateEditor(df, false));
	}

	// M�thodes
	// ----------- Fonctionnalit� d'affichage de la liste
	@RequestMapping(value = "/liste", method = RequestMethod.GET)
	public ModelAndView afficheListeCompl() {
		// appel de la m�thode service pour r�cup�rer la liste
		List<Participant> liste = parService.getAllParticipant();

		return new ModelAndView("listeParticipant", "listeParticipant", liste);
	}

	// ----------- Fonctionnalit� d'ajout
	// 1 - m�thode pour afficher le formulaire d'ajout
	@RequestMapping(value = "/afficheAjout", method = RequestMethod.GET)
	public ModelAndView afficheFormAjout() {
		return new ModelAndView("ajoutP", "pAjout", new Participant());
	}

	// 2 - M�thode pour soumettre le formulaire d'ajout
	@RequestMapping(value = "/soumettreAjout", method = RequestMethod.POST)
	public String soumettreFormAjout(ModelMap modele, @ModelAttribute("pAjout") Participant p, RedirectAttributes rda) {
		
		// Appel de la m�thode ajout de service
		int verif = parService.addParticipant(p);

		if (verif != 0) {
			return "redirect:liste";

		} else {
			rda.addFlashAttribute("msg", "L'ajout n'a pas pu �tre effectu�");
			return "redirec:afficheAjout";
		}

	}

	// ----------- Fonctionnalit� de modification
	// 1 - m�thode pour afficher le formulaire de modif
	@RequestMapping(value = "/afficheModif", method = RequestMethod.GET)
	public ModelAndView afficheFormModif() {
		return new ModelAndView("modifP", "pModif", new Participant());
	}

	// 2 - M�thode pour soumettre le formulaire de modif
	@RequestMapping(value = "/soumettreModif", method = RequestMethod.POST)
	public String soumettreFormModif(@ModelAttribute("pModif") Participant p, RedirectAttributes rda) {
		// Appel de la m�thode modif de service
		int verif = parService.updateParticipant(p);

		if (verif != 0) {
			return "redirect:liste";

		} else {
			rda.addFlashAttribute("msg", "La modification n'a pas pu �tre effectu�e");
			return "redirec:afficheModif";
		}

	}

	// ----------- Fonctionnalit� de suppression
	// 1 - m�thode pour afficher le formulaire de suppression
	@RequestMapping(value = "/afficheDelete", method = RequestMethod.GET)
	public ModelAndView afficheSupprim() {
		return new ModelAndView("supprimP", "pDelete", new Participant() {
		});
	}

	// 2 - M�thode pour soumettre le formulaire de suppression
	@RequestMapping(value = "/soumettreDelete", method = RequestMethod.POST)
	public String soumettreFormSupprim(@ModelAttribute("pDelete") Participant p, RedirectAttributes rda) {
		int verif = parService.deleteParticipant(p.getId());

		if (verif != 0) {
			rda.addFlashAttribute("msg", "Suppression effectu�e !");
			return "redirect:liste";
		} else {
			rda.addFlashAttribute("msg", "Supression impossible");
			return "redirect:afficheDelete";
		}
	}

	// ----------- Fonctionnalit� de recherche
	// 1 - m�thode pour afficher le formulaire de recherche
	@RequestMapping(value = "/afficheSearch", method = RequestMethod.GET)
	public String afficheRecherche(Model modele) {
		modele.addAttribute("pSearch", new Participant());

		return "rechercherP";
	}

	// 2 - M�thode pour soumettre le formulaire de recherche
	@RequestMapping(value = "/soumettreSearch", method = RequestMethod.POST)
	public String soumettreRecherche(ModelMap modele, @ModelAttribute("pSearch") Participant p,
			RedirectAttributes rda) {
		Participant pOut = parService.searchParticipant(p.getId());

		if (pOut != null) {
			modele.addAttribute("pOut", pOut);

			return "rechercherP";
		} else {
			rda.addFlashAttribute("msg", "Pas de participant associ� � l'ID " + p.getId());
			return "redirect:afficheSearch";
			// inserer un message d'erreur
		}
	}

	// Fonctionnalit� supprimer avec lien
	@RequestMapping(value = "/deleteLink/{pId}")
	public String supprimLien(Model modele, @PathVariable("pId") Long id) {
		// Appel de la m�thode service pour supprimer l'�tudiant
		parService.deleteParticipant(id);

		// R�cup�rer la nouvelle liste
		List<Participant> liste = parService.getAllParticipant();

		// Mettre � jour la liste dans la page d'accueil
		modele.addAttribute("listeParticipant", liste);

		return "listeParticipant";
	}

	// Fonctionnalit� modifier avec lien
	@RequestMapping(value = "/updateLink")
	public String editLien(Model modele, @RequestParam("pId") Long id) {
		// Appel de la m�thode service pour obtenir le participant
		Participant pOut = parService.searchParticipant(id);

		// Stocker le participant
		modele.addAttribute("pModif", pOut);

		return "modifP";
	}

}
