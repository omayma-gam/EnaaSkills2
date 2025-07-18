package org.example.commpetence.Controllers;

import org.example.commpetence.Models.Validation;
import org.example.commpetence.Services.ValidationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/validations")
public class ValidationController {

    @Autowired
    private ValidationService validationService;

    @GetMapping
    @PreAuthorize("hasAnyRole('ADMIN', 'FORMATEUR', 'APPRENANT')")
    public List<Validation> getAllValidations() {
        return validationService.getAllValidations();
    }

    @GetMapping("/by-apprenant/{id}")
    @PreAuthorize("hasAnyRole('ADMIN', 'FORMATEUR', 'APPRENANT')")
    public List<Validation> getValidationsByApprenantId(@PathVariable Long id) {
        return validationService.getValidationsByApprenantId(id);
    }

    @GetMapping("/by-competence/{id}")
    @PreAuthorize("hasAnyRole('ADMIN', 'FORMATEUR', 'APPRENANT')")
    public List<Validation> getValidationsByCompetenceId(@PathVariable Long id) {
        return validationService.getValidationsByCompetenceId(id);
    }

    @PostMapping
    @PreAuthorize("hasAnyRole('ADMIN', 'FORMATEUR')")
    public ResponseEntity<Validation> createValidation(@RequestBody Validation validation) {
        try {
            Validation savedValidation = validationService.saveValidation(validation);
            return ResponseEntity.ok(savedValidation);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyRole('ADMIN', 'FORMATEUR')")
    public ResponseEntity<Void> deleteValidation(@PathVariable Long id) {
        validationService.deleteValidation(id);
        return ResponseEntity.noContent().build();
    }
}
