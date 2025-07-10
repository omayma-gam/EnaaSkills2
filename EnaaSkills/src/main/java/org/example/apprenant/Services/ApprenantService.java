package org.example.apprenant.Services;

import org.example.apprenant.DTO.ApprenantDto;
import org.example.apprenant.Entity.Apprenant;
import org.example.apprenant.Mapper.ApprenantMapper;
import org.example.apprenant.Repositorie.ApprenantRepo;

import java.util.List;

public class ApprenantService {
    private final ApprenantRepo apprenantRepo;
    private ApprenantMapper apprenantMapper;

    public ApprenantService(ApprenantRepo apprenantRepo, ApprenantMapper apprenantMapper) {
        this.apprenantRepo = apprenantRepo;
        this.apprenantMapper = apprenantMapper;
    }

    public ApprenantDto AjouterApprenant(ApprenantDto competenceDto){
        Apprenant competence=apprenantMapper.dtoToEntity(competenceDto);
        Apprenant competence1=apprenantRepo.save(competence);
        return apprenantMapper.entityToDto(competence1);
    }

    public List<Apprenant> ListApprenant() {
        return apprenantRepo.findAll();
    }
    public ApprenantDto modifierApprenant(Long id ,ApprenantDto apprenantDto){
        Apprenant apprenant=apprenantRepo.findById(id).orElse(null);
        if (apprenant==null){
            throw new RuntimeException("Aucune Compétence");
        }
        apprenant.setNom(apprenantDto.getNom());
        apprenant.setPrenom(apprenantDto.getPrenom());
        apprenant.setEmail(apprenantDto.getEmail());
        return apprenantMapper.entityToDto(apprenant);
    }

    public void supprimerRendu(Long id){
        apprenantRepo.deleteById(id);
    }

}
