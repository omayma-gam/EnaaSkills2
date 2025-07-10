package org.example.apprenant.DTO;

import org.example.apprenant.Entity.Apprenant;
import org.example.apprenant.Entity.Brief;

import java.io.Serializable;
import java.util.Date;


public class RenduDto implements Serializable {
    Long id;
    Date datDepot;
    Brief brief;
    Apprenant apprenant;

    public Date getDatDepot() {
        return datDepot;
    }

    public void setDatDepot(Date datDepot) {
        this.datDepot = datDepot;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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