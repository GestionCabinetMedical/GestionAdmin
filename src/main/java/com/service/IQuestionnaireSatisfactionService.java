/**
 * 
 */
package com.service;

import java.util.List;

import com.entity.QuestionnaireSatisfaction;
import com.exception.notfound.DaoNotFoundException;

/**
 * @author Pauline Humbert
 * 
 * Interface service {@code IQuestionnaireSatisfactionService} spécifique de {@link QuestionnaireSatisfaction}.
 * Elle étend de {@code IDaoService}
 * @see IDaoService
 *
 */
public interface IQuestionnaireSatisfactionService extends IDaoService<QuestionnaireSatisfaction>{
	
	public List<QuestionnaireSatisfaction> findAllARemplir()throws DaoNotFoundException;
	
	public List<QuestionnaireSatisfaction> findAllComplete()throws DaoNotFoundException;
	
}
