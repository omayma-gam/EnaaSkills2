package ma.enaa.briefservice.Model;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
public class Brief {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titre;

    private String description;

    private Date dateCreation;

    @ElementCollection
    private List<Long> competencesIds;

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
