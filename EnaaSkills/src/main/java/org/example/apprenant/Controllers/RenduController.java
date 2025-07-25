package org.example.apprenant.Controllers;

import org.example.apprenant.Entity.Rendu;
import org.example.apprenant.Services.RenduService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rendus")
public class RenduController {


    private final RenduService renduService;

    public RenduController(RenduService renduService) {
        this.renduService = renduService;
    }

    @PostMapping
    @PreAuthorize("hasRole('APPRENANT')")
    public Rendu createRendu(@RequestBody Rendu rendu) {
        return renduService.saveRendu(rendu);
    }
}
