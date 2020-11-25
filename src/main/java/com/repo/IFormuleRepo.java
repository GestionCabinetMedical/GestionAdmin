package com.repo;

import org.springframework.stereotype.Repository;

import com.entity.Formule;
import com.exception.notfound.FormuleNotFoundException;

/**
 * Interface repository {@code IFormuleRepo} spécifique de {@link Formule}. 
 * Elle étend {@code IDaoRepo}.
 * @see IDaoRepo
 * 
 * @author Maxime Rembert
 *
 */
@Repository
public interface IFormuleRepo extends IDaoRepo<Formule> {

	/**
	 * Méthode permettant de rechercher une formule par spécialite.
	 * 
	 * @param specialite Specialite du medecin.
	 * @return Une entité Formule.
	 * @throws FormuleNotFoundException
	 */
	public Formule findBySpecialite(String specialite) throws FormuleNotFoundException;
}
