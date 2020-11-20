/**
 * 
 */
package com.controller;

import com.dto.ResponseDto;
import com.entity.Formule;
import com.exception.notfound.FormuleNotFoundException;

/**
 * Interface controller de formule responsables des méthodes spéciales à cette
 * entité.
 * 
 * @author Maxime Rembert
 *
 */
public interface IFormuleController {
	
	public ResponseDto<Formule> findBySpecialite(String specialite) throws FormuleNotFoundException;
	
	

}
