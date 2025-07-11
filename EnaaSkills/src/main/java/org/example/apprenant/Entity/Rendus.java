package org.example.apprenant.Entity;

import jakarta.persistence.*;

import java.util.Date;
@Entity
public class Rendus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date datDepot;


    @ManyToOne
    private Brief brief;
    @ManyToOne
    private Apprenant apprenant;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDatDepot() {
        return datDepot;
    }

    public void setDatDepot(Date datDepot) {
        this.datDepot = datDepot;
    }

    public Brief getBrief() {
        return brief;
    }

    public void setBrief(Brief brief) {
        this.brief = brief;
    }

    public Apprenant getApprenant() {
        return apprenant;
    }

    public void setApprenant(Apprenant apprenant) {
        this.apprenant = apprenant;
    }

}
