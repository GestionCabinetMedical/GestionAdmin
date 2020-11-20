/**
 * 
 */
package com.exception.notfound;

import javassist.NotFoundException;

/**
 * @author Pauline Humbert
 * 
 * Classe exception de MedecinDto s'il n'est pas trouvée. Elle étend de {@code NotFoundException}
 * @see NotFoundException
 *
 */
public class MedecinDtoNotFoundException extends NotFoundException{

	/**
	 * Constructeur de l'exception avec le message indiqué au niveau de l'appel à l'exception dans le service
	 * @param msg
	 */
	public MedecinDtoNotFoundException(String msg) {
		super(msg);
		// TODO Auto-generated constructor stub
	}

}
