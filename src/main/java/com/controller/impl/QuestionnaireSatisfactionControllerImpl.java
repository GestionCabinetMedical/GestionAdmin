package com.controller.impl;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.entity.QuestionnaireSatisfaction;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Pauline Humbert
 * 
 * Classe controller {@code QuestionnaireSatisfactionControllerImpl} spécifique de {@link QuestionnaireSatisfactionControllerImpl}.
 * Elle étend de {@code DaoControllerImpl}.
 * @see DaoControllerImpl
 *
 */
@RestController
@RequestMapping(path="/questionnaireSatisfaction")
@Slf4j
public class QuestionnaireSatisfactionControllerImpl extends DaoControllerImpl<QuestionnaireSatisfaction> {

}
