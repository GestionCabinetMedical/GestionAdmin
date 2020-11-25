/**
 * 
 */
package com.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Pauline Humbert
 * 
 * Classe entité de {@code QuestionnaireSatisfaction} qui implémente {@code Serializable}.
 * @see Serializable
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class QuestionnaireSatisfaction implements Serializable{
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="ID_QUESTIONNAIRE")
	private Long idQuestionnaire;
	@Column(name="ID_PATIENT",nullable = true)
	private Long idPatient;
	@Column(name="ID_CONSULTATION",nullable = true)
	private Long idConsultation;
	@Column (name = "NOM_QUESTIONNAIRE", unique = true, nullable = false)
	private String nomQuestionnaire;
	@OneToMany (cascade = CascadeType.ALL)
	@JoinColumn (name="FK_QUESTIONNAIRE", referencedColumnName = "ID_QUESTIONNAIRE", nullable = false)
	private List<QuestionReponse> listeQuestions;
}
