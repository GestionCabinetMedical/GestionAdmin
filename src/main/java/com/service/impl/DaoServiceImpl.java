/**
 * 
 */
package com.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.exception.notdelete.DaoNotDeleteException;
import com.exception.notfound.DaoNotFoundException;
import com.exception.notmodify.DaoNotModifyException;
import com.repo.IDaoRepo;
import com.service.IDaoService;

import lombok.extern.slf4j.Slf4j;

/**
 * Classe service générique implémentant IDaoService.
 * 
 * @author Maxime Rembert
 *
 */
@Slf4j
public class DaoServiceImpl<E> implements IDaoService<E>{
	
	//ATTRIBUTS
	
	@Autowired
	private IDaoRepo<E> repo;

	
	//METHODES
	
	@Override
	public E addOrUpdate(E entite) throws DaoNotModifyException {
		try {
			log.info("Servcie générique : méthode add Or Update appelée ");
			if (entite != null) {
				log.info("Appel repo OK");
				return repo.save(entite);
			}
			else {
				log.warn("Erreur méthode add or update: entite null");
				throw new DaoNotModifyException("AddOrUpdate n'a pas pu modifier la BD: entité = null");
			}
		} catch (DaoNotModifyException dnmf) {
			dnmf.printStackTrace();
			dnmf.getMessage();
		}
		return null;
	}

	@Override
	public boolean deleteById(Long id) throws DaoNotDeleteException{
		try {
			log.info("Servcie générique : méthode delete By Id appelée ");
			if (id != null) {
				log.info("Appel repo OK");
				repo.deleteById(id);
				return true;
			}
			else {
				log.warn("Erreur méthode delete By id: id null");
				throw new DaoNotDeleteException("DeleteById n'a pas pu delete l'élément dans la BD: id = null");
			}
		} catch (DaoNotDeleteException dnde) {
			dnde.printStackTrace();
			dnde.getMessage();
			
		}
		return false;
	}

	@Override
	public E findById(Long id) throws DaoNotFoundException {
		try {
			log.info("Servcie générique : méthode find By Id appelée ");
			if (id != null) {
				log.info("Appel repo OK");
				return repo.findById(id).orElse(null);
			}
			else {
				log.warn("Erreur méthode find By id: id null");
				throw new DaoNotFoundException("FindById n'a pas pu find l'élément dans la BD: id = null");
			}
		} catch (DaoNotFoundException dnfe ) {
			dnfe.printStackTrace();
			dnfe.getMessage();
		}
		return null;
	}

	@Override
	public List<E> findAll() throws DaoNotFoundException {
		try {
			if (repo.findAll() != null) {
				log.info("Servcie générique : méthode find All appelée ");
				log.info("Appel repo OK");
				return repo.findAll();
			}
			else {
				throw new DaoNotFoundException("FindAll n'a pas pu find tous les éléments dans la BD");
			}
		} catch (DaoNotFoundException dnfe) {
			dnfe.printStackTrace();
			dnfe.getMessage();
		}
		return null;
	}

}
