/**
 * 
 */
package com.service.impl;

import org.springframework.stereotype.Service;

import com.entity.QuestionnaireSatisfaction;
import com.service.IFormuleService;
import com.service.IQuestionnaireSatisfactionService;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Pauline Humbert
 * 
 * Classe service de QuestionnaireSatisfaction qui étend de {@code DaoServiceImpl} implémente {@code IQuestionnaireSatisfactionService}.
 * @see DaoServiceImpl
 * @see IQuestionnaireSatisfactionService
 *
 */
@Service
@Slf4j
public class QuestionnaireSatisfactionServiceImpl extends DaoServiceImpl<QuestionnaireSatisfaction> implements IQuestionnaireSatisfactionService{

}
