/**
 * 
 */
package com.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Maxime Rembert
 *
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class QuestionReponse implements Serializable{
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column (name="ID_QUESTION")
	private Long idQuestion;
	@Column (name="QUESTION",nullable = false)
	private String question;
	@Column (name="REPONSE",nullable = false)
	private String reponse;
	

}
