package fr.adaming.controllers;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
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

import fr.adaming.model.Destination;
import fr.adaming.service.IDestinationService;

@Controller
@RequestMapping("/dsCTRL")
@Scope("session")
public class DestinationControllers {
	
	@Autowired
	private IDestinationService dsService;

	//Setter pour l'injection de dep
	public void setDsService(IDestinationService dsService) {
		this.dsService = dsService;
	}
	
	@RequestMapping(value="/listeDest", method=RequestMethod.GET)
	public ModelAndView afficheListeDestination (){
		List<Destination> listeDes=dsService.getAllDestination();
		return new ModelAndView ("listeDest", "listeDestinations", listeDes);
	}
	
	@RequestMapping(value = "/afficheAjoutds", method = RequestMethod.GET)
	public ModelAndView afficheds() {
		return new ModelAndView("ajouterds", "dsAjout", new Destination());
	}
	// MEthode pour soumettre le formulaire d'ajout
		@RequestMapping(value = "/soumettreAjoutds", method = RequestMethod.POST)
		public String soumettreFormAjoutds(ModelMap model, @ModelAttribute("dsAjout") Destination ds) {
			// Appel de la methode ajout
			Destination dsOut = dsService.addDestination(ds);

			if (dsOut.getId() != 0) {

				return "redirect:listeDest";
			} else {
				return "redirect:afficheAjoutds";
			}

		}

		@RequestMapping(value = "/affichModifds", method = RequestMethod.GET)
		public String modifierDestination(Model model) {

			model.addAttribute("dsModif", new Destination());

			String idDsPage = "modifierds";

			return idDsPage;
		}

		@RequestMapping(value = "/soumettreModifds", method = RequestMethod.POST)
		public String soumettreFormModifds(@ModelAttribute("dsModif") Destination ds) {
			long verif = dsService.updateDestination(ds);
			if (verif != 0) {
				return "redirect:listeDest";
			} else {
				return "redirect:affichModifds";

			}
		}

		@RequestMapping(value = "/afficheSupprds", method = RequestMethod.GET)
		public ModelAndView afficherSupprds() {
			return new ModelAndView("supprimeds", "dsSuppr", new Destination());
		}

		@RequestMapping(value = "/soumSupprds", method = RequestMethod.POST)
		public String soumettreSuppr(@ModelAttribute("dsSuppr") Destination ds) {
			long verif = dsService.deleteDestination(ds.getId());
			if (verif != 0) {
				return "redirect:listeDest";
			} else {
				return "redirect:soumSupprds";
			}
		}

		@RequestMapping(value = "/affichRechds", method = RequestMethod.GET)
		public ModelAndView rechercherbyIdds() {
			return new ModelAndView("rechercheds", "dsRech", new Destination());

		}

		@RequestMapping(value = "/soumRech", method = RequestMethod.POST)
		public String souRecherche(Model model, @RequestParam("pId") long id_d, RedirectAttributes rda) {
			Destination dsOut = dsService.getDestinationbyId(id_d);

			if (dsOut != null) {
				model.addAttribute("dsFind", dsOut);

				return "rechercheds";
			} else {
				// Ajouter un msg d'erreur dans le model de mvc 2 et le passer a la
				// methode affiche recherche
				rda.addFlashAttribute("msg", "La destination n'existe pas");
				return "redirect:afficheRechds";
			}
		}

		// Fonctionalité supprimer avec lien
		@RequestMapping(value = "/deleteLink/{pId}", method = RequestMethod.GET)
		public String supprimeLien(ModelMap model, @PathVariable("pId") long id) {
			Destination dsIn = new Destination();
			dsIn.setId(id);
			// Appel de la methode service pour supprimer l'etudiant
			dsService.deleteDestination(id);

			// Recuperer la nouvelle liste
			List<Destination> listeDes = dsService.getAllDestination();

			// Mettre a jour la liste dans la page accueil
			model.addAttribute("listeDest", listeDes);
			return "listeDest";
		}
		// Fonctionalité supprimer avec lien
			@RequestMapping(value = "/updateLink", method = RequestMethod.GET)
			public String modifierLien(ModelMap model, @RequestParam("pId") long id) {
				Destination dsIn = new Destination();
				dsIn.setId(id);
				// Appel de la methode service pour recup l'etudiant
				Destination dsOut=dsService.getDestinationbyId(id);

				// Mettre a jour la liste dans la page accueil
				model.addAttribute("dsModif", dsOut);
				return "modifierds";
			}
	}

