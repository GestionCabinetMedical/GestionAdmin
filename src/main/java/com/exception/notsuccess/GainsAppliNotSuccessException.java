/**
 * 
 */
package com.exception.notsuccess;

/**
 * @author Pauline Humbert
 * 
 * Classe exception de GainsAppli si modification de l'entité n'est pas réalisée au sein d'une autre méthode du service.
 * Elle étend de Throwable
 *
 */
public class GainsAppliNotSuccessException extends Throwable{
	
	/**
	 * Constructeur de l'exception avec le message indiqué au niveau de l'appel à l'exception dans le service
	 * @param msg
	 */
	public GainsAppliNotSuccessException(String msg) {
		super(msg);
	}

}
