/**
 * 
 */
package com.controller.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.controller.IGainsMedecinController;
import com.dto.ResponseDto;
import com.entity.GainsMedecin;
import com.service.IGainsMedecinService;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Pauline Humbert
 * 
 * Classe controller de GainsMedecin implémente des méthodes spéciales à cette entité. 
 * Elle étend DaoControllerImpl et implémente les méthodes de IGainsMedecinController.
 *
 */
@RestController
@RequestMapping(path="/gainsMedecin")
@Slf4j
public class GainsMedecinControllerImpl extends DaoControllerImpl<GainsMedecin> implements IGainsMedecinController{
	
	@Autowired
	private IGainsMedecinService gainsMedecinService;
	
	@Override	
	@GetMapping (path="/date")
	//TODO à compléter
	public ResponseDto<GainsMedecin> findByDateAndIdMedecin(Date date, Long idMedecin) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	//TODO à compléter
	public ResponseDto<GainsMedecin> calculGainsMedecin(Long idMedecin) {
		// TODO Auto-generated method stub
		return null;
	}

}
