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
 * Classe entité de {@code Formule} qui implémente {@code Serializable}.
 * 
 * @see Serializable
 * @author Maxime Rembert
 *
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Formule implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "TAXE", nullable = false)
	private float taxe;
	@Column(name = "PRIX_CONSULTATION", nullable = false)
	private float prixConsultation;
	@Column(name = "FRAIS_SERVICE", nullable = false)
	private float fraisService;
	@Column(name = "PRIXTTC", nullable = false)
	private float prixTtc;
	@Column(name = "SPECIALITE", nullable = false)
	private String specialite;
}
