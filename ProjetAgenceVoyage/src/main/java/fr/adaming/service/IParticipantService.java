package fr.adaming.service;

import java.util.List;

import fr.adaming.model.Participant;

public interface IParticipantService {
	public int addParticipant(Participant p);

	public int updateParticipant(Participant p);

	public int deleteParticipant(Long id);

	public Participant searchParticipant(Long id);

	public List<Participant> getAllParticipant();
}
