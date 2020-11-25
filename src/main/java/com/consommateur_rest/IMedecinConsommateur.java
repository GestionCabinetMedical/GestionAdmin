package com.consommateur_rest;

import java.util.List;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.dto.MedecinDto;
import com.dto.ResponseDto;
import com.exception.notfound.MedecinDtoNotFoundException;

/**
 * 
 * Interface consommateur de Medecin du micro service GestionRdv.
 * 
 * @author Maxime Rembert
 *
 */
@FeignClient(name = "gestion-rdv", contextId="medecinConso")
@RibbonClient(name = "gestion-rdv")
public interface IMedecinConsommateur {
	
	@GetMapping(value="/medecin/{id}")
	ResponseDto<MedecinDto> findMedecinById(@PathVariable("id") Long id) throws MedecinDtoNotFoundException;
	
	
	// METHODE POUR FAIRE DES TESTS PAS UTILISER DANS LES SERVICES
	@GetMapping(value="/medecin/all")
	ResponseDto<List<MedecinDto>> findAll();

}
