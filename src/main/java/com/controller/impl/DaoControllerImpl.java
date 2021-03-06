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

import com.controller.IDaoController;
import com.dto.ResponseDto;
import com.exception.notdelete.DaoNotDeleteException;
import com.exception.notfound.DaoNotFoundException;
import com.exception.notmodify.DaoNotModifyException;
import com.service.IDaoService;

import lombok.extern.slf4j.Slf4j;

/**
 * Classe controller générique implémentant {@code IDaoController}.
 * @see IDaoController
 * 
 * @author Maxime Rembert
 *
 */
@Slf4j
@RequestMapping
@CrossOrigin(allowCredentials = "true", origins = "http://localhost:4200")
public abstract class DaoControllerImpl<E> implements IDaoController<E>{
	
	// ATTRIBUTS 
	
	@Autowired
	private IDaoService<E> serv;

	// METHODES
	
	@Override
	@PostMapping
	public ResponseDto<E> add(@RequestBody E entite) throws DaoNotModifyException {
		log.info("Controller générique : méthode add appelée");
		E e = serv.addOrUpdate(entite);
		return makeDtoResponse(e);
	}

	@Override
	@PutMapping
	public ResponseDto<E> update(@RequestBody E entite) throws DaoNotModifyException {
		log.info("Controller générique : méthode update appelée");
		E e = serv.addOrUpdate(entite);
		return makeDtoResponse(e);
	}

	@Override
	@DeleteMapping(path = "/{id}")
	public ResponseDto<Boolean> deleteById(@PathVariable Long id) throws DaoNotDeleteException {
		log.info("Controller générique : méthode delete By Id appelée");
		boolean status = serv.deleteById(id);
		return makeBooleanResponse(status);
	}

	@Override
	@GetMapping(path = "/{id}")
	public ResponseDto<E> findById(@PathVariable Long id) throws DaoNotFoundException {
		log.info("Controller générique : méthode find By Id appelée");
		E e = serv.findById(id);
		return makeDtoResponse(e);
	}

	@Override
	@GetMapping(path = "/all")
	public ResponseDto<List<E>> findAll() throws DaoNotFoundException {
		log.info("Controller générique : méthode find all appelée");
		List<E> liste = serv.findAll();
		return makeListResponse(liste);
	}

	public ResponseDto<E> makeDtoResponse(E e) {
		ResponseDto<E> resp = new ResponseDto<>();
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
			log.info("makeBooleanResponse : ResponseDto<Boolean> Ok");
			resp.setError(false);
			resp.setBody(null);
			resp.setStatus(HttpStatus.SC_OK);
		} else {
			log.info("makeBooleanResponse : ResponseDto<Boolean> Erreur");
			resp.setError(true);
			resp.setBody(null);
			resp.setStatus(HttpStatus.SC_BAD_REQUEST);
		}
		return resp;

	}
	
	public ResponseDto<List<E>> makeListResponse(List<E> liste) {
		ResponseDto<List<E>> resp = new ResponseDto<>();
		
		if (liste != null) {
			log.info("makeListResponse : ResponseDto<List<E>> Ok");
			resp.setError(false);
			resp.setBody(liste);
			resp.setStatus(HttpStatus.SC_OK);
		} else {
			log.info("makeListResponse : ResponseDto<List<E>> Erreur");
			resp.setError(true);
			resp.setBody(null);
			resp.setStatus(HttpStatus.SC_BAD_REQUEST);
		}
		return resp;
	}

}
