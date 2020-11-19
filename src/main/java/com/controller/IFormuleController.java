/**
 * 
 */
package com.controller;

import com.dto.ResponseDto;
import com.entity.Formule;

/**
 * Interface controller de formule responsables des méthodes spéciales à cette
 * entité. Elle étend IDaoController.
 * 
 * @author Maxime Rembert
 *
 */
public interface IFormuleController extends IDaoController<Formule> {
	
	public ResponseDto<Formule> findBySpecialite(String specialite);
	
	

}
