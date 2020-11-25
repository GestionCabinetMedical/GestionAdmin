package com.repo;

import java.util.Date;

import org.springframework.stereotype.Repository;

import com.entity.GainsMedecin;
import com.exception.notfound.GainsMedecinNotFoundException;

/**
 * @author Pauline Humbert
 * 
 * Interface repository {@code IGainsMedecinRepo} spécifique de {@link GainsMedecin} qui étend de {@code IDaoRepo}.
 * @see IDaoRepo
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
	 * @throws GainsMedecinNotFoundException
	 */
	public GainsMedecin findByDateAndIdMedecin(Date date, Long idMedecin) throws GainsMedecinNotFoundException;

}
