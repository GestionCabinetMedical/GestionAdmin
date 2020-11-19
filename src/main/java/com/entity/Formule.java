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
 * Classe entité de Formule.
 * @author Maxime Rembert
 *
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Formule implements Serializable{
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long id;
	@Column
	private float taxe;
	@Column
	private float prixConsultation;
	@Column
	private float fraisService;
	@Column
	private float prixTtc;
	@Column
	private String specialite;
}
