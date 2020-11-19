/**
 * 
 */
package com.repo;

import org.springframework.stereotype.Repository;

import com.entity.Formule;

/**
 * Interface repository de la classe Formule. Elle étend IDaoRepo.
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
	 */
	public Formule findBySpecialite(String specialite);
}
