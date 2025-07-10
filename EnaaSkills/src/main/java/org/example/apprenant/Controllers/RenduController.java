package org.example.apprenant.Controllers;

import org.example.apprenant.DTO.ApprenantDto;
import org.example.apprenant.DTO.RenduDto;
import org.example.apprenant.Entity.Rendus;
import org.example.apprenant.Services.RenduService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rendu")
public class RenduController {

    private final RenduService renduService;

    public RenduController(RenduService renduService) {
        this.renduService = renduService;
    }
    @PostMapping("/add")
    public RenduDto addRendu(@RequestBody RenduDto renduDto) {
        return renduService.AjouterRendu(renduDto);
    }

    @GetMapping("/list")
    public List<Rendus> getAll() {
        return renduService.ListRendus();
    }

    @PutMapping("/update/{id}")
    public RenduDto updateRendu(@PathVariable Long id, @RequestBody RenduDto renduDto) {
        return renduService.modifierRendus(renduDto, id);
    }

    @DeleteMapping("/{id}")
    public void deleteApprenant(@PathVariable Long id) {
        renduService.supprimerApprenant(id);
    }
}
