package fr.norsys.domain;

import java.util.ArrayList;
import java.util.List;

public class Personne {

	public Long id;
	public String nom;
	public String prenom;
	public List<String> voitures = new ArrayList<>();

	public Personne() {
	}

	public Personne(final Long id, final String nom) {
		this.id = id;
		this.nom = nom;
	}

	public Personne(final Long id, final String nom, final String prenom) {
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (this.id == null ? 0 : this.id.hashCode());
		result = prime * result + (this.nom == null ? 0 : this.nom.hashCode());
		result = prime * result + (this.prenom == null ? 0 : this.prenom.hashCode());
		return result;
	}

	@Override
	public boolean equals(final Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (this.getClass() != obj.getClass()) {
			return false;
		}
		final Personne other = (Personne) obj;
		if (this.id == null) {
			if (other.id != null) {
				return false;
			}
		} else if (!this.id.equals(other.id)) {
			return false;
		}
		if (this.nom == null) {
			if (other.nom != null) {
				return false;
			}
		} else if (!this.nom.equals(other.nom)) {
			return false;
		}
		if (this.prenom == null) {
			if (other.prenom != null) {
				return false;
			}
		} else if (!this.prenom.equals(other.prenom)) {
			return false;
		}
		return true;
	}



}
