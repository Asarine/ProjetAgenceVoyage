package fr.adaming.controllers69;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import fr.adaming.model.Hebergement;
import fr.adaming.service.IHebergementService;

@Controller
@RequestMapping("/hbgCTRL")
public class HerbergementController {
	

		@Autowired
		private IHebergementService hbgService;
		
		// Setter pour l'injection de d�pendances
		public void setHbgService(IHebergementService hbgService) {
			this.hbgService = hbgService;
		}

		// -----------------------------------------------Fonctionnalit� afficher
		@RequestMapping(value = "/listehbg", method = RequestMethod.GET)
		public ModelAndView afficheListe() {
			// Appel de la m�thode service pour r�cup�rer la liste
			List<Hebergement> listehbg = hbgService.getAllhebergment();

			return new ModelAndView("hebergement", "hbgliste", listehbg);
		}

		// ----------------------------------------------Fonctionnalit� ajouter
		// M�thode pour afficher le formulaire d'ajout
		@RequestMapping(value = "/Ajouthbg", method = RequestMethod.GET)
		public ModelAndView afficheFormAjout() {
			return new ModelAndView("ajoutHbg", "hbgAjout", new Hebergement());
		}

		// M�thode pour soumettre le formulaire d'ajout
		@RequestMapping(value = "/soumettreForm", method = RequestMethod.POST)
		public String soumettreFormAjout(ModelMap modele, @ModelAttribute("hbgAjout") Hebergement hbg) {
			// Appel de la m�thode service
			Hebergement hbgOut = hbgService.addhebergement(hbg);
			if (hbgOut.getId_h() != 0) {
				
				return "redirect:hebergement";
			} else {
				return "redirect:ajoutHbg";
			}
		}

		// ---------------------------------------Fonctionnalit� modifier
		// M�thode pour afficher le formulaire de modification
		@RequestMapping(value = "/afficheModif", method = RequestMethod.GET)
		public ModelAndView afficheFormModif() {
			return new ModelAndView("modifhbg", "hbgModif", new Hebergement());
		}

		@RequestMapping(value = "/soumettreModif", method = RequestMethod.POST)
		public String soumettreFormModif(ModelMap modele, @ModelAttribute("hbgModif") Hebergement hbg) {
			// Appel de la m�thode service
			long hbgOut = hbgService.updatehebergement(hbg);
			if (hbgOut != 0) {
				return "redirect:hebergement";
			} else {
				return "redirect:afficheModif";
			}
		}

		// --------------------------------------Fonctionnalit� supprimer
		// M�thode pour afficher le formulaire de suppression
		@RequestMapping(value = "/afficheSupp", method = RequestMethod.GET)
		public String afficherFormSupp(Model modele) {

			modele.addAttribute("HbgSupp", new Hebergement());

			return "supphbg";

		}

		@RequestMapping(value = "/soumettreSupp", method = RequestMethod.POST)
		public String soumettreFormSupp(Model modele, @ModelAttribute("HbgSupp") Hebergement hbg) {
			// Appel de la m�thode service
			hbgService.deletehebergement(hbg.getId_h());
			if (hbg.getId_h() != 0) {
				return "redirect:herbergement";
			} else {
				return "redirect:afficheSupp";
			}
		}

		// --------------------------------------Fonctionnalit� rechercher
		// M�thode pour afficher le formulaire de recherche
		@RequestMapping(value = "/afficheRech", method = RequestMethod.GET)
		public String afficheFormRecherche(Model modele) {
			modele.addAttribute("hbgRech", new Hebergement());
			return "recherche";
		}

		@RequestMapping(value = "/soumettreRech", method = RequestMethod.POST)
		public String soumettreFormRech(Model modele, @ModelAttribute("hbgRech") Hebergement hbg, RedirectAttributes rda) {
			// Appel de la m�thode service
			 Hebergement verif = hbgService.findhebergementById(hbg.getId_h());
			if (verif != null) {
				
				modele.addAttribute("hbgFind", verif);
				return "rechhbg";
			} else {
				
				
				rda.addFlashAttribute("msg", "l'herbergement n'existe pas...");
				return "redirect:afficheRech";
			}

		}

		// Fonctionnalit� supprimer avec lien
		@RequestMapping(value = "/deleteLink/{pId}", method = RequestMethod.GET)
		public String supprimeLien(ModelMap modele, @PathVariable("pId") long id_h) {
			Hebergement hbgIn = new Hebergement();
			hbgIn.setId_h(id_h);

			// Appel de la m�thode service pour supprimer l'�tudiant
			hbgService.deletehebergement(id_h);

			// R�cup�rer la nouvelle liste
			List<Hebergement> listehbg = hbgService.getAllhebergment();

			// Mettre � jour la liste dans la page d'accueil
			modele.addAttribute("hbgliste", listehbg);
			return "hebergement";
		}

		// Fonctionnalit� supprimer avec lien
		@RequestMapping(value = "/updateLink", method = RequestMethod.GET)
		public String modifierLien(ModelMap modele, @RequestParam("pId") int id_h) {
			Hebergement hbgIn = new Hebergement();
			hbgIn.setId_h(id_h);

			// Appel de la m�thode service pour supprimer l'�tudiant
			Hebergement hbgOut = hbgService.findhebergementById(id_h);

			// Mettre � jour la liste dans la page d'accueil
			modele.addAttribute("hbgModif", hbgOut);
			return "modifHbg";
		}
	}


