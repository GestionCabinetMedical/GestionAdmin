/**
 * 
 */
package com.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.controller.IDaoController;
import com.controller.IFormuleController;
import com.dto.ResponseDto;
import com.entity.Formule;
import com.exception.notfound.FormuleNotFoundException;
import com.service.IFormuleService;

import lombok.extern.slf4j.Slf4j;

/**
 * Classe controller de Formule étendant de {@code DaoControllerImpl}.
 * @see DaoControllerImpl
 * 
 * @author Maxime Rembert
 *
 */
@RestController
@RequestMapping(path = "/formule")
@CrossOrigin(allowCredentials = "true", origins = "http://localhost:4200")
@Slf4j
public class FormuleControllerImpl extends DaoControllerImpl<Formule>  implements IFormuleController {
	
	// ATTRIBUTS
	
	@Autowired
	private IFormuleService serv;

	// METHODES
	
	@Override
	public ResponseDto<Formule> findBySpecialite(String specialite) throws FormuleNotFoundException {
		
		log.info("Classe formule controller : méthode find by specialite appelée !");
		return makeDtoResponse(serv.findBySpecialite(specialite));
	}


}
