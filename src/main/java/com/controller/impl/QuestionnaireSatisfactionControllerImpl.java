package com.controller.impl;

import java.util.List;

import org.apache.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.controller.IQuestionnaireSatisfactionController;
import com.dto.ResponseDto;
import com.entity.QuestionnaireSatisfaction;
import com.exception.notdelete.DaoNotDeleteException;
import com.exception.notfound.DaoNotFoundException;
import com.exception.notmodify.DaoNotModifyException;
import com.service.IQuestionnaireSatisfactionService;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Pauline Humbert, Maxime Rembert
 * 
 * Classe controller {@code QuestionnaireSatisfactionControllerImpl} spécifique de {@link QuestionnaireSatisfactionControllerImpl}.
 * Elle étend de {@code DaoControllerImpl}.
 * @see DaoControllerImpl
 *
 */
@RestController
@RequestMapping(path="/questionnaireSatisfaction")
@Slf4j
@CrossOrigin(allowCredentials = "true", origins = "http://localhost:4200")
public class QuestionnaireSatisfactionControllerImpl  implements IQuestionnaireSatisfactionController {
	
	@Autowired
	private IQuestionnaireSatisfactionService serv;
	
	
	@Override
	@PostMapping
	public ResponseDto<QuestionnaireSatisfaction> add(@RequestBody QuestionnaireSatisfaction entite) throws DaoNotModifyException {
		log.info("Controller questionnaire satisfaction : méthode add appelée !");
		QuestionnaireSatisfaction e = serv.addOrUpdate(entite);
		return makeDtoResponse(e);
	}

	@Override
	@PutMapping
	public ResponseDto<QuestionnaireSatisfaction> update(@RequestBody QuestionnaireSatisfaction entite)
			throws DaoNotModifyException {
		log.info("Controller questionnaire satisfaction : méthode update appelée !");
		QuestionnaireSatisfaction e = serv.addOrUpdate(entite);
		return makeDtoResponse(e);
	}

	@Override
	@DeleteMapping (path="/{id}")
	public ResponseDto<Boolean> deleteById(@PathVariable Long id) throws DaoNotDeleteException {
		log.info("Controller questionnaire satisfaction : méthode delete By Id appelée !");
		Boolean status = serv.deleteById(id);
		return makeBooleanResponse(status);
	}

	@Override
	@GetMapping (path="/{id}")
	public ResponseDto<QuestionnaireSatisfaction> findById(@PathVariable Long id) throws DaoNotFoundException {
		log.info("Controller questionnaire satisfaction : méthode find By Id appelée !");
		QuestionnaireSatisfaction e = serv.findById(id);
		return makeDtoResponse(e);
	}

	@Override
	@GetMapping (path="/all")
	public ResponseDto<List<QuestionnaireSatisfaction>> findAll() throws DaoNotFoundException {
		log.info("Controller questionnaire satisfaction : méthode find all appelée !");
		List<QuestionnaireSatisfaction> listeEntity = serv.findAll();
		return makeListResponse(listeEntity);
	}
	
	@GetMapping (path="/allToFill")
	public ResponseDto<List<QuestionnaireSatisfaction>> findAllToFill()throws DaoNotFoundException {
		log.info("Controller questionnaire satisfaction : méthode find all to fill appelée !");
		return makeListResponse(serv.findAllARemplir());
	}
	
	@GetMapping (path="/allComplete")
	public ResponseDto<List<QuestionnaireSatisfaction>> findAllComplete()throws DaoNotFoundException {
		log.info("Controller questionnaire satisfaction : méthode find all complete appelée !");
		return makeListResponse(serv.findAllComplete());
	}
	
	public ResponseDto<QuestionnaireSatisfaction> makeDtoResponse(QuestionnaireSatisfaction e) {
		ResponseDto<QuestionnaireSatisfaction> resp = new ResponseDto<>();
		if (e != null) {
			log.info("makeDtoResponse : responseDto Ok");
			resp.setBody(e);
			resp.setError(false);
			resp.setStatus(HttpStatus.SC_OK);
		} else {
			log.info("makeDtoResponse : responseDto Erreur");
			resp.setError(true);
			resp.setBody(null);
			resp.setStatus(HttpStatus.SC_BAD_REQUEST);
		}
		return resp;
	}

	public ResponseDto<Boolean> makeBooleanResponse(Boolean status) {
		ResponseDto<Boolean> resp = new ResponseDto<>();

		if (status) {
			log.info("makeDtoResponse : responseDto Ok");
			resp.setError(false);
			resp.setBody(null);
			resp.setStatus(HttpStatus.SC_OK);
		} else {
			log.info("makeDtoResponse : responseDto Erreur");
			resp.setError(true);
			resp.setBody(null);
			resp.setStatus(HttpStatus.SC_BAD_REQUEST);
		}
		return resp;
	}
	
	public ResponseDto<List<QuestionnaireSatisfaction>> makeListResponse(List<QuestionnaireSatisfaction> liste) {
		ResponseDto<List<QuestionnaireSatisfaction>> resp = new ResponseDto<>();
		
		if (liste != null) {
			log.info("makeDtoResponse : responseDto Ok");
			resp.setError(false);
			resp.setBody(liste);
			resp.setStatus(HttpStatus.SC_OK);
		} else {
			log.info("makeDtoResponse : responseDto Erreur");
			resp.setError(true);
			resp.setBody(null);
			resp.setStatus(HttpStatus.SC_BAD_REQUEST);
		}
		return resp;
	}
	
	


}
