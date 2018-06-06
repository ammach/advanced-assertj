package fr.norsys.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.assertj.core.groups.Tuple;
import org.junit.Before;
import org.junit.Test;

import fr.norsys.domain.Personne;

public class PersonneServiceTest {

	private PersonneService personneService;

	@Before
	public void setUp() throws Exception {
		this.personneService = new PersonneService();
	}

	@Test
	public void should_get_personnes() {
		final List<Personne> personnes = this.personneService.getPersonnes();
		assertThat(personnes).isNotEmpty().hasSize(2);

		assertThat(personnes).extracting("nom").containsExactly("ammach", "anais").doesNotContain("real");
		assertThat(personnes).extracting("nom", "prenom").contains(new Tuple("ammach", "medamine"));

		assertThat(personnes).filteredOn("nom", "ammach").hasSize(1);
		assertThat(personnes).filteredOn(p -> p.nom.startsWith("a")).hasSize(2);

		assertThat(personnes).flatExtracting("voitures").contains("ferrari");
	}

	@Test
	public void should_create_personne() {
		final Personne personne = this.personneService.createPersonne();
		// hash and equals is on fields; id/nom/prenom
		assertThat(personne).isEqualToComparingOnlyGivenFields(new Personne(100L, "ammach"));
	}

}
