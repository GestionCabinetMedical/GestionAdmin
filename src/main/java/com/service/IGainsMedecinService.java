package com.service;

import java.util.Date;

import com.entity.GainsMedecin;

/**
 * @author Pauline Humbert
 *
 * Interface service de GainsMedecin responsable des méthodes spécifiques à GainsMedecin.
 */
public interface IGainsMedecinService extends IDaoService<GainsMedecin>{
	
	/**
	 * Méthdoe permettant la recherche des gains d'un par date et par medecin.
	 * 
	 * @param date Date du gains recherché.
	 * @param idMedecin Long du médecin dont on recherche les gains
	 * @return Une entité GainsMedecin.
	 */
	public GainsMedecin findByDateAndIdMedecin(Date date, Long idMedecin);
	
	/**
	 * Méthdoe permettant le calcul des gains d'un medecin après une consultation pour une journée (date du jour).
	 * 
	 * @param idMedecin Long du médecin dont on souhaite calculer les gains
	 * @return void: pas de retour. Modification de l'attribut "gains" une fois l'entité GainsMedecin adéquate récupérée
	 */
	public void calculGainsMedecin(Long idMedecin);

}
