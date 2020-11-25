package com.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author Pauline Humbert
 * 
 * Classe {@code MedecinDto} permettant de récupérer les informations de l'entité médecin
 * qui se trouve dans le microService {@code GestiondeRdv} 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"idMedecin", "nom", "prenom", "idFormule", "adresseCabinet", "specialite", "identifiant", "motDePasse"})
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class MedecinDto implements Serializable{

	@JsonProperty("idMedecin")
	private Long id;
	@JsonProperty("nom")
	private String nom;
	@JsonProperty("prenom")
	private String prenom;
	@JsonProperty("idFormule")
	private Long idFormule;
	@JsonProperty("adresseCabinet")
	private String adresseCabinet;
	@JsonProperty("specialite")
	private String specialite;
	@JsonProperty("identifiant")
	private String identifiant;
	@JsonProperty("motDePasse")
	private String motDePasse;

	@JsonProperty("idMedecin")
	public Long getId() {
		return id;
	}

	@JsonProperty("idMedecin")
	public void setId(Long id) {
		this.id = id;
	}

	@JsonProperty("nom")
	public String getNom() {
		return nom;
	}

	@JsonProperty("nom")
	public void setNom(String nom) {
		this.nom = nom;
	}

	@JsonProperty("prenom")
	public String getPrenom() {
		return prenom;
	}

	@JsonProperty("idMedecin")
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	@JsonProperty("idFormule")
	public Long getIdFormule() {
		return idFormule;
	}

	@JsonProperty("idFormule")
	public void setIdFormule(Long idFormule) {
		this.idFormule = idFormule;
	}

	@JsonProperty("adresseCabinet")
	public String getAdresseCabinet() {
		return adresseCabinet;
	}

	@JsonProperty("adresseCabinet")
	public void setAdresseCabinet(String adresseCabinet) {
		this.adresseCabinet = adresseCabinet;
	}

	@JsonProperty("specialite")
	public String getSpecialite() {
		return specialite;
	}

	@JsonProperty("specialite")
	public void setSpecialite(String specialite) {
		this.specialite = specialite;
	}
	
	@JsonProperty("identifiant")
	public String getIdentifiant() {
		return identifiant;
	}

	@JsonProperty("identifiant")
	public void setIdentifiant(String identifiant) {
		this.identifiant = identifiant;
	}

	@JsonProperty("motDePasse")
	public String getMotDePasse() {
		return motDePasse;
	}

	@JsonProperty("motDePasse")
	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}
	
	
}
