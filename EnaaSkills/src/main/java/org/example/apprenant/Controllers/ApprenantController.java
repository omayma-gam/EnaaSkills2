package org.example.apprenant.Controllers;

import org.example.apprenant.Entity.Apprenant;
import org.example.apprenant.Services.ApprenantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/apprenants")
@PreAuthorize("hasAnyRole('FORMATEUR', 'ADMIN')")
public class ApprenantController {

    @Autowired
    private ApprenantService apprenantService;

    @GetMapping
    public List<Apprenant> getAllApprenants() {
        return apprenantService.getAllApprenants();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Apprenant> getApprenantById(@PathVariable Long id) {
        Optional<Apprenant> apprenant = apprenantService.getApprenantById(id);
        if (apprenant.isPresent()) {
            return ResponseEntity.ok(apprenant.get());
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public Apprenant createApprenant(@RequestBody Apprenant apprenant) {
        return apprenantService.saveApprenant(apprenant);
    }
}
