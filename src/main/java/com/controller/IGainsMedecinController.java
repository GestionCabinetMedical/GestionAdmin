/**
 * 
 */
package com.controller;

import java.util.Date;

import com.dto.ResponseDto;
import com.entity.GainsMedecin;
import com.exception.notfound.FormuleNotFoundException;
import com.exception.notfound.GainsMedecinNotFoundException;
import com.exception.notfound.MedecinDtoNotFoundException;
import com.exception.notsuccess.GainsMedecinNotSuccessException;

/**
 * @author Pauline Humbert
 * 
 *  Interface controller de GainsMedecin redéfinition des méthodes spéciales à cette entité et étend de IDaoController.
 *
 */
public interface IGainsMedecinController extends IDaoController<GainsMedecin>{
	
	/**
	 * Méthdoe permettant la recherche des gains d'un par date et par medecin.
	 * 
	 * @param date Date du gains recherché.
	 * @param idMedecin Long du médecin dont on recherche les gains
	 * @return Un responseDto composé d'un booleen error, un body (=entite) et d'un status http (200 ou 400).
	 * @throws GainsMedecinNotFoundException 
	 */
	public ResponseDto<GainsMedecin> findByDateAndIdMedecin(Date date, Long idMedecin) throws GainsMedecinNotFoundException;
	
	/**
	 * Méthdoe permettant le calcul des gains d'un medecin après une consultation pour une journée (date du jour).
	 * 
	 * @param idMedecin Long du médecin dont on souhaite calculer les gains
	 * @return Un responseDto composé d'un booleen error, un body (=entite) et d'un status http (200 ou 400).
	 * @throws GainsMedecinNotSuccessException 
	 * @throws FormuleNotFoundException 
	 * @throws MedecinDtoNotFoundException 
	 * @throws GainsMedecinNotFoundException 
	 */
	public ResponseDto<GainsMedecin> calculGainsMedecin(Long idMedecin) throws GainsMedecinNotFoundException, MedecinDtoNotFoundException, FormuleNotFoundException, GainsMedecinNotSuccessException;

}
