package org.example.apprenant.Controllers;

import org.example.apprenant.DTO.ApprenantDto;
import org.example.apprenant.Entity.Apprenant;
import org.example.apprenant.Services.ApprenantService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/apprenant")
public class ApprenantController {

    private final ApprenantService apprenantService;

    public ApprenantController(ApprenantService apprenantService) {
        this.apprenantService = apprenantService;
    }

    @PostMapping("/add")
    public ApprenantDto addApprenant(@RequestBody ApprenantDto apprenantDto) {
        return apprenantService.AjouterApprenant(apprenantDto);
    }

    @GetMapping("/list")
    public List<Apprenant> getAll() {
        return apprenantService.ListApprenant();
    }

    @PutMapping("/update/{id}")
    public ApprenantDto updateApprenant(@PathVariable Long id, @RequestBody ApprenantDto apprenantDto) {
        return apprenantService.modifierApprenant(id, apprenantDto);
    }

    @DeleteMapping("/{id}")
    public void deleteApprenant(@PathVariable Long id) {
        apprenantService.supprimerApprenant(id);
    }
}
