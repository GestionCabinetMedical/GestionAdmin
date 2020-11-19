/**
 * 
 */
package com.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.controller.IFormuleController;
import com.dto.ResponseDto;
import com.entity.Formule;
import com.service.IFormuleService;

/**
 * Classe controller de Formule implémentant IFormuleController.
 * 
 * @author Maxime Rembert
 *
 */
@RestController
@RequestMapping(path = "/formule")
@CrossOrigin(allowCredentials = "true", origins = "http://localhost:4200")
public class FormuleControllerImpl extends DaoControllerImpl<Formule>  implements IFormuleController {
	
	@Autowired
	private IFormuleService serv;

	@Override
	public ResponseDto<Formule> findBySpecialite(String specialite) {
		return makeDtoResponse(serv.findBySpecialite(specialite));
	}


}
