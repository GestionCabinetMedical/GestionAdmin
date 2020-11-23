package com.service;

import com.entity.Formule;
import com.exception.notfound.FormuleNotFoundException;

/**
 * Interface service {@code IFormuleService} spécifique de {@link Formule}.
 * Elle étend de {@code IDaoService}
 * @see IDaoService
 * 
 * @author Maxime Rembert
 *
 */
public interface IFormuleService extends IDaoService<Formule>{

	/**
	 * Méthode permettant de rechercher une formule par spécialite.
	 * 
	 * @param specialite Specialite du medecin.
	 * @return Une entité Formule.
	 * @throws FormuleNotFoundException 
	 */
	public Formule findBySpecialite(String specialite) throws FormuleNotFoundException;

}
