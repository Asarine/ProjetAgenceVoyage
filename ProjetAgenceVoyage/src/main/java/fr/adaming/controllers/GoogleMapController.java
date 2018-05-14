package fr.adaming.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/goCTRL")
public class GoogleMapController {

	
	@RequestMapping(value="/afficheGooglemap", method=RequestMethod.GET)
	public String googlemap(){
		return "GoogleMap";
	}
}
