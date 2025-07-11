package org.example.apprenant.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "brief_competences")
public class BriefCompetence {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long briefId;

    @Column(nullable = false)
    private Long competenceId;

    // Constructeurs
    public BriefCompetence() {}

    public BriefCompetence(Long briefId, Long competenceId) {
        this.briefId = briefId;
        this.competenceId = competenceId;
    }

    // Getters et Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getBriefId() { return briefId; }
    public void setBriefId(Long briefId) { this.briefId = briefId; }

    public Long getCompetenceId() { return competenceId; }
    public void setCompetenceId(Long competenceId) { this.competenceId = competenceId; }
}