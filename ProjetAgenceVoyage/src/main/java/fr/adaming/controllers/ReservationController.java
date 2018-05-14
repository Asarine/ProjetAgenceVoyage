package fr.adaming.controllers;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
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
import fr.adaming.model.Dossier;
import fr.adaming.model.Participant;
import fr.adaming.model.Voyage;
import fr.adaming.service.IClientService;
import fr.adaming.service.ICommentaireService;
import fr.adaming.service.IDossierService;
import fr.adaming.service.IParticipantService;
import fr.adaming.service.IServiceBancaireService;
import fr.adaming.service.IVoyageService;

@Controller
@RequestMapping("/resCTRL")
@Scope("session")
public class ReservationController {
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		// L'objet webdatabinder sert à faire le lien entre les params dela
		// requete et les objets java
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");

		df.setLenient(false);

		binder.registerCustomEditor(Date.class, new CustomDateEditor(df, false));
	}

	@Autowired
	private IVoyageService voyServ;
	
	@Autowired
	private ICommentaireService comServ;
	
	@Autowired
	private IParticipantService partServ;
	
	@Autowired
	private IDossierService dosServ;
	
	@Autowired
	private IServiceBancaireService banqueServ;
	
	@Autowired
	private IClientService clServ;
	
	@RequestMapping(value="/afficheAccueil",method=RequestMethod.GET)
	public ModelAndView afficherTousVoyages(){
		ModelAndView model=new ModelAndView("accueilClient");
		model.addObject("listeVoyages", voyServ.getAllVoyage());
		model.addObject("listeComs", comServ.getAllCommentaires());
		return model;
	}
	
	@RequestMapping(value="/afficheCreationDossier",method=RequestMethod.GET)
	public ModelAndView afficherFormParticipant(@RequestParam("pId") long id){
		ModelAndView model=new ModelAndView("nouveauDossier");
		Voyage v=new Voyage();
		v.setId_v(id);
		model.addObject("voyageSelect", voyServ.getVoyageById(v));
		model.addObject("dossier", new Dossier());
		return model;
	}
	
	@RequestMapping(value="/creerNouveauDossier",method=RequestMethod.POST)
	public ModelAndView afficherParti(@ModelAttribute("dossier") Dossier dos){
		ModelAndView model=new ModelAndView("ajoutParticipant");
		dos.setStatutdossier("En attente");
		Dossier dosOut=dosServ.addDossier(dos);
		model.addObject("voyageSelect", voyServ.getVoyageById(dos.getVoyageDos()));
		model.addObject("dossier",dosOut);
		model.addObject("listeP", partServ.getParticipantByClient(dos.getClientDos().getId()));
		model.addObject("participant", new Participant());
		model.addObject("dossierRecup", new Dossier());
		return model;
		
	}
	
	
	@RequestMapping(value="/ajouterParticipant",method=RequestMethod.POST)
	public ModelAndView ajouterParticipant(@ModelAttribute("participant") Participant part, @RequestParam("idDossier")long idDos){
		ModelAndView model=new ModelAndView("ajoutParticipant");
		Dossier dosOut=dosServ.getDossierById(idDos);
		partServ.addParticipant(part);
		model.addObject("voyageSelect", voyServ.getVoyageById(dosOut.getVoyageDos()));
		model.addObject("dossier",dosOut);
		model.addObject("listeP", partServ.getParticipantByClient(dosOut.getClientDos().getId()));
		model.addObject("participant", new Participant());
		model.addObject("dossierRecup", new Dossier());
		return model;
		
	}
	
	@RequestMapping(value="/continuerReservation",method=RequestMethod.POST)
	public ModelAndView calculerTarif(@ModelAttribute("dossierRecup") Dossier dos){
		ModelAndView model=new ModelAndView("affichageFacture");
		Dossier dosOut=dosServ.getDossierById(dos.getId());
		List<Participant> listeP=partServ.getParticipantByClient(dosOut.getClientDos().getId());
		Voyage voOut=voyServ.getVoyageById(dosOut.getVoyageDos());
		dosOut.setPrixTotal(voOut.getTarif());
		for(Participant p : listeP){
			Date dnp = p.getDn();
			Date dUtil=new Date(dnp.getYear(), dnp.getMonth(), dnp.getDay());
			LocalDate date = dUtil.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
			LocalDate aujourdhui = LocalDate.now(); 
			Period periode = Period.between(date, aujourdhui);
			int age=periode.getYears();
			if (age<12){
				dosOut.setPrixTotal(dosOut.getPrixTotal()+voOut.getTarif()*0.6);
			}else{
				dosOut.setPrixTotal(dosOut.getPrixTotal()+voOut.getTarif());
			}
		}
		dosServ.updateDossier(dosOut);
		model.addObject("dossier",dosOut);
		return model;
		
	}

	
	@RequestMapping(value="/finir",method=RequestMethod.POST)
	public ModelAndView retraitBancaire(@ModelAttribute("dossier") Dossier dos,@RequestParam("pCB") String numCB,RedirectAttributes rda){
		ModelAndView model=new ModelAndView("redirect:afficheAccueil");
		Dossier dosOut=dosServ.getDossierById(dos.getId());
		Client clOut=clServ.getClientById(dosOut.getClientDos().getId());
		List<Participant> listeP=partServ.getParticipantByClient(clOut.getId());
		Voyage voOut=voyServ.getVoyageById(dosOut.getVoyageDos());
		voOut.setNbPlaces(voOut.getNbPlaces()-listeP.size());
		voyServ.updateVoyage(voOut);
		clOut.setNumcb(numCB);
		clServ.updateClient(clOut);
		int verif=banqueServ.retirerTarif(clOut.getNumcb(), dosOut.getPrixTotal());
		if (verif!=0){
			dosOut.setStatutdossier("En cours");
			dosServ.updateDossier(dosOut);
			rda.addFlashAttribute("msg", "Réservation effectuée");
		}else{
			dosOut.setStatutdossier("Annulé");
			dosServ.updateDossier(dosOut);
		}
		return model;
		
	}
	
	@RequestMapping(value="/annuler",method=RequestMethod.POST)
	public ModelAndView annulerVoyage(@ModelAttribute("dossier") Dossier dos,RedirectAttributes rda){
		ModelAndView model=new ModelAndView("redirect:afficheAccueil");
		int verif=dosServ.deleteDossier(dos.getId());
		if (verif==0){
			rda.addFlashAttribute("msg", "Annulation echouée");
		}
		return model;
		
	}
	
	@RequestMapping(value="/afficheDossier",method=RequestMethod.GET)
	public ModelAndView afficherDossiers(@RequestParam("pId") long id){
		ModelAndView model=new ModelAndView("accueilDos2");
		model.addObject("liste",dosServ.getDossiersByIdClient(id));
		return model;
	}
	
	@RequestMapping(value="/delete/{pId}",method=RequestMethod.GET)
	public ModelAndView supprimerVoyage(@PathVariable("pId") long id){
		ModelAndView model=new ModelAndView("redirect:afficheAccueil");
		Dossier dosOut=dosServ.getDossierById(id);
		if (dosOut.isAssurance()){
			banqueServ.rembourserClient(clServ.getClientById(dosOut.getClientDos().getId()).getNumcb(), dosOut.getPrixTotal());
		}
		dosServ.deleteDossier(id);
		return model;
	}
	
	@RequestMapping(value="/deleteLink",method=RequestMethod.GET)
	public ModelAndView effacerParticipant(@RequestParam("pId") long idPart, @RequestParam("pIdDossier")long idDos){
		ModelAndView model=new ModelAndView("ajoutParticipant");
		Dossier dosOut=dosServ.getDossierById(idDos);
		Long id=idPart;
		partServ.deleteParticipant(id);
		model.addObject("voyageSelect", voyServ.getVoyageById(dosOut.getVoyageDos()));
		model.addObject("dossier",dosOut);
		model.addObject("listeP", partServ.getParticipantByClient(dosOut.getClientDos().getId()));
		model.addObject("participant", new Participant());
		model.addObject("dossierRecup", new Dossier());
		return model;
		
	}
	
}
