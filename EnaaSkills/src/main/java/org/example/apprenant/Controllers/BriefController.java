package org.example.apprenant.Controllers;

import org.example.apprenant.Entity.Brief;
import org.example.apprenant.Services.BriefService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/briefs")
public class BriefController {

    @Autowired
    private BriefService briefService;

    @GetMapping
    @PreAuthorize("hasAnyRole('FORMATEUR', 'APPRENANT')")
    public List<Brief> getAllBriefs() {
        return briefService.getAllBriefs();
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('FORMATEUR', 'APPRENANT')")
    public ResponseEntity<Brief> getBriefById(@PathVariable Long id) {
        Optional<Brief> brief = briefService.getBriefById(id);
        if (brief.isPresent()) {
            return ResponseEntity.ok(brief.get());
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    @PreAuthorize("hasRole('FORMATEUR')")
    public Brief createBrief(@RequestBody Brief brief) {
        return briefService.saveBrief(brief);
    }
}
