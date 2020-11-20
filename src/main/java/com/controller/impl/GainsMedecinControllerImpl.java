/**
 * 
 */
package com.controller.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.controller.IGainsMedecinController;
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
 * Elle étend de DaoControllerImpl et implémente les méthodes de IGainsMedecinController.
 *
 */
@RestController
@RequestMapping(path="/gainsMedecin")
@Slf4j
public class GainsMedecinControllerImpl extends DaoControllerImpl<GainsMedecin> implements IGainsMedecinController{
	
	// ATTRIBUTS 
	
	@Autowired
	private IGainsMedecinService gainsMedecinService;
	
	// METHODES
	
	@Override	
	@GetMapping (path="/date")
	public ResponseDto<GainsMedecin> findByDateAndIdMedecin(@RequestParam Date date, @RequestParam Long idMedecin) throws GainsMedecinNotFoundException {
		// TODO Auto-generated method stub
		log.info("Classe gains medecin controller : méthdoe findByDateAndIdMedecin appelée");		
		return makeDtoResponse(gainsMedecinService.findByDateAndIdMedecin(date, idMedecin));
	}

	@Override
	@PostMapping (path="/ajoutGainsMedecin")
	public ResponseDto<GainsMedecin> calculGainsMedecin(@RequestParam Long idMedecin) throws GainsMedecinNotFoundException, MedecinDtoNotFoundException, FormuleNotFoundException, GainsMedecinNotSuccessException {
		// TODO Auto-generated method stub
		log.info("Classe gains appli controller : méthode calculGainsMedecin appelée");
		return makeDtoResponse(gainsMedecinService.calculGainsMedecin(idMedecin));
	}

}
