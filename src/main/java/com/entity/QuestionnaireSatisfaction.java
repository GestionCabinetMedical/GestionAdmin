/**
 * 
 */
package com.entity;

import java.io.Serializable;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Pauline Humbert
 * 
 * Classe entité de Questionnaire de satisfaction
 * @see Serializable
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class QuestionnaireSatisfaction implements Serializable{
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="ID_QUESTIONNAIRE", unique = true, nullable = false)
	private Long idQuestionnaire;
	@Column(name="QUESTION_REPONSES", unique = false, nullable = false)
	private Map<String, String> questionsReponses;
	@Column(name="ID_PATIENT", unique = false, nullable = false)
	private Long idPatient;
	@Column(name="ID_CONSULTATION", unique = false, nullable = false)
	private Long idConsultation;
}
