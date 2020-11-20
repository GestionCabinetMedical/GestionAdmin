package com.controller.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.controller.IGainsAppliController;
import com.dto.ResponseDto;
import com.entity.GainsAppli;
import com.exception.notfound.FormuleNotFoundException;
import com.exception.notfound.GainsAppliNotFoundException;
import com.exception.notsuccess.GainsAppliNotSuccessException;
import com.service.IGainsAppliService;

import lombok.extern.slf4j.Slf4j;

/**
 * Classe controller de GainsAppli responsables des méthodes spéciales à cette
 * entité. Elle étend {@code DaoControllerImpl}.
 * @see DaoControllerImpl
 * 
 * @author Maxime Rembert
 *
 */
@RestController
@RequestMapping (path="/gainsApi")
@CrossOrigin(allowCredentials = "true", origins = "http://localhost:4200")
@Slf4j
public class GainsAppliControllerImpl extends DaoControllerImpl<GainsAppli> implements IGainsAppliController {
	
	// ATTRIBUTS
	
	@Autowired
	private IGainsAppliService serv;

	// METHODES
	
	@Override
	@GetMapping (path="/date")
	public ResponseDto<GainsAppli> findByDate(@RequestParam Date date) throws GainsAppliNotFoundException {
		log.info("Classe gains appli controller : méthode find by date appelée");
		return makeDtoResponse(serv.findByDate(date));
	}

	@Override
	@PostMapping (path="/ajoutGains")
	public ResponseDto<GainsAppli> calculGainsBySpecialite(@RequestParam String specialite) throws FormuleNotFoundException, GainsAppliNotFoundException, GainsAppliNotSuccessException {
		log.info("Classe gains appli controller : méthode calcul gain by date and specialite appelée");
		return makeDtoResponse(serv.calculGainsBySpecialite( specialite));
	}

}
