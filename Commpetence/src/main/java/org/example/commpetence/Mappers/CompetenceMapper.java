package org.example.commpetence.Mappers;

import org.example.commpetence.DTO.CompetenceDto;
import org.example.commpetence.Models.Competence;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedSourcePolicy = ReportingPolicy.IGNORE)

public interface CompetenceMapper {

    CompetenceDto competenceToDto(Competence competence);
    Competence dtoToCompetence(CompetenceDto competenceDto);
}
