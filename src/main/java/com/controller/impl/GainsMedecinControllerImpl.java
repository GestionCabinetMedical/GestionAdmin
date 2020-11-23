package com.controller.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dto.ResponseDto;
import com.entity.GainsMedecin;
import com.exception.notfound.FormuleNotFoundException;
import com.exception.notfound.GainsMedecinNotFoundException;
import com.exception.notfound.MedecinDtoNotFoundException;
import com.exception.notsuccess.GainsMedecinNotSuccessException;
import com.service.IGainsMedecinService;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Pauline Humbert
 * 
 * Classe controller de GainsMedecin implémente des méthodes spéciales à cette entité. 
 * Elle étend de {@code DaoControllerImpl}.
 * @see DaoControllerImpl
 * 
 */
@RestController
@RequestMapping(path="/gainsMedecin")
@Slf4j
public class GainsMedecinControllerImpl extends DaoControllerImpl<GainsMedecin>{
	
	// ATTRIBUTS 
	
	@Autowired
	private IGainsMedecinService gainsMedecinService;
	
	// METHODES
	
	/**
	 * Méthdoe permettant la recherche des gains d'un par date et par medecin.
	 * 
	 * @param date Date du gains recherché.
	 * @param idMedecin Long du médecin dont on recherche les gains
	 * @return Un responseDto composé d'un booleen error, un body (=entite) et d'un status http (200 ou 400).
	 * @throws GainsMedecinNotFoundException 
	 */
	@GetMapping (path="/date")
	public ResponseDto<GainsMedecin> findByDateAndIdMedecin(@RequestParam Date date, @RequestParam Long idMedecin) throws GainsMedecinNotFoundException {
		// TODO Auto-generated method stub
		log.info("Classe gains medecin controller : méthdoe findByDateAndIdMedecin appelée");		
		return makeDtoResponse(gainsMedecinService.findByDateAndIdMedecin(date, idMedecin));
	}

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
	@PostMapping (path="/ajoutGainsMedecin")
	public ResponseDto<GainsMedecin> calculGainsMedecin(@RequestParam Long idMedecin) throws GainsMedecinNotFoundException, MedecinDtoNotFoundException, FormuleNotFoundException, GainsMedecinNotSuccessException {
		// TODO Auto-generated method stub
		log.info("Classe gains appli controller : méthode calculGainsMedecin appelée");
		return makeDtoResponse(gainsMedecinService.calculGainsMedecin(idMedecin));
	}

}
