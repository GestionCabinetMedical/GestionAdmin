package com.service;

import java.util.Date;

import com.entity.GainsMedecin;
import com.exception.notfound.FormuleNotFoundException;
import com.exception.notfound.GainsMedecinNotFoundException;
import com.exception.notfound.MedecinDtoNotFoundException;
import com.exception.notsuccess.GainsMedecinNotSuccessException;

/**
 * @author Pauline Humbert
 *
 * Interface service {@code IGainsMedecinService} spécifique de {@link GainsMedecin}
 *  Elle étend de {@code IDaoService}
 * @see IDaoService
 */
public interface IGainsMedecinService extends IDaoService<GainsMedecin>{
	
	/**
	 * Méthdoe permettant la recherche des gains d'un par date et par medecin.
	 * 
	 * @param date Date du gains recherché.
	 * @param idMedecin Long du médecin dont on recherche les gains
	 * @return Une entité GainsMedecin.
	 * @throws GainsMedecinNotFoundException 
	 */
	public GainsMedecin findByDateAndIdMedecin(Date date, Long idMedecin) throws GainsMedecinNotFoundException;
	
	/**
	 * Méthdoe permettant le calcul des gains d'un medecin après une consultation pour une journée (date du jour).
	 * 
	 * @param idMedecin Long du médecin dont on souhaite calculer les gains
	 * @return L'entité Medecin modifiée. Modification de l'attribut "gains" une fois l'entité GainsMedecin adéquate récupérée
	 * @throws FormuleNotFoundException 
	 * @throws MedecinDtoNotFoundException 
	 * @throws GainsMedecinNotFoundException 
	 * @throws GainsMedecinNotSuccessException 
	 */
	public GainsMedecin calculGainsMedecin(Long idMedecin) throws GainsMedecinNotFoundException, MedecinDtoNotFoundException, FormuleNotFoundException, GainsMedecinNotSuccessException;

}
