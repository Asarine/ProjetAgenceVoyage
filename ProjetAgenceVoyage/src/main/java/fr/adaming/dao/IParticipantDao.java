package fr.adaming.dao;

import java.util.List;

import fr.adaming.model.Participant;

public interface IParticipantDao {
	public int addParticipant(Participant p);

	public int updateParticipant(Participant p);

	public int deleteParticipant(Long id);

	public Participant searchParticipant(Long id);

	public List<Participant> getAllParticipant();
	
	public List<Participant> getParticipantByClient(Long id);
}
