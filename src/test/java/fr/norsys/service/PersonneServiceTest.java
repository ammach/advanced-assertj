package fr.norsys.service;

import fr.norsys.domain.Personne;
import org.assertj.core.groups.Tuple;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class PersonneServiceTest {

	private PersonneService personneService;

	@Before
	public void setUp() {
		this.personneService = new PersonneService();
	}

	@Test
	public void should_get_personnes() {
		List<Personne> personnes = this.personneService.getPersonnes();

		assertThat(personnes).isNotEmpty().hasSize(2);

		assertThat(personnes).extracting(Personne::getNom)
                             .containsExactly("ammach", "anais")
                             .doesNotContain("real");

		assertThat(personnes).extracting(Personne::getNom, Personne::getPrenom)
                             .contains(new Tuple("ammach", "medamine"));

		assertThat(personnes).filteredOn("nom", "ammach")
                             .hasSize(1);

		assertThat(personnes).filteredOn(p -> p.getNom().startsWith("a"))
                             .hasSize(2);

		assertThat(personnes).flatExtracting(Personne::getVoitures)
                             .contains("ferrari");
	}

	@Test
	public void should_create_personne() {
		final Personne personne = this.personneService.createPersonne();
		// hash and equals is on fields; id/nom/prenom
		assertThat(personne).isEqualToComparingOnlyGivenFields(new Personne(100L, "ammach"));
	}

}
