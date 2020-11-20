package com.exception.notdelete;

/**
 * @author Pauline Humbert
 * 
 * Classe exception de Dao si l'ajout et la modification de l'entité générique n'est pas réalisée au sein du service générique.
 * Elle étend de {@code Throwable}
 * @see Throwable
 *
 */
public class DaoNotDeleteException extends Throwable{
	
	/**
	 * Constructeur de l'exception avec le message indiqué au niveau de l'appel à l'exception dans le service
	 * @param msg
	 */
	public DaoNotDeleteException(String msg) {
		super(msg);
	}

}
