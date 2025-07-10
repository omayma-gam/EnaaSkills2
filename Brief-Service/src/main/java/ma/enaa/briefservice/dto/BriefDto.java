package ma.enaa.briefservice.dto;

import lombok.Value;
import ma.enaa.briefservice.Model.Brief;

import java.io.Serializable;
import java.util.Date;
import java.util.List;


public class BriefDto  {
    Long id;
    String titre;
    String description;
    Date dateCreation;
    List<Long> competencesIds;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }

    public List<Long> getCompetencesIds() {
        return competencesIds;
    }

    public void setCompetencesIds(List<Long> competencesIds) {
        this.competencesIds = competencesIds;
    }
}