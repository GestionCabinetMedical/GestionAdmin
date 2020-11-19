package com.entity;

import java.util.Date;

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
 * Classe de l'entité GainsMedecin pour les gains des médecins
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class GainsMedecin {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="ID_GAINS_MEDECIN", unique = true, nullable = false)
	private Long idGainsMedecin;
	@Column(name="GAINS", unique = false, nullable = true)
	private float gains;
	@Column(name="DATE", unique = true, nullable = false)
	private Date date;
	@Column(name="ID_MEDECIN", unique = true, nullable = true)
	private Long idMedecin;

}
