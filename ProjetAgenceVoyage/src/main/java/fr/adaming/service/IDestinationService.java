package fr.adaming.service;

import java.util.List;

import fr.adaming.model.Destination;

public interface IDestinationService {
	

	public Destination addDestination(Destination ds);
	
	public long updateDestination(Destination ds);
	
	public Destination getDestinationbyId(long id_d);
	
	public long deleteDestination(long id_d);
	
	public List<Destination> getAllDestination();

}
