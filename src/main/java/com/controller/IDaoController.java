package com.controller;

import java.util.List;

import org.springframework.data.repository.NoRepositoryBean;

import com.dto.ResponseDto;
import com.exception.notdelete.DaoNotDeleteException;
import com.exception.notfound.DaoNotFoundException;
import com.exception.notmodify.DaoNotModifyException;

/**
 * Interface controller générique responsable des méthodes communes à tout le projet.
 * 
 * @author Maxime Rembert
 *
 */
@NoRepositoryBean
public interface IDaoController<E> {
	
	/**
	 * Méthode permettant d'ajouter une entité E à la base de donnée.
	 * 
	 * @param entite Entité à sauvegarder.
	 * @return L'entité sauvegardé (peut être null)
	 * @throws DaoNotModifyException 
	 */
	public ResponseDto<E> add(E entite) throws DaoNotModifyException;

	/**
	 * Méthode permettant de modifier une entité dans la base de donnée.
	 * 
	 * @param entite Entité à modifier.
	 * @return L'entité modifié (peut être null).
	 * @throws DaoNotModifyException 
	 */
	public ResponseDto<E> update(E entite) throws DaoNotModifyException;

	/**
	 * Méthode permettant de supprimer une entité dans la base de donnée.
	 * 
	 * @param id Id de l'entité à supprimer.
	 * @return True si la suppression à été effectuer, false sinon.
	 * @throws DaoNotDeleteException 
	 */
	public ResponseDto<Boolean> deleteById(Long id) throws DaoNotDeleteException;

	/**
	 * Méthode permettant de recherche une entité E dans la base de donnée.
	 * 
	 * @param id Id de l'entité à rechercher.
	 * @return L'entité rehcerché (peut être null).
	 * @throws DaoNotFoundException 
	 */
	public ResponseDto<E> findById(Long id) throws DaoNotFoundException;

	/**
	 * Méthode permettant la recherche de toutes les entités.
	 * 
	 * @return Une liste d'entité (peut être vide).
	 * @throws DaoNotFoundException 
	 */
	public ResponseDto<List<E>> findAll() throws DaoNotFoundException;
}
