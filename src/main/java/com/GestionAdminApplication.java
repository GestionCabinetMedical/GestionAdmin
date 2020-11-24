package com;

import java.sql.Date;
import java.util.stream.Stream;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import com.entity.GainsMedecin;
import com.exception.notmodify.DaoNotModifyException;
import com.service.impl.GainsMedecinServiceImpl;

/**
 * @author Pauline Humbert
 *
 * Classe GestionAdminApplication instancier des Objects et vérifier la bonne communication le back et la base de donnée
 *
 */
@EnableDiscoveryClient
@EnableFeignClients
@SpringBootApplication
public class GestionAdminApplication {

	public static void main(String[] args) {
		SpringApplication.run(GestionAdminApplication.class, args);
	}

	/**
	 * @param GainsMedecinServiceImpl gainsMedecinImpl
	 * @return affiche tous les éléments dans la bases de données concernant les gains Medecins après création des intances de gains medecins
	 */
//	@Bean
//	CommandLineRunner start(GainsMedecinServiceImpl gainsMedecinService)
//	{
//		return (args) -> {
//			
//			Stream.of(new GainsMedecin(1L, 400, Date.valueOf("2020-05-03"), 1L),
//					new GainsMedecin(2L, 1000, Date.valueOf("2020-05-04"), 2L))
//					.forEach((gains) -> {
//						try {
//							gainsMedecinService.addOrUpdate(gains);
//						} catch (DaoNotModifyException e) {
//							// TODO Auto-generated catch block
//							e.printStackTrace();
//						}
//					});
//			gainsMedecinService.findAll().forEach(System.out::println);
//		};
//	}
	
}
