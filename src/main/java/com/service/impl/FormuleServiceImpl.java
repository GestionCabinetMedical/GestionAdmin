/**
 * 
 */
package com.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.Formule;
import com.repo.IDaoRepo;
import com.service.IFormuleService;

/**
 * Classe service de formule implémentant IFormuleService.
 * 
 * @author Maxime Rembert
 *
 */
@Service
public class FormuleServiceImpl {

	@Autowired
	private IDaoRepo<Formule> repo;

}
