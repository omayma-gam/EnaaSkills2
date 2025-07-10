package org.example.apprenant.Mapper;

import org.example.apprenant.DTO.RenduDto;
import org.example.apprenant.Entity.Rendus;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedSourcePolicy = ReportingPolicy.IGNORE)

public interface RenduMapper {
    @Mapping(source = "apprenant.id" , target = "apprenantId")
    RenduDto entityToDto(Rendus rendu);
    @Mapping(target = "apprenant.id" , source = "apprenantId")
    Rendus dtoToEntity(RenduDto renduDto);
}
