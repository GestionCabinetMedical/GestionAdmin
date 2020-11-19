/**
 * 
 */
package com.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.GainsAppli;
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
	
	@Autowired
	private IGainsAppliRepo repo;

}
