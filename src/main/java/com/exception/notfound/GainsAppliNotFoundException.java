/**
 * 
 */
package com.exception.notfound;

import javassist.NotFoundException;

/**
 * @author Pauline Humbert
 * 
 * Classe exception de GainsAppli s'il n'est pas trouvé. Il étend de NotFoundException
 *
 */
public class GainsAppliNotFoundException extends NotFoundException{

	/**
	 * Constructeur de l'exception avec le message indiqué au niveau de l'appel à l'exception dans le service
	 * @param msg
	 */
	public GainsAppliNotFoundException(String msg) {
		super(msg);
		// TODO Auto-generated constructor stub
	}

}
