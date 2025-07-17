package org.example.apprenant.Services;

import org.example.apprenant.Entity.Apprenant;
import org.example.apprenant.Entity.BriefCompetence;
import org.example.apprenant.Entity.BriefCompetenceDto;
import org.example.apprenant.Repositorie.ApprenantRepository;
import org.example.apprenant.Repositorie.BriefCompetenceRepository;
import org.example.apprenant.Repositorie.BriefRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BriefCompetenceServices {



    private BriefCompetenceRepository briefCompetenceRepository;
    private BriefRepository briefRepository;


    public BriefCompetenceServices(BriefCompetenceRepository briefCompetenceRepository) {
        this.briefCompetenceRepository = briefCompetenceRepository;
    }

    public List<BriefCompetence> getBriefCompetenceId(Long briefId) {
        return briefCompetenceRepository.findByBriefId(briefId);
    }

    public List<BriefCompetence>  getByCompetenceId(Long competenceId){
        return briefCompetenceRepository.findByCompetenceId(competenceId);
    }
     public List<BriefCompetence> getAll(){
        return briefCompetenceRepository.findAll();
     }





}
