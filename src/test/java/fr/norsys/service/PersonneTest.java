package fr.norsys.service;

import fr.norsys.domain.Personne;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.assertj.core.groups.Tuple;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.List;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(JUnitParamsRunner.class)
public class PersonneTest {


	@Test
	@Parameters
	public void should_get_personnes(List<Personne> personnes) {
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

	private Object[] parametersForShould_get_personnes() {
		return new Object[]{
				new Object[]{asList(
						new Personne(55L, "ammach", "medamine", asList("ferrari")),
						new Personne(100L, "anais", "marie")
				)}
		};
	}

	@Test
	@Parameters
	public void should_create_personne(Personne personne) {
		// hash and equals is on fields; id/nom/prenom
		assertThat(personne).isEqualToIgnoringNullFields(new Personne(100L, "ammach"));
	}

	private Object[] parametersForShould_create_personne() {
		return new Object[]{
				new Object[]{new Personne(100L, "ammach", "medamine")}
		};
	}

}
