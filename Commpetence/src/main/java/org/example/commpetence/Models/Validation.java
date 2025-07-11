package org.example.commpetence.Models;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "validations")
public class Validation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long briefId;

    @Column(nullable = false)
    private Long apprenantId;

    @Column(nullable = false)
    private Long competenceId;

    @Column(nullable = false)
    private LocalDate dateValidation;

    // Constructeurs
    public Validation() {}

    public Validation(Long briefId, Long apprenantId, Long competenceId, LocalDate dateValidation) {
        this.briefId = briefId;
        this.apprenantId = apprenantId;
        this.competenceId = competenceId;
        this.dateValidation = dateValidation;
    }

    // Getters et Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getBriefId() { return briefId; }
    public void setBriefId(Long briefId) { this.briefId = briefId; }

    public Long getApprenantId() { return apprenantId; }
    public void setApprenantId(Long apprenantId) { this.apprenantId = apprenantId; }

    public Long getCompetenceId() { return competenceId; }
    public void setCompetenceId(Long competenceId) { this.competenceId = competenceId; }

    public LocalDate getDateValidation() { return dateValidation; }
    public void setDateValidation(LocalDate dateValidation) { this.dateValidation = dateValidation; }
}