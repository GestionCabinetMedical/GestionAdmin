/**
 * 
 */
package com.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.QuestionReponse;
import com.entity.QuestionnaireSatisfaction;
import com.exception.notdelete.DaoNotDeleteException;
import com.exception.notfound.DaoNotFoundException;
import com.exception.notmodify.DaoNotModifyException;
import com.repo.IQuestionReponseRepo;
import com.repo.IQuestionnaireSatisfactionRepo;
import com.service.IQuestionnaireSatisfactionService;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Pauline Humbert, Maxime Rembert
 * 
 *         Classe service {@code QuestionnaireSatisfactionServiceImpl}
 *         spécifique de {@link QuestionnaireSatisfaction} qui étend de
 *         {@code DaoServiceImpl} et implémente
 *         {@code IQuestionnaireSatisfactionService}.
 * @see DaoServiceImpl
 * @see IQuestionnaireSatisfactionService
 *
 */
@Service
@Slf4j
public class QuestionnaireSatisfactionServiceImpl implements IQuestionnaireSatisfactionService {

	@Autowired
	private IQuestionnaireSatisfactionRepo repo;

	@Autowired
	private IQuestionReponseRepo itemRepo;
	
	@Override
	public QuestionnaireSatisfaction addOrUpdate(QuestionnaireSatisfaction entite) throws DaoNotModifyException {

		try {
			log.info("Questionnaire service : méthode add or update appelée");
			if (entite != null) {
				log.info("Questionnaire non null, appel repo methode save OK !");
				// sauvegarde du questionnaire
				repo.save(entite);
				// sauvegarde de l'ensemble des questions
				for (QuestionReponse e : entite.getListeQuestions()) {
					System.out.println("**************************************");
					System.out.println(e.getIdQuestion());
					System.out.println("**************************************");
					itemRepo.save(e);
				}
				return entite;
			}
			log.warn("Erreur méthode add or update: entite null");
			throw new DaoNotModifyException("AddOrUpdate n'a pas pu modifier la BD: entité = null");
		} catch (DaoNotModifyException dnmf) {
			dnmf.printStackTrace();
			dnmf.getMessage();
		}
		return null;
	}

	@Override
	public boolean deleteById(Long id) throws DaoNotDeleteException {
		log.info("Questionnaire service : méthdoe delete by id appelée");
		try {
			if (id != null && repo.existsById(id)) {
				log.info("Id non null et existant dans la base de donnée");
				QuestionnaireSatisfaction entite = repo.findById(id).orElse(null);
				repo.deleteById(id);
				for (QuestionReponse e : entite.getListeQuestions()) {
					itemRepo.deleteById(e.getIdQuestion());
				}
				return true;
			}
			
			log.warn("Erreur méthode delete By id: id null");
			throw new DaoNotDeleteException("DeleteById n'a pas pu delete l'élément dans la BD: id = null");
			
		} catch (DaoNotDeleteException dnde) {
			dnde.printStackTrace();
			dnde.getMessage();
		}
		return false;
	}

	@Override
	public QuestionnaireSatisfaction findById(Long id) throws DaoNotFoundException {
		try {
			log.info("Questionnaire service : méthode find By Id appelée ");
			if (id != null) {
				log.info("Appel repo OK");
				return repo.findById(id).orElse(null);
			}
			else {
				log.warn("Erreur méthode find By id: id null");
				throw new DaoNotFoundException("FindById n'a pas pu find l'élément dans la BD: id = null");
			}
		} catch (DaoNotFoundException dnfe ) {
			dnfe.printStackTrace();
			dnfe.getMessage();
		}
		return null;
	}

	@Override
	public List<QuestionnaireSatisfaction> findAll() throws DaoNotFoundException {
		try {
			if (repo.findAll() != null) {
				log.info("Questionnaire service : méthode find All appelée ");
				log.info("Appel repo OK");
				return repo.findAll();
			}
			else {
				throw new DaoNotFoundException("FindAll n'a pas pu find tous les éléments dans la BD");
			}
		} catch (DaoNotFoundException dnfe) {
			dnfe.printStackTrace();
			dnfe.getMessage();
		}
		return null;
	}

}
