/**
 * 
 */
package com.exception.notsuccess;

/**
 * @author Pauline Humbert
 * 
 * Classe exception de GainsMedecin si modification de l'entité n'est pas réalisée au sein d'une autre méthode du service.
 * Elle étend de {@code Throwable}
 * @see Throwable
 *
 */
public class GainsMedecinNotSuccessException extends Throwable{
	
	
	/**
	 * Constructeur de l'exception avec le message indiqué au niveau de l'appel à l'exception dans le service
	 * @param msg
	 */
	public GainsMedecinNotSuccessException(String msg) {
		super(msg);
	}

}
