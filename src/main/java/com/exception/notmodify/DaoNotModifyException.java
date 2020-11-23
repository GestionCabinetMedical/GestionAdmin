package com.exception.notmodify;

/**
 * @author Pauline Humbert
 * 
 * Classe exception {@code DaoNotModifyException} si l'ajout et la modification de l'entité générique n'est pas réalisée au sein du service générique .
 * Elle étend de {@code Throwable}
 * @see Throwable
 *
 */
public class DaoNotModifyException extends Throwable{
	
	/**
	 * Constructeur de l'exception avec le message indiqué au niveau de l'appel à l'exception dans le service
	 * @param msg
	 */
	public DaoNotModifyException(String msg) {
		super(msg);
	}

}
