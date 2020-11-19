/**
 * 
 */
package com.consommateur_rest;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;

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

}
