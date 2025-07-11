package org.example.apprenant.Controllers;


import org.example.apprenant.Entity.Brief;
import org.example.apprenant.Services.BriefService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/briefs")
public class BriefController {

    @Autowired
    private BriefService briefService;

    @GetMapping
    public List<Brief> getAllBriefs() {
        return briefService.getAllBriefs();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Brief> getBriefById(@PathVariable Long id) {
        Optional<Brief> brief = briefService.getBriefById(id);
        if (brief.isPresent()) {
            return ResponseEntity.ok(brief.get());
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public Brief createBrief(@RequestBody Brief brief) {
        return briefService.saveBrief(brief);
    }
}