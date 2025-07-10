package org.example.apprenant.Mapper;

import org.example.apprenant.DTO.ApprenantDto;
import org.example.apprenant.Entity.Apprenant;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedSourcePolicy = ReportingPolicy.IGNORE)

public interface ApprenantMapper {
    ApprenantDto entityToDto(Apprenant competence);
    Apprenant dtoToEntity(ApprenantDto competenceDto);
}
