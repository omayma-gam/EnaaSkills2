package org.example.apprenant.DTO;

import lombok.Value;
import org.example.apprenant.Entity.Brief;

import java.io.Serializable;
import java.util.Date;

public class BriefDto  {
    Long id;
    String titre;
    String description;
    Date dateCreation;

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
}