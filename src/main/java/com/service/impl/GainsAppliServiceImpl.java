/**
 * 
 */
package com.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.GainsAppli;
import com.repo.IGainsAppliRepo;
import com.service.IGainsAppliService;

import lombok.extern.slf4j.Slf4j;

/**
 * Classe service de GainsAppli étendant DaoServiceImpl et implémenant les méthodes
 * de IGainsAppliService.
 * 
 * @author Maxime rembert
 *
 */
@Service
@Slf4j
public class GainsAppliServiceImpl extends DaoServiceImpl<GainsAppli> implements IGainsAppliService{
	
	@Autowired
	private IGainsAppliRepo repo;

	@Override
	public GainsAppli findByDate(Date date) {
		log.info("Classe gains appli service : méthode find by date appelée");
		if (date != null) {
			log.info("Appel repo OK !");
			return repo.findByDate(date);
		}
		log.warn("Erreur find by date : date null");
		return null;
	}

	@Override
	public GainsAppli calculGainsByDate(Date date) {
		//TODO : a compléter
		log.info("Classe gains appli service : méthode calcul gains by date appelée");
		if (date != null) {
			log.info("Calcul du gains Ok !");
			return null;
		}
		log.warn("Erreur calcul gains by date : date null");
		return null;
	}
	
	

}
