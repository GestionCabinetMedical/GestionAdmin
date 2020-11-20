/**
 * 
 */
package com.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.Formule;
import com.exception.notfound.FormuleNotFoundException;
import com.repo.IFormuleRepo;
import com.service.IDaoService;
import com.service.IFormuleService;

import lombok.extern.slf4j.Slf4j;

/**
 * Classe service de formule étendant {@code DaoServiceImpl} et implémentant les
 * méthodes de {@code IFormuleService}.
 * @see DaoServiceImpl
 * @see IFormuleService
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
	public Formule findBySpecialite(String specialite) throws FormuleNotFoundException{
		try {
			log.info("Classe Formule service : Méthode findBySpecialite appelée");
			if (specialite != null) {
				log.info("Appel repo OK");
				return repo.findBySpecialite(specialite);
			}
			else {
				log.warn("Erreur methode find By Specialite : specialite null !");
				throw new FormuleNotFoundException("Formule pas trouvé specialite=null");
			}
		} catch (FormuleNotFoundException fnfe) {
			fnfe.printStackTrace();
			fnfe.getMessage();
		}
		return null;
	}

}
