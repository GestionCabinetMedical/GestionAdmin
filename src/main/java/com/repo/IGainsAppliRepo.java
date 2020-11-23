package com.repo;

import java.util.Date;

import org.springframework.stereotype.Repository;

import com.entity.GainsAppli;

/**
 * Interface repository {@code IGainsAppliRepo} spécifique de {@link GainsAppli}. 
 * Elle étend {@code IDaoRepo}.
 * @see IDaoRepo
 * 
 * @author Maxime Rembert
 *
 */
@Repository
public interface IGainsAppliRepo extends IDaoRepo<GainsAppli> {

	/**
	 * Méthdoe permettant la recherche de gain par date.
	 * 
	 * @param date Date du gains recherché.
	 * @return Une entité GainsAppli.
	 */
	public GainsAppli findByDate(Date date);

}
