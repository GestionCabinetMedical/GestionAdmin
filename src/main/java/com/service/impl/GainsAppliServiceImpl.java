package com.service.impl;

import java.util.Calendar;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.Formule;
import com.entity.GainsAppli;
import com.exception.notfound.FormuleNotFoundException;
import com.exception.notfound.GainsAppliNotFoundException;
import com.exception.notsuccess.GainsAppliNotSuccessException;
import com.repo.IFormuleRepo;
import com.repo.IGainsAppliRepo;
import com.service.IGainsAppliService;

import lombok.extern.slf4j.Slf4j;

/**
 * Classe service {@code GainsAppliServiceImpl} spécifique de {@link GainsAppli}
 * qui étend de {@code DaoServiceImpl} et implémente les méthodes de {code IGainsAppliService}.
 * @see DaoServiceImpl
 * @see IGainsAppliService
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
	public GainsAppli findByDate(Date date) throws GainsAppliNotFoundException{
		try {
			log.info("Classe gains appli service : méthode find by date appelée");
			if (date != null) {
				log.info("Appel repo OK !");
				return repo.findByDate(date);
			}
			else {
				log.warn("Erreur find by date : date null");
				throw new GainsAppliNotFoundException("GainsAppli pas trouvé date = null");
			}
		} catch (GainsAppliNotFoundException ganfe) {
			ganfe.printStackTrace();
			ganfe.getMessage();
		}
		return null;
	}

	@Override
	public GainsAppli calculGainsBySpecialite(String specialite) throws FormuleNotFoundException, GainsAppliNotFoundException, GainsAppliNotSuccessException{
		log.info("Classe gains appli service : méthode calcul gains by date appelée");
		Date date = Calendar.getInstance().getTime();
		try {
			if ( specialite != null) {
				log.info("Calcul du gains pour la date de "+date+" et la spécialité de "+ specialite+ " OK !");
				//recup formule par specialite communiqué
				Formule formule = repoFormule.findBySpecialite(specialite);
				//recup du gain par date
				GainsAppli gain = repo.findByDate(date);
				if (gain == null) {
					throw new GainsAppliNotFoundException("GainsAppli pas trouvé (=null)");
				}
				//ajout des frais services au gain
				float newGain = gain.getGain()+formule.getFraisService();
				gain.setGain(newGain);
				if (gain.getGain() !=  newGain) {
					log.warn("Erreur calculGainsBySpecialite : gains de GainsAppli pas modifié");
					throw new GainsAppliNotSuccessException("GainsAppli n'a pas modifié le nouveau attribut gains");
				}
				//sauvegarde du gain
				repo.save(gain);
				//retour du nouveau gain
				return gain;
			}
			else {
				log.warn("Erreur calcul gains by specialite : specialite null");
				throw new FormuleNotFoundException("Formule pas trouvé specialite=null");
			}
		} catch (FormuleNotFoundException | GainsAppliNotFoundException nfe) {
			nfe.printStackTrace();
			nfe.getMessage();
		} catch (GainsAppliNotSuccessException ganse) {
			// TODO Auto-generated catch block
			ganse.printStackTrace();
			ganse.getMessage();
		}
		return null;
	}
	
	

}
