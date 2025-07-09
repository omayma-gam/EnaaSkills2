package org.example.commpetence.DTO;

import lombok.Value;
import org.example.commpetence.Models.Competence;

import java.io.Serializable;
import java.util.List;

public class CompetenceDto implements Serializable {
    Long id;
    String nom;
    String description;
    boolean etatValidation;
    List<Sous_CompetenceDto> sousCompetences;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isEtatValidation() {
        return etatValidation;
    }

    public void setEtatValidation(boolean etatValidation) {
        this.etatValidation = etatValidation;
    }

    public List<Sous_CompetenceDto> getSousCompetences() {
        return sousCompetences;
    }

    public void setSousCompetences(List<Sous_CompetenceDto> sousCompetences) {
        this.sousCompetences = sousCompetences;
    }
}