/**
 * 
 */
package com.consommateur_rest;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.dto.MedecinDto;
import com.exception.notfound.MedecinDtoNotFoundException;

/**
 * 
 * Interface consommateur de Medecin du micro service GestionRdv.
 * 
 * @author Maxime Rembert
 *
 */
@FeignClient(name = "gestion-rdv")
@RibbonClient(name = "gestion-rdv")
public interface IMedecinConsommateur {
	
	@GetMapping(value="/medecin/{id}")
	MedecinDto findMedecinById(@PathVariable("id") Long id) throws MedecinDtoNotFoundException;

}
