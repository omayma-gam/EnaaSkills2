package org.example.apprenant.Entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "apprenants")
public class Apprenant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nom;

    @Column(nullable = false)
    private String prenom;

    @Column(nullable = false, unique = true)
    private String email;

    @OneToMany(mappedBy = "apprenantId", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Rendu> rendus;

    // Constructeurs
    public Apprenant() {}

    public Apprenant(String nom, String prenom, String email) {
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
    }

    // Getters et Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }

    public String getPrenom() { return prenom; }
    public void setPrenom(String prenom) { this.prenom = prenom; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public List<Rendu> getRendus() { return rendus; }
    public void setRendus(List<Rendu> rendus) { this.rendus = rendus; }
}