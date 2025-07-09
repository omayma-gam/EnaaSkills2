package org.example.apprenant.Controllers;

import org.example.apprenant.DTO.ApprenantDto;
import org.example.apprenant.Services.ApprenantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Apprenant")
public class ApprenantController {


    @Autowired
    private final ApprenantService apprenantService;

    public ApprenantController(ApprenantService apprenantService) {
        this.apprenantService = apprenantService;
    }


    @PostMapping("/add")
    public ApprenantDto AddSousCompetence(@RequestBody ApprenantDto sous_competenceDto) {
        return apprenantService.AjouterCompetence(sous_competenceDto);
    }

    @GetMapping("/list")
    public List<ApprenantDto> getAll(){
        return apprenantService.ListCompetence();
    }

    @PutMapping("/updat/{id}")
    public ApprenantDto updatSousCompetence(@PathVariable Long id , @RequestBody ApprenantDto sousCompetenceDto){
        return apprenantService.modifierCompetence(id,sousCompetenceDto);
    }

    @DeleteMapping("/{id}")
    public void delet(@PathVariable Long id){
        apprenantService.supprimerCompetence(id);
    }



}
