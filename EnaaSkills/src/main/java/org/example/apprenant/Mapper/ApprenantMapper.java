package org.example.apprenant.Mapper;

import org.example.apprenant.DTO.ApprenantDto;
import org.example.apprenant.Entity.Apprenant;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring")
public interface ApprenantMapper {
    Apprenant dtoToEntity(ApprenantDto dto);
    ApprenantDto entityToDto(Apprenant entity);
}