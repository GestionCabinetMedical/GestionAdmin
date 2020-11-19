package com.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.GainsMedecin;
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

	@Override
	public GainsMedecin findByDateAndIdMedecin(Date date, Long idMedecin) {
		// TODO Auto-generated method stub
		//TODO : a compléter
		return null;
	}

	@Override
	public void calculGainsMedecin(Long idMedecin) {
		// TODO Auto-generated method stub
		//TODO : a compléter
		
	}

}
