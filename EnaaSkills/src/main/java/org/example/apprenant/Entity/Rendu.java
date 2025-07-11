package org.example.apprenant.Entity;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "rendus")
public class Rendu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private LocalDate dateDepot;

    @Column(nullable = false)
    private Long briefId;

    @Column(nullable = false)
    private Long apprenantId;

    @ElementCollection
    @CollectionTable(name = "rendu_urls", joinColumns = @JoinColumn(name = "rendu_id"))
    @Column(name = "url")
    private List<String> renduUrls;

    // Constructeurs
    public Rendu() {}

    public Rendu(LocalDate dateDepot, Long briefId, Long apprenantId, List<String> renduUrls) {
        this.dateDepot = dateDepot;
        this.briefId = briefId;
        this.apprenantId = apprenantId;
        this.renduUrls = renduUrls;
    }

    // Getters et Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public LocalDate getDateDepot() { return dateDepot; }
    public void setDateDepot(LocalDate dateDepot) { this.dateDepot = dateDepot; }

    public Long getBriefId() { return briefId; }
    public void setBriefId(Long briefId) { this.briefId = briefId; }

    public Long getApprenantId() { return apprenantId; }
    public void setApprenantId(Long apprenantId) { this.apprenantId = apprenantId; }

    public List<String> getRenduUrls() { return renduUrls; }
    public void setRenduUrls(List<String> renduUrls) { this.renduUrls = renduUrls; }
}