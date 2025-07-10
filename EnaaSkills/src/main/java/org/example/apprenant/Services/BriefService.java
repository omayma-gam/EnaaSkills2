package org.example.apprenant.Services;

import org.example.apprenant.DTO.BriefDto;
import org.example.apprenant.Entity.Brief;
import org.example.apprenant.Mapper.BriefMappper;
import org.example.apprenant.Repositorie.BriefRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BriefService {
    private final BriefRepository repository;
    private final BriefMappper mapper;

    public BriefService(BriefRepository repository, BriefMappper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public BriefDto creerBrief(BriefDto briefDto){
        Brief brief = mapper.toEntity(briefDto);
        Brief brief1 = repository.save(brief);
        return mapper.toDto(brief1);
    }

    public List<BriefDto> List(){
        return repository.findAll()
                .stream()
                .map(mapper::toDto).toList();
    }
    public BriefDto ModifierBrief(Long id, BriefDto briefDto){
        Brief brief = repository.findById(id).orElse(null);
        brief.setTitre(briefDto.getTitre());
        brief.setDescription(briefDto.getDescription());
        brief.setDateCreation(briefDto.getDateCreation());
//        brief.getCompetencesIds(briefDto.getCompetencesIds());
        return mapper.toDto(repository.save(brief));
    }


    public void SupprimerBrief(Long id){
        repository.findById(id);
    }
//    public BriefDto associerCompetences(Long briefId, List<Long> competenceIds) {
//        var brief = repository.findById(briefId).orElseThrow();
//        brief.getCompetencesIds().addAll(competenceIds);
//        return mapper.toDto(repository.save(brief));
//    }
}
