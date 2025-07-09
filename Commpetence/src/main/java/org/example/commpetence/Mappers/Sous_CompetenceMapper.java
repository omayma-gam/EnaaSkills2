package org.example.commpetence.Mappers;

import org.example.commpetence.DTO.Sous_CompetenceDto;
import org.example.commpetence.Models.Sous_Competence;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedSourcePolicy = ReportingPolicy.IGNORE)

public interface Sous_CompetenceMapper {

    Sous_CompetenceDto souscompeteneToDto(Sous_Competence sousCompetence);
    Sous_Competence dtoToSousCompetence(Sous_CompetenceDto sousCompetenceDto);
}
