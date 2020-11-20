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
 * @see Serializable
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
	@Column(name="ID_FORMULE", unique = true, nullable = false)
	private Long id;
	@Column(name="TAXE", unique = false, nullable = false)
	private float taxe;
	@Column(name="PRIX_CONSULTATION", unique = false, nullable = false)
	private float prixConsultation;
	@Column(name="FRAIS_SERVICE", unique = false, nullable = false)
	private float fraisService;
	@Column(name="PRIXTTC", unique = false, nullable = false)
	private float prixTtc;
	@Column(name="SPECIALITE", unique = false, nullable = false)
	private String specialite;
}
