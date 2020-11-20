/**
 * 
 */
package com.controller.impl;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.controller.IQuestionnaireSatisfactionController;
import com.entity.QuestionnaireSatisfaction;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Pauline Humbert
 * 
 * Classe controller de QuestionnaireSatisfaction implémente des méthodes spéciales à cette entité. 
 * Elle étend de {@code DaoControllerImpl}.
 * @see DaoControllerImpl
 *
 */
@RestController
@RequestMapping(path="/questionnaireSatisfaction")
@Slf4j
public class QuestionnaireSatisfactionControllerImpl extends DaoControllerImpl<QuestionnaireSatisfaction> implements IQuestionnaireSatisfactionController{

}
