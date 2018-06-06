package fr.norsys.service;

import java.util.Arrays;
import java.util.List;

import fr.norsys.domain.Personne;

public class PersonneService {

	public PersonneService() {
	}

	public List<Personne> getPersonnes() {
		final Personne personne1 = new Personne(55L, "ammach", "medamine");
		personne1.voitures = Arrays.asList("ferrari");
		final Personne personne2 = new Personne(100L, "anais", "marie");
		return Arrays.asList(personne1, personne2);
	}

	public Personne createPersonne() {
		return new Personne(100L, "ammach", "medamine");
	}

}
