package com.exception.notfound;

import javassist.NotFoundException;

/**
 * @author Pauline Humbert
 * 
 * Classe exception {@code DaoNotFoundException} si l'entité générique n'est pas trouvée. Elle étend de {@code NotFoundException}
 * @see NotFoundException
 *
 */
public class DaoNotFoundException extends NotFoundException {
	
	/**
	 * Constructeur de l'exception avec le message indiqué au niveau de l'appel à l'exception dans le service
	 * @param msg
	 */
	public DaoNotFoundException(String msg) {
		super(msg);
		// TODO Auto-generated constructor stub
	}

}
