/**
 * 
 */
package com.controller.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.controller.IGainsMedecinController;
import com.dto.ResponseDto;
import com.entity.GainsMedecin;
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
	
	@Autowired
	private IGainsMedecinService gainsMedecinService;
	
	@Override	
	@GetMapping (path="/date")
	public ResponseDto<GainsMedecin> findByDateAndIdMedecin(@RequestParam Date date, @RequestParam Long idMedecin) {
		// TODO Auto-generated method stub
		log.info("Classe gains medecin controller : méthdoe find by date by idMedecin appelée");		
		return makeDtoResponse(gainsMedecinService.findByDateAndIdMedecin(date, idMedecin));
	}

	@Override
	public ResponseDto<GainsMedecin> calculGainsMedecin(Long idMedecin) {
		// TODO Auto-generated method stub
		return makeDtoResponse(gainsMedecinService.calculGainsMedecin(idMedecin));
	}

}
