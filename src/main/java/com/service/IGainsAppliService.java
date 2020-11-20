/**
 * 
 */
package com.service;

import java.util.Date;

import com.entity.GainsAppli;
import com.exception.notfound.FormuleNotFoundException;
import com.exception.notfound.GainsAppliNotFoundException;
import com.exception.notsuccess.GainsAppliNotSuccessException;

/**
 * Interface service de GainsAppli responsable des méthodes spéciales à
 * GainsAppli. Elle étend de {@code IDaoService}
 * @see IDaoService
 * 
 * @author Maxime Rembert
 *
 */
public interface IGainsAppliService extends IDaoService<GainsAppli>{

	/**
	 * Méthdoe permettant la recherche de gain par date.
	 * 
	 * @param date Date du gains recherché.
	 * @return Une entité GainsAppli.
	 * @throws GainsAppliNotFoundException 
	 */
	public GainsAppli findByDate(Date date) throws GainsAppliNotFoundException;

	/**
	 * Méthode permettant de calculer le gains de l'appli par jour. * @param
	 * specialite Specialite du Medecin.
	 * 
	 * @return Le gains correspondant au jour.
	 * @throws GainsAppliNotSuccessException 
	 * @throws GainsAppliNotFoundException 
	 * @throws FormuleNotFoundException 
	 */
	public GainsAppli calculGainsBySpecialite(String specialite) throws FormuleNotFoundException, GainsAppliNotFoundException, GainsAppliNotSuccessException;

}
