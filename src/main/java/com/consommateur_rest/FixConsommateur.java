package com.consommateur_rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.dto.MedecinDto;
import com.dto.ResponseDto;
import com.exception.notfound.MedecinDtoNotFoundException;

/**
 * 
 * Classe qui Injecte tous les consommateurs du projet pour éviter des bugs dans le lancement de service GestionRdv.
 * 
 * @author Pauline Humbert
 *
 */
@Component
public class FixConsommateur {
	
	// ATTRIBUTS
	
	@Autowired 
	IMedecinConsommateur medecinConsommateur;
	
	// METHODES 
	
	/** 
	 * Méthdoe permettant la recherche d'un medecin par l'id de médecin à partir du consommateur Medecin.
	 *  
	 * @param id Long
	 * @return ResponseDto<MedecinDto>
	 * @throws MedecinDtoNotFoundException
	 */
	public ResponseDto<MedecinDto> findMedecinById(Long id) throws MedecinDtoNotFoundException {
		return medecinConsommateur.findMedecinById(id);
	}
	
	// METHODE POUR FAIRE DES TESTS PAS UTILISER DANS LES SERVICES
	public ResponseDto<List<MedecinDto>> findAll() {
		return medecinConsommateur.findAll();
	}

}
