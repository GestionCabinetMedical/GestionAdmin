package com.consommateur_rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.dto.MedecinDto;
import com.dto.ResponseDto;
import com.exception.notfound.MedecinDtoNotFoundException;

/**
 * @author Pauline Humbert
 *
 */
@Component
public class FixConsommateur {
	
	@Autowired 
	IMedecinConsommateur medecinConsommateur;
	
	public ResponseDto<MedecinDto> findMedecinById(Long id) throws MedecinDtoNotFoundException {
		return medecinConsommateur.findMedecinById(id);
	}
	
	// METHODE POUR FAIRE DES TESTS PAS UTILISER DANS LES SERVICES
	public ResponseDto<List<MedecinDto>> findAll() {
		return medecinConsommateur.findAll();
	}

}
