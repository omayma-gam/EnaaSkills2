package org.example.apprenant.Entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Apprenant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;
    private String nom;
    private String prenom;
    private String email;

    @OneToMany(mappedBy = "Apprenant")
    private List<Rendue> Rendue;

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

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Rendue> getRendue() {
        return Rendue;
    }

    public void setRendue(List<Rendue> rendue) {
        Rendue = rendue;
    }
}
