package com.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.consommateur_rest.IMedecinConsommateur;
import com.entity.GainsMedecin;
import com.repo.IGainsMedecinRepo;
import com.service.IGainsMedecinService;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Pauline Humbert
 *
 * Classe service de GainsMédecin qui étend de DaoServiceImpl implémente IGainsMedecinService.
 *
 */
@Service
@Slf4j
public class GainsMedecinServiceImpl extends DaoServiceImpl<GainsMedecin> implements IGainsMedecinService{
	
	@Autowired
	private IGainsMedecinRepo gainMedecinRepo;

	@Autowired
	IMedecinConsommateur medecinConsommateur;
	
	@Override
	public GainsMedecin findByDateAndIdMedecin(Date date, Long idMedecin) {
		// TODO Auto-generated method stub
		log.info("Classe gains medecin service : méthode find by date and idMedecin appelée");
		if (date != null && idMedecin != null) {
			log.info("Appel repo OK !");
			return gainMedecinRepo.findByDateAndIdMedecin(date, idMedecin);
		}
		else if (date == null && idMedecin != null) {
			log.warn("Erreur findByDateAndIdMedecin : date=null");
		}
		else if (date == null && idMedecin != null) {
			log.warn("Erreur findByDateAndIdMedecin : idMedecin=null");
		}
		log.warn("Erreur find by date and idMedecin: date et idMedecin = null");
		return null;
	}

	@Override
	public void calculGainsMedecin(Long idMedecin) {
		// TODO Auto-generated method stub
		log.info("Classe gains medecin service : méthode calcul gains by idMedecin");
		Date dateToday = new Date();
		if (dateToday != null && idMedecin != null) {
			GainsMedecin gainsMedecin = this.findByDateAndIdMedecin(dateToday, idMedecin);
			log.info("Calcul du gains Ok !");
		}
		log.warn("Erreur calcul gains by date : date null");		
	}

}
