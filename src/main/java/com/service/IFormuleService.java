/**
 * 
 */
package com.service;

import com.entity.Formule;

/**
 * Interface service de Formule responsable des méthodes spéciales à cette
 * entité.
 * 
 * @author Maxime Rembert
 *
 */
public interface IFormuleService {

	/**
	 * Méthode permettant de rechercher une formule par spécialite.
	 * 
	 * @param specialite Specialite du medecin.
	 * @return Une entité Formule.
	 */
	public Formule findBySpecialite(String specialite);

}
