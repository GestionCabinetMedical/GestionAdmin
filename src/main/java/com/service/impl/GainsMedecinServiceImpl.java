package com.service.impl;

import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.consommateur_rest.FixConsommateur;
import com.consommateur_rest.IMedecinConsommateur;
import com.dto.MedecinDto;
import com.entity.Formule;
import com.entity.GainsMedecin;
import com.exception.notfound.FormuleNotFoundException;
import com.exception.notfound.GainsMedecinNotFoundException;
import com.exception.notfound.MedecinDtoNotFoundException;
import com.exception.notsuccess.GainsMedecinNotSuccessException;
import com.repo.IFormuleRepo;
import com.repo.IGainsMedecinRepo;
import com.service.IGainsMedecinService;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Pauline Humbert
 *
 *         Classe service {@code GainsMedecinServiceImpl} spécifique de
 *         {@link GainsMedecin} qui étend de {@code DaoServiceImpl} et
 *         implémente {@code IGainsMedecinService}.
 * @see DaoServiceImpl
 * @see IGainsMedecinService
 *
 */
@Service
@Slf4j
public class GainsMedecinServiceImpl extends DaoServiceImpl<GainsMedecin> implements IGainsMedecinService {

	// ATTRIBUTS

	@Autowired
	private IGainsMedecinRepo gainMedecinRepo;

	@Autowired
	private FixConsommateur fixConsommateur;

	@Autowired
	private IFormuleRepo formuleRepo;

	// METHODES

	@Override
	public GainsMedecin findByDateAndIdMedecin(Date date, Long idMedecin) throws GainsMedecinNotFoundException {
		try {
			log.info("Classe gains medecin service : méthode find by date and idMedecin appelée");
			if (date != null && idMedecin != null) {
				log.info("Appel repo OK !");
				return gainMedecinRepo.findByDateAndIdMedecin(date, idMedecin);
			} else if (date == null && idMedecin != null) {
				log.warn("Erreur findByDateAndIdMedecin : date=null");
				throw new GainsMedecinNotFoundException("GainsMedecin pas trouvé date = null");
			} else if (date != null && idMedecin == null) {
				log.warn("Erreur findByDateAndIdMedecin : idMedecin=null");
				throw new GainsMedecinNotFoundException("GainsMedecin pas trouvé idMedecin = null");
			} else {
				log.warn("Erreur find by date and idMedecin: date et idMedecin = null");
				throw new GainsMedecinNotFoundException("GainsMedecin pas trouvé date et idMedecin = null");
			}
		} catch (GainsMedecinNotFoundException gmnfe) {
			gmnfe.printStackTrace();
			gmnfe.getMessage();
		}
		return null;

	}

	@Override
	public GainsMedecin calculGainsMedecin(Long idMedecin) throws GainsMedecinNotFoundException,
			MedecinDtoNotFoundException, FormuleNotFoundException, GainsMedecinNotSuccessException {
		log.info("Classe gains medecin service : méthode calcul gains by idMedecin");
		Date dateToday = new Date();
		try {
			if (idMedecin != null) {
				GainsMedecin gainsMedecin = this.findByDateAndIdMedecin(dateToday, idMedecin);
				MedecinDto medecinDtoTofind = fixConsommateur.findMedecinById(idMedecin).getBody();
				if (medecinDtoTofind == null) {
					log.warn("Erreur calculGainsMedecin : medecinDtoTofind=null");
					throw new MedecinDtoNotFoundException("MedecinDto pas trouvé (=null)");
				}
				Formule formuleToFindPrixConsult = formuleRepo.findById(medecinDtoTofind.getIdFormule()).orElse(null);
				if (formuleToFindPrixConsult == null) {
					log.warn("Erreur calculGainsMedecin : formuleToFindPrixConsult=null");
					throw new FormuleNotFoundException("Formule pas trouvé (=null)");
				}
				float newGain = gainsMedecin.getGains() + formuleToFindPrixConsult.getPrixConsultation();
				gainsMedecin.setGains(newGain);
				if (gainsMedecin.getGains() != newGain) {
					log.warn("Erreur calculGainsMedecin : gains de GainsMedecin pas modifié");
					throw new GainsMedecinNotSuccessException("GainsMedecin n'a pas modifié le nouveau attribut gains");
				}
				gainMedecinRepo.save(gainsMedecin);
				log.info("Calcul du gains Ok !");
				log.info(
						"Le nouveau gain de la journée du medecin " + idMedecin + " est de " + gainsMedecin.getGains());
				return gainsMedecin;

			} else {
				log.warn("Erreur calculGainsMedecin : idMedecin=null");
				throw new GainsMedecinNotFoundException("GainsMedecin pas trouvé idMedecin = null");
			}
		} catch (GainsMedecinNotFoundException | MedecinDtoNotFoundException | FormuleNotFoundException nfe) {
			nfe.printStackTrace();
			nfe.getMessage();
		} catch (GainsMedecinNotSuccessException gmnse) {
			gmnse.printStackTrace();
		}
		return null;
	}
	
	
	// METHODES POUR TESTER LA COMMUNICATION DIRECT ENTRE MICROSERVICES 

	@Override
	public void findMedecinById(Long id) throws MedecinDtoNotFoundException {
		System.out.println(fixConsommateur.findMedecinById(id));
		
	}

	@Override
	public void findAllMedecin() {
		System.out.println(fixConsommateur.findAll());
		
	}
	
	

}
