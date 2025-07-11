package org.example.commpetence.Controllers;


import org.example.commpetence.Models.Validation;
import org.example.commpetence.Services.ValidationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/validations")
public class ValidationController {

    @Autowired
    private ValidationService validationService;

    @GetMapping
    public List<Validation> getAllValidations() {
        return validationService.getAllValidations();
    }

    @GetMapping("/by-apprenant/{id}")
    public List<Validation> getValidationsByApprenantId(@PathVariable Long id) {
        return validationService.getValidationsByApprenantId(id);
    }

    @GetMapping("/by-competence/{id}")
    public List<Validation> getValidationsByCompetenceId(@PathVariable Long id) {
        return validationService.getValidationsByCompetenceId(id);
    }

    @PostMapping
    public ResponseEntity<Validation> createValidation(@RequestBody Validation validation) {
        try {
            Validation savedValidation = validationService.saveValidation(validation);
            return ResponseEntity.ok(savedValidation);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteValidation(@PathVariable Long id) {
        validationService.deleteValidation(id);
        return ResponseEntity.noContent().build();
    }
}