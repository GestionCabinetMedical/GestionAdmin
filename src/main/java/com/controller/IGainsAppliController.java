/**
 * 
 */
package com.controller;

import java.util.Date;

import com.dto.ResponseDto;
import com.entity.GainsAppli;
import com.exception.notfound.FormuleNotFoundException;
import com.exception.notfound.GainsAppliNotFoundException;
import com.exception.notsuccess.GainsAppliNotSuccessException;

/**
 * Interface controller de GainsAppli responsables des méthodes spéciales à
 * cette entité.
 * 
 * @author Maxime Rembert
 *
 */
public interface IGainsAppliController {

	/**
	 * Méthdoe permettant la recherche de gain par date.
	 * 
	 * @param date Date du gains recherché.
	 * @return Un responseDto composé d'un booleen error, un body (=entite) et d'un
	 *         status http (200 ou 400).
	 * @throws GainsAppliNotFoundException 
	 */
	public ResponseDto<GainsAppli> findByDate(Date date) throws GainsAppliNotFoundException;
	
	/**
	 * Méthdoe permettant de calculer le gains de l'appli par date.
	 * @param date Date du gains à calculer.
	 * @param specialite Specialite du médecin.
	 * @return Un responseDto composé d'un booleen error, un body (=GainsAppli) et d'un
	 *         status http (200 ou 400).
	 * @throws GainsAppliNotSuccessException 
	 * @throws GainsAppliNotFoundException 
	 * @throws FormuleNotFoundException 
	 */
	public ResponseDto<GainsAppli> calculGainsBySpecialite(String specialite) throws FormuleNotFoundException, GainsAppliNotFoundException, GainsAppliNotSuccessException;

}
