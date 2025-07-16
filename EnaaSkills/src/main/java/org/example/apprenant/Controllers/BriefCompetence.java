package org.example.apprenant.Controllers;

import org.example.apprenant.Entity.Apprenant;
import org.example.apprenant.Entity.BriefCompetenceDto;
import org.example.apprenant.Services.ApprenantService;
import org.example.apprenant.Services.BriefCompetenceServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

public class BriefCompetence {
    private BriefCompetenceServices briefCompetenceServices;

    public BriefCompetence(BriefCompetenceServices briefCompetenceServices) {
        this.briefCompetenceServices = briefCompetenceServices;
    }


}

