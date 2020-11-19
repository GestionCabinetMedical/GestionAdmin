/**
 * 
 */
package com.service;

import java.util.Date;

import com.entity.GainsAppli;

/**
 * Interface service de GainsAppli responsable des méthodes spéciales à GainsAppli.
 * 
 * @author Maxime Rembert
 *
 */
public interface IGainsAppliService {
	
	/**
	 * Méthdoe permettant la recherche de gain par date.
	 * 
	 * @param date Date du gains recherché.
	 * @return Une entité GainsAppli.
	 */
	public GainsAppli findByDate(Date date);
	
	/**
	 * Méthode permettant de calculer le gains de l'appli par jour.
	 * @return Le gains correspondant au jour.
	 */
	public GainsAppli calculGainsBySpecialite( String specialite);

}
