package fr.norsys.domain;

import lombok.*;

import java.util.ArrayList;
import java.util.List;


@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(exclude = "voitures")
@ToString
public class Personne {

	private Long id;
	private String nom;
	private String prenom;
	private List<String> voitures = new ArrayList<>();

	public Personne(final Long id, final String nom) {
		this.id = id;
		this.nom = nom;
	}

	public Personne(final Long id, final String nom, final String prenom) {
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
	}
}
