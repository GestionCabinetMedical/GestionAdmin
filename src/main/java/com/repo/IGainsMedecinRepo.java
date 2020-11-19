package com.repo;

import java.util.Date;

import org.springframework.stereotype.Repository;

import com.entity.GainsMedecin;

/**
 * @author Pauline Humbert
 * 
 * Interface repository de l'entité GainsMedecin qui étend de IDaoRepo.
 *
 */
@Repository
public interface IGainsMedecinRepo extends IDaoRepo<GainsMedecin>{
	
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
