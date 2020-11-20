/**
 * 
 */
package com.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.Formule;
import com.repo.IFormuleRepo;
import com.service.IFormuleService;

import lombok.extern.slf4j.Slf4j;

/**
 * Classe service de formule étendant DaoServiceImpl et implémentant les
 * méthodes de IFormuleService.
 * 
 * @author Maxime Rembert
 *
 */
@Service
@Slf4j
public class FormuleServiceImpl extends DaoServiceImpl<Formule> implements IFormuleService {

	// ATTRIBUTS
	
	@Autowired
	private IFormuleRepo repo;

	// METHODES
	
	@Override
	public Formule findBySpecialite(String specialite) {
		log.info("Classe Formule service : Méthode findBySpecialite appelée");
		if (specialite != null) {
			log.info("Appel repo OK");
			return repo.findBySpecialite(specialite);
		}
		log.warn("Erreur methode find By Specialite : specialite null !");
		return null;
	}

}
