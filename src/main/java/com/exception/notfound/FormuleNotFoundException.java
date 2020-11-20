/**
 * 
 */
package com.exception.notfound;

import javassist.NotFoundException;

/**
 * @author Pauline Humbert
 * 
 * Classe exception de Formule si elle n'est pas trouvé. Il étend de NotFoundException
 *
 */
public class FormuleNotFoundException extends NotFoundException{

	/**
	 * Constructeur de l'exception avec le message indiqué au niveau de l'appel à l'exception dans le service
	 * @param msg
	 */
	public FormuleNotFoundException(String msg) {
		super(msg);
		// TODO Auto-generated constructor stub
	}

}