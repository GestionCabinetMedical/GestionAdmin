/**
 * 
 */
package com.service;

import com.entity.Formule;
import com.exception.notfound.FormuleNotFoundException;

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
	 * @throws FormuleNotFoundException 
	 */
	public Formule findBySpecialite(String specialite) throws FormuleNotFoundException;

}
