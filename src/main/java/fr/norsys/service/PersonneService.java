package fr.norsys.service;

import fr.norsys.domain.Personne;

import java.util.List;

import static java.util.Arrays.asList;

public class PersonneService {

	public List<Personne> getPersonnes() {
		Personne ammach = new Personne(55L, "ammach", "medamine", asList("ferrari"));
		Personne anais = new Personne(100L, "anais", "marie");
		return asList(ammach, anais);
	}

	public Personne createPersonne() {
		return new Personne(100L, "ammach", "medamine");
	}

}
