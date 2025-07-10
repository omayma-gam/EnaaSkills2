package org.example.apprenant.Entity;

import jakarta.persistence.*;

import javax.xml.crypto.Data;
import java.util.Date;
@Entity
public class Rendu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date datDepot;


    @ManyToOne
    private Brief brief;
    @ManyToOne
    private Apprenant apprenant;
}
