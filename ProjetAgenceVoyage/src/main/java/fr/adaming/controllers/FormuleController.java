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

import fr.adaming.model.Formule;
import fr.adaming.service.IFormuleService;

@Controller
@RequestMapping("/conseiller/fCTRL")
@Scope("session")
public class FormuleController {
	
	@Autowired
	private IFormuleService formService;

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
	@RequestMapping(value="/listeFormule", method=RequestMethod.GET)
	public ModelAndView afficheListFormule()
	{
		
		//appel de la methode service :
		List<Formule> liste=formService.getAllFormule();
		
		return new ModelAndView("accueilFormule","listeForm", liste );
	}
	
	
	
	//fonctionnalité rechchercher par l'id :
	   //methode pour afficher le formulaire de recherche :
	@RequestMapping(value="/afficheRechFormule", method=RequestMethod.GET)
	public ModelAndView afficheFormRechercheFormule()
	{
		
		return new ModelAndView("rechercheFormule","fRech", new Formule());
		
	}
	
	   //methode pour soumettre le formulaire de recherche:
	@RequestMapping(value="/soumettreRechFormule", method=RequestMethod.POST)
	public String soumettreFormRechercheVoyage(ModelMap modele,  @ModelAttribute("fRech") Formule f , RedirectAttributes rda)
	{
		
		//appel de la methode :
		Formule fOut=formService.getFormuleById(f);
		
		if(fOut != null)
		{
			//mettre le voyage en lien avec  la page
			modele.addAttribute("fFind", fOut);
			
			return "rechercheFormule";
		}
		else
		{
			rda.addFlashAttribute("msg", "La formule demandée n'est pas disponible sur le site");
		
		return "redirect:afficheRechFormule";
		}
		
	}
	
	
	
	//fonctionnalité supprimer :
	   //pour afficher le formulaire de suppression :
	@RequestMapping(value="/afficheSupprFormule", method=RequestMethod.GET)
	public ModelAndView afficheFormSupprVoyage()
	{
		return new ModelAndView("supprimerFormule","fSupprim",new Formule());
	}
	
	  //pour soumettre le formulaire de suppression :
	@RequestMapping(value="/soumettreSupprimFormule" , method=RequestMethod.POST)
	public String soumettreFormSupprFormule(@ModelAttribute("fSupprim") Formule f)
	{
		
		int verifSupprim=formService.deleteFormule(f);
		
		if(verifSupprim != 0)
		{
			return "redirect:listeFormule";
		}
		
		else 
		{
			return "redirect:afficheSupprFormule";

		}
	}
	
	
	//fonctionnalité ajouter un voyage :
	  //pour afficher le formulaire d'ajout :
	@RequestMapping(value="/afficheAjoutFormule", method=RequestMethod.GET)
	public ModelAndView afficheFormAjoutFormule()
	{
		
		return new ModelAndView("ajoutFormule","fAjout",new Formule());
	}
	
	 //pour soumettre le formulaire d'ajout :
	@RequestMapping(value="/soumettreAjoutFormule",method=RequestMethod.POST)
	public String soumettreFormAjoutFormule(@ModelAttribute("fAjout") Formule f)
	{
		//appel de la methode :
		Formule fOut=formService.addFormule(f);
		
		if(fOut.getId_f() != 0)
		{
			return "redirect:listeFormule";

		}
		else 
		{
			return "redirect:afficheAjoutFormule";

		}
	}
	
	
	//fonctionnalité modifier un voyage :
	   //pour afficher le formulaire de modif :
	@RequestMapping(value="/afficheModifFormule", method=RequestMethod.GET)
	public ModelAndView afficheFormModifFormule()
	{
		
		return new ModelAndView("modifFormule","fModif",new Formule());
	}
	
	  //pour soumettre le formulaire de modification :
	@RequestMapping(value="/soumettreModifFormule", method=RequestMethod.POST)
	public String soumettreModifFormule(@ModelAttribute("fModif") Formule f)
	{
		
		int verifModif=formService.updateFormule(f);
		
		if(verifModif!=0)
		{
			return "redirect:listeFormule";

		}
		else 
		{
			return "redirect:afficheModifFormule";

		}
	}

	
	
	
	
	//supprimer avec le lien :
	@RequestMapping(value="/deleteLinkFormule/{pIdF}", method=RequestMethod.GET)
	public String supprimLien(ModelMap modele, @PathVariable("pIdF") int id)
			{
		
		
		Formule fIn=new Formule();
		fIn.setId_f(id);
		
		//appel methode supprimer :
		 formService.deleteFormule(fIn);
		 
		 //récupérer la nouvelle liste :
		 List<Formule> liste=formService.getAllFormule();
		 
		 //metter a jour dans la page d'accueil
		 modele.addAttribute("listeForm", liste);
		 
		 return "accueilFormule";
				
			}
	
	
	//modifier avec le lien :
	@RequestMapping(value="/updateLinkFormule", method=RequestMethod.GET)
	public String modifLien(ModelMap modele, @RequestParam("pIdF") int id)
	{
		
		Formule fIn= new Formule();
		fIn.setId_f(id);
		
		//appel de la meth service pour ecup le voyage :
		Formule fOut=formService.getFormuleById(fIn);
		
		//mettre a jour la liste :
		modele.addAttribute("fModif", fOut);
		
		return "modifFormule";
	}

}
