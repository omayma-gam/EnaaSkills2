package org.example.apprenant.Controllers;

import org.example.apprenant.Entity.BriefCompetence;
import org.example.apprenant.Services.BriefCompetenceServices;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public class BriefCompetenceController {
    private final BriefCompetenceServices briefCompetenceServices;

    public BriefCompetenceController(BriefCompetenceServices briefCompetenceServices) {
        this.briefCompetenceServices = briefCompetenceServices;
    }
    @GetMapping("/brief/{id}")
        public List<BriefCompetence> getBriefCompetenceId(@PathVariable Long id) {
       return briefCompetenceServices.getBriefCompetenceId(id);
    }
    @GetMapping("competence/{id}")
    public List<BriefCompetence> getCompetenceBriefId(@PathVariable Long id) {
        return briefCompetenceServices.getByCompetenceId(id);
    }
    @GetMapping
    public  List<BriefCompetence> getAll(){
        return briefCompetenceServices.getAll();
    }


}

