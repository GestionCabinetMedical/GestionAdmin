package com.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * Classe {@code ResponseDto} permettant la communication avec le front.
 * 
 * @author Maxime Rembert
 *
 */

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"error", "body", "message", "status"})
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ResponseDto<E> implements Serializable{

	@JsonProperty("error")
	private boolean error;
//	@JsonProperty("body")
	private E body;
	@JsonProperty("message")
	private String message;
	@JsonProperty("status")
	private int status;
	@JsonProperty("error")
	public boolean isError() {
		return error;
	}
	

	@JsonProperty("error")
	public void setError(boolean error) {
		this.error = error;
	}

	@JsonProperty("body")
	public E getBody() {
		return body;
	}

	@JsonProperty("body")
	public void setBody(E body) {
		this.body = body;
	}

	@JsonProperty("message")
	public String getMessage() {
		return message;
	}

	@JsonProperty("message")
	public void setMessage(String message) {
		this.message = message;
	}

	@JsonProperty("status")
	public int getStatus() {
		return status;
	}

	@JsonProperty("status")
	public void setStatus(int status) {
		this.status = status;
	}
	
	
}
