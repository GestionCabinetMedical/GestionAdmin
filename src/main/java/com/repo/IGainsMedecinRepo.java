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

}
