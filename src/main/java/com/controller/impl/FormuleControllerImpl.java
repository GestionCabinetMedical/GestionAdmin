/**
 * 
 */
package com.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.controller.IFormuleController;
import com.entity.Formule;
import com.service.IDaoService;

/**
 * Classe controller de Formule implémentant IFormuleController.
 * 
 * @author Maxime Rembert
 *
 */
@RestController
@RequestMapping(path = "/formule")
public class FormuleControllerImpl {
	
	@Autowired
	private IDaoService<Formule> serv;

}
