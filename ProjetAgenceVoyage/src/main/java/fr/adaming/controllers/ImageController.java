package fr.adaming.controllers;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import fr.adaming.model.Fichiers;
import fr.adaming.model.Image;
import fr.adaming.service.IImageService;

@Controller
@RequestMapping("/image")
@Scope("session")
public class ImageController {
	
	@Autowired
	private IImageService imgServ;
	
	@RequestMapping(value = "/ajoutImg", method = RequestMethod.GET)
	public String afficherForm(Model modele){
		modele.addAttribute("groupeFichier", new Fichiers());
		return "ajoutImage";
	}
	
	@RequestMapping(value = "/ajoutImgBD", method = RequestMethod.POST)
	public String ajouterImages(@ModelAttribute("groupeFichier") Fichiers fs){
		 List<MultipartFile> files = fs.getImages();
		 
		 for (MultipartFile fi : files){
			 try {
				Image img=new Image(fi.getBytes());
				imgServ.addImage(img);
				
			} catch (IOException e) {
				e.printStackTrace();
				return "accueilConseiller";
			}

		 }
		 return "accueilConseiller";
	}

}
