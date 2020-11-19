/**
 * 
 */
package com.controller.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.controller.IGainsAppliController;
import com.dto.ResponseDto;
import com.entity.GainsAppli;
import com.service.IGainsAppliService;

import lombok.extern.slf4j.Slf4j;

/**
 * Classe controller de GainsAppli responsables des méthodes spéciales à cette
 * entité. Elle étend DaoControllerImpl et implément les méthodes de
 * IGainsContronner.
 * 
 * @author Maxime Rembert
 *
 */
@RestController
@RequestMapping (path="/gainsApi")
@Slf4j
public class GainsAppliControllerImpl extends DaoControllerImpl<GainsAppli> implements IGainsAppliController {
	
	@Autowired
	private IGainsAppliService serv;

	@Override
	@GetMapping (path="/date")
	public ResponseDto<GainsAppli> findByDate(@RequestParam Date date) {
		log.info("Classe gains appli controller : méthdoe find by date appelée");
		return makeDtoResponse(serv.findByDate(date));
	}

	@Override
	public ResponseDto<GainsAppli> calculGainsByDate(Date date) {
		return makeDtoResponse(serv.calculGainsByDate(date));
	}

}
