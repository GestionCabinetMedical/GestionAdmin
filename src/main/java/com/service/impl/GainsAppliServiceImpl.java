/**
 * 
 */
package com.service.impl;

import java.util.Calendar;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.Formule;
import com.entity.GainsAppli;
import com.repo.IFormuleRepo;
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
	
	// ATTRIBUTS 
	
	@Autowired
	private IGainsAppliRepo repo;
	
	@Autowired
	private IFormuleRepo repoFormule;

	// METHODES
	
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
	public GainsAppli calculGainsBySpecialite(String specialite) {
		log.info("Classe gains appli service : méthode calcul gains by date appelée");
		Date date = Calendar.getInstance().getTime();
		if ( specialite != null) {
			log.info("Calcul du gains pour la date de "+date+" et la spécialité de "+ specialite+ " OK !");
			//recup formule par specialite communiqué
			Formule formule = repoFormule.findBySpecialite(specialite);
			//recup du gain par date
			GainsAppli gain = repo.findByDate(date);
			//ajout des frais services au gain
			gain.setGain(gain.getGain()+formule.getFraisService());
			//sauvegarde du gain
			repo.save(gain);
			//retour du nouveau gain
			return gain;
		}
		log.warn("Erreur calcul gains by date : date null ou specialite null");
		return null;
	}
	
	

}
