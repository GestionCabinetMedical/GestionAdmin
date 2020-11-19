/**
 * 
 */
package com.controller;

import java.util.Date;

import com.dto.ResponseDto;
import com.entity.GainsAppli;
import com.entity.GainsMedecin;

/**
 * @author Pauline Humbert
 * 
 *  Interface controller de GainsMedecin redéfinition des méthodes spéciales à cette entité.
 *
 */
public interface IGainsMedecinController {
	
	/**
	 * Méthdoe permettant la recherche des gains d'un par date et par medecin.
	 * 
	 * @param date Date du gains recherché.
	 * @param idMedecin Long du médecin dont on recherche les gains
	 * @return Un responseDto composé d'un booleen error, un body (=entite) et d'un status http (200 ou 400).
	 */
	public ResponseDto<GainsMedecin> findByDateAndIdMedecin(Date date, Long idMedecin);
	
	/**
	 * Méthdoe permettant le calcul des gains d'un medecin après une consultation pour une journée (date du jour).
	 * 
	 * @param idMedecin Long du médecin dont on souhaite calculer les gains
	 * @return Un responseDto composé d'un booleen error, un body (=entite) et d'un status http (200 ou 400).
	 */
	public ResponseDto<GainsMedecin> calculGainsMedecin(Long idMedecin);

}
