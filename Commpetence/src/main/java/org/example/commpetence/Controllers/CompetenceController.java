package org.example.commpetence.Controllers;

import jakarta.servlet.http.HttpServletResponse;
import org.example.commpetence.DTO.CompetenceDto;
import org.example.commpetence.Models.Competence;
import org.example.commpetence.Services.CompetenceService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/Competence")
public class CompetenceController {

    private final CompetenceService competenceService;

    public CompetenceController(CompetenceService competenceService) {
        this.competenceService = competenceService;
    }

    @PostMapping("/add")
    @PreAuthorize("hasAnyRole('ADMIN', 'FORMATEUR')")
    public CompetenceDto AddCompetence(@RequestBody CompetenceDto competenceDto){
        return competenceService.AjouterCompetence(competenceDto);
    }

    @GetMapping("/List")
    @PreAuthorize("hasAnyRole('ADMIN', 'FORMATEUR', 'APPRENANT')")
    public List<Competence> getAll(){
        return competenceService.ListCompetence();
    }

    @PutMapping("/updat/{id}")
    @PreAuthorize("hasAnyRole('ADMIN', 'FORMATEUR')")
    public CompetenceDto updatCompetence(@PathVariable Long id , @RequestBody CompetenceDto competenceDto){
        return competenceService.modifierCompetence(id,competenceDto);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyRole('ADMIN', 'FORMATEUR')")
    public void delete(@PathVariable Long id){
        competenceService.supprimerCompetence(id);
    }


    @GetMapping("/export/excel")
    @PreAuthorize("hasAnyRole('ADMIN', 'FORMATEUR')")
    public void exportToExcel(HttpServletResponse response) throws IOException {

        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");


        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
        String currentDateTime = dateFormatter.format(new Date());
        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=rapportcompetences" + currentDateTime + ".xlsx";
        response.setHeader(headerKey, headerValue);


        List<Competence> competences = competenceService.ListCompetence();


    }

}
