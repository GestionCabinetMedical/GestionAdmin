package com.service;

import java.util.List;

import org.springframework.data.repository.NoRepositoryBean;

import com.exception.notdelete.DaoNotDeleteException;
import com.exception.notfound.DaoNotFoundException;
import com.exception.notmodify.DaoNotModifyException;

/**
 * Interface service générique responsable des méthodes communes à tout le
 * projet.
 * 
 * @author Maxime Rembert
 *
 */
@NoRepositoryBean
public interface IDaoService<E> {
	
	/**
	 * Méthode permettant d'ajouter ou modifier une entite E dans la base de donnée.
	 * 
	 * @param entite Entite à ajouter ou modifier.
	 * @return L'entité correspondante (peut être null).
	 * @throws DaoNotModifyException 
	 */
	public E addOrUpdate(E entite) throws DaoNotModifyException;

	/**
	 * Méthode permettant de supprimer une entité de la base de donnée par son id.
	 * 
	 * @param id Id de l'entité à supprimer.
	 * @throws DaoNotDeleteException 
	 */
	public boolean deleteById(Long id) throws DaoNotDeleteException;

	/**
	 * Méthode permettant de trouver une entité par son id.
	 * @param id Id de l'entité à rechercher.
	 * @return L'entité recherché (peut être null).
	 * @throws DaoNotFoundException 
	 */
	public E findById(Long id) throws DaoNotFoundException;

	/**
	 * Méthode permettant de recherche la liste de toutes les entités.
	 * 
	 * @return Une liste d'entité (peut être vide).
	 * @throws DaoNotFoundException 
	 */
	public List<E> findAll() throws DaoNotFoundException;

}
