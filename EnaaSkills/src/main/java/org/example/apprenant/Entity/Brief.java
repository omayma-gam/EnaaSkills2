package org.example.apprenant.Entity;

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


    @OneToMany (mappedBy = "brief_Id")
    private List<Rendu> rendus;


//    @ElementCollection
//    private List<Long> competencesIds;
}
