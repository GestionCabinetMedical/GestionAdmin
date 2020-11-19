/**
 * 
 */
package com.controller;

import java.util.Date;

import com.dto.ResponseDto;
import com.entity.GainsAppli;

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
	 */
	public ResponseDto<GainsAppli> findByDate(Date date);
	
	/**
	 * Méthdoe permettant de calculer le gains de l'appli par date.
	 * @param date Date du gains à calculer.
	 * @return Un responseDto composé d'un booleen error, un body (=entite) et d'un
	 *         status http (200 ou 400).
	 */
	public ResponseDto<GainsAppli> calculGainsByDate(Date date);

}
