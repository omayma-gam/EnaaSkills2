package org.example.apprenant.DTO;

import org.example.apprenant.Entity.Apprenant;
import org.example.apprenant.Entity.Brief;

import java.io.Serializable;
import java.util.Date;


public class RenduDto   {
    Long id;
    Date datDepot;
    Brief brief;
    Long apprenantId;

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

    public Long getApprenantId() {
        return apprenantId;
    }

    public void setApprenantId(Long apprenantId) {
        this.apprenantId = apprenantId;
    }
}