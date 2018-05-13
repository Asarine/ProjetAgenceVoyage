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

import fr.adaming.model.Client;
import fr.adaming.model.Conseiller;
import fr.adaming.model.Participant;
import fr.adaming.service.IClientService;
import fr.adaming.service.IParticipantService;

@Controller
@RequestMapping("/client/pCTRL")
// @Scope("session")
public class ParticipantControllerClient {
	@Autowired
	IParticipantService parService;
	@Autowired
	IClientService clientService;

	Client cl;

	public void setParService(IParticipantService parService) {
		this.parService = parService;
	}

	public void setCl(Client cl) {
		this.cl = cl;
	}

	@PostConstruct
	public void init() {
		// TODO
		// Récuperer le context spring security
		// Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		//
		// String mail = auth.getName();

		// Recuperer le infos du client
		// c = conseilService.getClientByMail(mail);
		cl = new Client(1, "TOTO", "Titi", "M.", "0606060606", new Date(), "a@a", "0000000000000", "a");

	}

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		// L'objet webdatabinder sert à faire le lien entre les params dela
		// requete et les objets java
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");

		df.setLenient(false);

		binder.registerCustomEditor(Date.class, new CustomDateEditor(df, false));
	}

	// Méthodes
	// ----------- Fonctionnalité d'affichage de la liste
	@RequestMapping(value = "/listeP_Cl", method = RequestMethod.GET)
	public ModelAndView afficheListeCompl() {
		long id = cl.getId();

		// appel de la méthode service pour récupérer la liste
		List<Participant> liste = parService.getParticipantByClient(id);
		System.out.println(liste);

		return new ModelAndView("listeParticipant_Cl", "listeParticipant_Cl", liste);
	}

	// ----------- Fonctionnalité d'ajout
	// 1 - méthode pour afficher le formulaire d'ajout
	@RequestMapping(value = "/afficheAjoutP_Cl", method = RequestMethod.GET)
	public ModelAndView afficheFormAjout() {
		return new ModelAndView("ajoutP_Cl", "pAjout_Cl", new Participant());
	}

	// 2 - Méthode pour soumettre le formulaire d'ajout
	@RequestMapping(value = "/soumettreAjoutP_Cl", method = RequestMethod.POST)
	public String soumettreFormAjout(ModelMap modele, @ModelAttribute("pAjout_Cl") Participant p, RedirectAttributes rda) {
		p.setClient(cl);

		// Appel de la méthode ajout de service
		int verif = parService.addParticipant(p);

		if (verif != 0) {
			return "redirect:listeP_Cl";

		} else {
			rda.addFlashAttribute("msg", "L'ajout n'a pas pu être effectué");
			return "redirect:afficheAjout_Cl";
		}

	}

	// ----------- Fonctionnalité de modification
	// 1 - méthode pour afficher le formulaire de modif
	@RequestMapping(value = "/afficheModifP_Cl", method = RequestMethod.GET)
	public ModelAndView afficheFormModif() {
		return new ModelAndView("modifP_Cl", "pModif", new Participant());
	}


	// 2 - Méthode pour soumettre le formulaire de modif
	@RequestMapping(value = "/soumettreModifP_Cl", method = RequestMethod.POST)
	public String soumettreFormModif(@ModelAttribute("pModif") Participant p, RedirectAttributes rda) {
		// Appel de la méthode modif de service
		p.setClient(cl);
		
		int verif = parService.updateParticipant(p);

		if (verif != 0) {
			return "redirect:listeP_Cl";

		} else {
			rda.addFlashAttribute("msg", "La modification n'a pas pu être effectuée");
			return "redirect:afficheModifP_Cl";
		}

	}

	// Fonctionnalité supprimer avec lien
	@RequestMapping(value = "/deleteLink_Cl/{pId}")
	public String supprimLien(Model modele, @PathVariable("pId") Long id) {
		// Appel de la méthode service pour supprimer l'étudiant
		parService.deleteParticipant(id);

		// Récupérer la nouvelle liste
		List<Participant> liste = parService.getParticipantByClient(id);

		// Mettre à jour la liste dans la page d'accueil
		modele.addAttribute("listeParticipant_Cl", liste);

		return "listeParticipant_Cl";
	}

	// Fonctionnalité modifier avec lien
	@RequestMapping(value = "/updateLink_Cl")
	public String editLien(Model modele, @RequestParam("pId") Long id) {
		// Appel de la méthode service pour obtenir le participant
		Participant pOut = parService.searchParticipant(id);

		// Stocker le participant
		modele.addAttribute("pModif", pOut);

		return "modifP_Cl";
	}

}
