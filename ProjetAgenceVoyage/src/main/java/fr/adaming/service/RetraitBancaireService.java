package fr.adaming.service;

import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;

import org.springframework.stereotype.Service;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.json.JSONConfiguration;
import com.sun.jersey.core.util.MultivaluedMapImpl;

@Service
public class RetraitBancaireService implements IRetraitBancaireService{

	public final static String URL="http://192.168.1.33:8080/04_a_Jersey_SpringIoC_Hibernate_WS/rest/";
	
	@Override
	public int retirerTarif(String numCB, int sommeTotale) {
		MultivaluedMap<String,String> map=new MultivaluedMapImpl();
		map.add("numCB", numCB);
		map.add("tarif", Integer.toString(sommeTotale));
		ClientConfig config=new DefaultClientConfig();
		config.getFeatures().put(JSONConfiguration.FEATURE_POJO_MAPPING, true);
		Client restCLient=Client.create(config);
		WebResource wr=restCLient.resource(URL);
		int verif=wr.path("banqueWS/retrait").queryParams(map).accept(MediaType.APPLICATION_JSON).get(Integer.class);
		return verif;
	}

}
