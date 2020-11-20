package com.entity;

import java.io.Serializable;
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
 * Classe de l'entité GainsAppli
 * @see Serializable
 * @author Maxime Rembert
 *
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class GainsAppli implements Serializable {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="ID_GAINS_APPLI", unique = true, nullable = false)
	private Long id;
	@Column(name="GAIN", unique = false, nullable = false)
	private float gain;
	@Column(name="DATE", unique = true, nullable = false)
	private Date date;

}
