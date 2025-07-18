package org.example.commpetence.Controllers;

import org.example.commpetence.DTO.Sous_CompetenceDto;
import org.example.commpetence.Services.Sous_CompetenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/soucompetence")
public class Sous_CompetenceController {

    @Autowired
    private final Sous_CompetenceService sousCompetenceService;

    public Sous_CompetenceController(Sous_CompetenceService sousCompetenceService) {
        this.sousCompetenceService = sousCompetenceService;
    }

    @PostMapping("/add")
    @PreAuthorize("hasAnyRole('ADMIN', 'FORMATEUR')")
    public Sous_CompetenceDto AddSousCompetence(@RequestBody Sous_CompetenceDto sous_competenceDto) {
        return sousCompetenceService.AjouterSousCompetence(sous_competenceDto);
    }

    @GetMapping("/list")
    @PreAuthorize("hasAnyRole('ADMIN', 'FORMATEUR', 'APPRENANT')")
    public List<Sous_CompetenceDto> getAll(){
        return sousCompetenceService.ListSousCompetence();
    }

    @PutMapping("/updat/{id}")
    @PreAuthorize("hasAnyRole('ADMIN', 'FORMATEUR')")
    public Sous_CompetenceDto updatSousCompetence(@PathVariable Long id , @RequestBody Sous_CompetenceDto sousCompetenceDto){
        return sousCompetenceService.modifier(id,sousCompetenceDto);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyRole('ADMIN', 'FORMATEUR')")
    public void delet(@PathVariable Long id){
        sousCompetenceService.supprimerSousCompetence(id);
    }

    @PatchMapping("/{id}/{etatValidation}")
    @PreAuthorize("hasAnyRole('ADMIN', 'FORMATEUR')")
    public ResponseEntity<Sous_CompetenceDto> updateEtatValidation(
            @PathVariable Long id,
            @PathVariable boolean etatValidation) {
        Sous_CompetenceDto updatedDto = sousCompetenceService.updateEtatValidation(id, etatValidation);
        return ResponseEntity.ok(updatedDto);
    }
}
