package com.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dto.ResponseDto;
import com.entity.Formule;
import com.exception.notfound.FormuleNotFoundException;
import com.service.IFormuleService;

import lombok.extern.slf4j.Slf4j;

/**
 * Classe controller {@code FormuleControllerImpl} spécifique de {@link Formule},
 * et qui étend de {@code DaoControllerImpl}, 
 * @see DaoControllerImpl
 * 
 * @author Maxime Rembert
 *
 */
@RestController
@RequestMapping(path = "/formule")
@CrossOrigin(allowCredentials = "true", origins = "http://localhost:4200")
@Slf4j
public class FormuleControllerImpl extends DaoControllerImpl<Formule>{
	
	// ATTRIBUTS
	
	@Autowired
	private IFormuleService serv;

	// METHODES
	
	/**
	 * Méthdoe permettant la recherche d'une formule par spécialité de médecin.
	 * 
	 * @param specialité String de la formule recherchée.
	 * @return Un responseDto composé d'un booleen error, un body (=entite) et d'un
	 *         status http (200 ou 400).
	 * @throws FormuleNotFoundException 
	 */
	public ResponseDto<Formule> findBySpecialite(String specialite) throws FormuleNotFoundException {
		
		log.info("Classe formule controller : méthode find by specialite appelée !");
		return makeDtoResponse(serv.findBySpecialite(specialite));
	}


}
