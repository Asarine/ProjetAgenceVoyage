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
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import fr.adaming.model.Voyage;
import fr.adaming.service.IVoyageService;

@Controller
@RequestMapping("/vCTRL")
@Scope("session")
public class VoyageController {
	
	@Autowired
	private IVoyageService voyService;

	@InitBinder
	public void initBinder(WebDataBinder binder)
	{
		//l'objet WebDataBinde sert à à faire le lien entre les parametres de la requete et les objets Java
		DateFormat df=new SimpleDateFormat("yyyy-MM-dd");
		
		df.setLenient(false);
		
		//la methode registerCustomEditor sert à configurer la conversion du parametre reçu au type de l'attribut
		//l'objet  CustomDateEditor sert à lier (mapper) la date reçu comme parametre de la requete à l'attribut de l'objet étudiant
		binder.registerCustomEditor(Date.class, new CustomDateEditor(df, false));
	}
	
	
	
	//fonctionnalité récupérer la liste :
	@RequestMapping(value="/listeVoyage", method=RequestMethod.GET)
	public ModelAndView afficheListVoyage()
	{
		
		//appel de la methode service :
		List<Voyage> liste=voyService.getAllVoyage();
		
		return new ModelAndView("accueilVoyage","listeVoy", liste );
	}
	
	
	
	//fonctionnalité rechchercher par l'id :
	   //methode pour afficher le formulaire de recherche :
	@RequestMapping(value="/afficheRechVoyage", method=RequestMethod.GET)
	public ModelAndView afficheFormRechercheVoyage()
	{
		
		return new ModelAndView("rechercheVoyage","vRech", new Voyage());
		
	}
	
	   //methode pour soumettre le formulaire de recherche:
	@RequestMapping(value="/soumettreRechVoyage", method=RequestMethod.POST)
	public String soumettreFormRechercheVoyage(ModelMap modele,  @ModelAttribute("vRech") Voyage v , RedirectAttributes rda)
	{
		
		//appel de la methode :
		Voyage vOut=voyService.getVoyageById(v);
		
		if(vOut != null)
		{
			//mettre le voyage en lien avec  la page
			modele.addAttribute("vFind", vOut);
			
			return "rechercheVoyage";
		}
		else
		{
			rda.addFlashAttribute("msg", "Le voyage demandé n'est pas disponible sur le site");
		
		return "redirect:afficheRechVoyage";
		}
		
	}
	
	
	
	//fonctionnalité supprimer :
	   //pour afficher le formulaire de suppression :
	@RequestMapping(value="/afficheSupprVoyage", method=RequestMethod.GET)
	public ModelAndView afficheFormSupprVoyage()
	{
		return new ModelAndView("supprimerVoyage","vSupprim",new Voyage());
	}
	
	  //pour soumettre le formulaire de suppression :
	@RequestMapping(value="/soumettreSupprimVoyage" , method=RequestMethod.POST)
	public String soumettreFormSupprVoyage(@ModelAttribute("vSupprim") Voyage v)
	{
		
		int verifSupprim=voyService.deleteVoyage(v);
		
		if(verifSupprim != 0)
		{
			return "redirect:listeVoyage";
		}
		
		else 
		{
			return "redirect:afficheSupprVoyage";

		}
	}
	
	
	//fonctionnalité ajouter un voyage :
	  //pour afficher le formulaire d'ajout :
	@RequestMapping(value="/afficheAjoutVoyage", method=RequestMethod.GET)
	public ModelAndView afficheFormAjoutVoyage()
	{
		
		return new ModelAndView("ajoutVoyage","vAjout",new Voyage());
	}
	
	 //pour soumettre le formulaire d'ajout :
	@RequestMapping(value="/soumettreAjoutVoyage",method=RequestMethod.POST)
	public String soumettreFormAjoutVoyage(@ModelAttribute("vAjout") Voyage v)
	{
		//appel de la methode :
		Voyage vOut= voyService.addVoyage(v);
		
		if(vOut.getId_v() != 0)
		{
			return "redirect:listeVoyage";

		}
		else 
		{
			return "redirect:afficheAjoutVoyage";

		}
	}
	
	
	//fonctionnalité modifier un voyage :
	   //pour afficher le formulaire de modif :
	@RequestMapping(value="/afficheModifVoyage", method=RequestMethod.GET)
	public ModelAndView afficheFormModifVoyage()
	{
		
		return new ModelAndView("modifVoyage","vModif",new Voyage());
	}
	
	  //pour soumettre le formulaire de modification :
	@RequestMapping(value="/soumettreModifVoyage", method=RequestMethod.POST)
	public String soumettreModifVoyage(@ModelAttribute("vModif") Voyage v)
	{
		
		int verifModif=voyService.updateVoyage(v);
		
		if(verifModif!=0)
		{
			return "redirect:listeVoyage";

		}
		else 
		{
			return "redirect:afficheModifVoyage";

		}
	}

	
	
	
	
	//supprimer avec le lien :
	@RequestMapping(value="/deleteLinkVoyage/{pIdV}", method=RequestMethod.GET)
	public String supprimLien(ModelMap modele, @PathVariable("pIdV") int id)
			{
		
		Voyage vIn=new Voyage();
		vIn.setId_v(id);
		
		//appel methode supprimer :
		 voyService.deleteVoyage(vIn);
		 
		 //récupérer la nouvelle liste :
		 List<Voyage> liste=voyService.getAllVoyage();
		 
		 //metter a jour dans la page d'accueil
		 modele.addAttribute("listeVoy", liste);
		 
		 return "accueilVoyage";
				
			}
	
	
	//modifier avec le lien :
	@RequestMapping(value="/updateLinkVoyage", method=RequestMethod.GET)
	public String modifLien(ModelMap modele, @RequestParam("pIdV") int id)
	{
		Voyage vIn= new Voyage();
		vIn.setId_v(id);
		
		//appel de la meth service pour ecup le voyage :
		Voyage vOut=voyService.getVoyageById(vIn);
		
		//mettre a jour la liste :
		modele.addAttribute("vModif", vOut);
		
		return "modifVoyage";
	}
}
