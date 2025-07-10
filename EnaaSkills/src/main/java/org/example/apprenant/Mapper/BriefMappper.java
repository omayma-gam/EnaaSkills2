package org.example.apprenant.Mapper;

import org.example.apprenant.DTO.BriefDto;
import org.example.apprenant.Entity.Brief;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")


public interface BriefMappper {
    BriefDto toDto(Brief brief);
    Brief toEntity(BriefDto dto);
}
