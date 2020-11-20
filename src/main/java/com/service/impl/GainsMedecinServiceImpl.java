package com.service.impl;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.consommateur_rest.IMedecinConsommateur;
import com.dto.MedecinDto;
import com.entity.Formule;
import com.entity.GainsMedecin;
import com.repo.IFormuleRepo;
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
	private IMedecinConsommateur medecinConsommateur;
	
	@Autowired 
	private IFormuleRepo formuleRepo;
	
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
		else if (date != null && idMedecin == null) {
			log.warn("Erreur findByDateAndIdMedecin : idMedecin=null");
		}
		log.warn("Erreur find by date and idMedecin: date et idMedecin = null");
		return null;
	}

	@Override
	public GainsMedecin calculGainsMedecin(Long idMedecin) {
		// TODO Auto-generated method stub
		log.info("Classe gains medecin service : méthode calcul gains by idMedecin");
		Date dateToday = new Date();
		if (dateToday != null && idMedecin != null) {
			GainsMedecin gainsMedecin = this.findByDateAndIdMedecin(dateToday, idMedecin);
			MedecinDto medecinDtoTofind = medecinConsommateur.findMedecinById(idMedecin);
			Formule formuleToFindPrixConsult = formuleRepo.findById(medecinDtoTofind.getIdFormule()).orElse(null);
			float newGain = gainsMedecin.getGains() + formuleToFindPrixConsult.getPrixConsultation();
			gainsMedecin.setGains(newGain);
			gainMedecinRepo.save(gainsMedecin);
			log.info("Calcul du gains Ok !");
			log.info("Le nouveau gain de la journée du medecin " + idMedecin + " est de " + gainsMedecin.getGains());
			return gainsMedecin;
		} 
		log.warn("Erreur calculGainsMedecin : idMedecin=null");
		return null;
	}

}
