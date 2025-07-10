package org.example.apprenant.Mapper;

import org.example.apprenant.DTO.RenduDto;
import org.example.apprenant.Entity.Rendus;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedSourcePolicy = ReportingPolicy.IGNORE)

public interface RenduMapper {
    RenduDto entityToDto(Rendus rendu);
    Rendus dtoToEntity(RenduDto renduDto);
}
