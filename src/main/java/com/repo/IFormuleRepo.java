/**
 * 
 */
package com.repo;

import com.entity.Formule;

/**
 * Interface repository de la classe Formule. Elle étend IDaoRepo.
 * 
 * @author Maxime Rembert
 *
 */
public interface IFormuleRepo extends IDaoRepo<Formule> {

	/**
	 * Méthode permettant de rechercher une formule par spécialite.
	 * 
	 * @param specialite Specialite du medecin.
	 * @return Une entité Formule.
	 */
	public Formule findBySpecialite(String specialite);
}
