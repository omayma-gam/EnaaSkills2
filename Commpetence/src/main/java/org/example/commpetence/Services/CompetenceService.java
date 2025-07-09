package org.example.commpetence.Services;

import org.example.commpetence.DTO.CompetenceDto;
import org.example.commpetence.Mappers.CompetenceMapper;
import org.example.commpetence.Models.Competence;
import org.example.commpetence.Repositories.CompetenceRepo;
import org.example.commpetence.Repositories.Sous_CompetenceRepo;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CompetenceService {

    private final CompetenceRepo competenceRepo;
    private final Sous_CompetenceRepo sous_CompetenceRepo;
    private CompetenceMapper competenceMapper;


    public CompetenceService(CompetenceRepo competenceRepo, CompetenceMapper competenceMapper, Sous_CompetenceRepo sous_CompetenceRepo) {
        this.competenceRepo = competenceRepo;
        this.competenceMapper = competenceMapper;
        this.sous_CompetenceRepo = sous_CompetenceRepo;
    }

    public CompetenceDto AjouterCompetence(CompetenceDto competenceDto){
        Competence competence=competenceMapper.dtoToCompetence(competenceDto);
        Competence competence1=competenceRepo.save(competence);
        return competenceMapper.competenceToDto(competence1);
    }

    public List<Competence> ListCompetence() {
        return competenceRepo.findAll();
    }
    public CompetenceDto modifierCompetence(Long id ,CompetenceDto competenceDto){
        Competence competence=competenceRepo.findById(id).orElse(null);
        if (competence==null){
            throw new RuntimeException("Aucune Compétence");
        }
        competence.setNom(competenceDto.getNom());
        competence.setDescription(competenceDto.getDescription());
        return competenceMapper.competenceToDto(competence);
    }

    public void supprimerCompetence(Long id){
        competenceRepo.deleteById(id);
    }

//    public void verifierEtMettreAJourStatutCompetence(Long competenceId) {
//        Competence competence = competenceRepo.findById(competenceId).orElseThrow();
//
//        long total = sousCompetenceRepo.countByCompetenceId(competenceId);
//        long valides = sousCompetenceRepo.countByCompetenceIdAndEtatValidationTrue(competenceId);
//
//        boolean estAcquise = total > 0 && valides == total;
//        competence.setAcquise(estAcquise);
//
//        competenceRepo.save(competence);
//    }


}
