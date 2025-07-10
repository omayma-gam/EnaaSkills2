package ma.enaa.briefservice.Mapper;

import ma.enaa.briefservice.Model.Brief;
import ma.enaa.briefservice.dto.BriefDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")

public interface BriefMappper {
    BriefDto toDto(Brief brief);
    Brief toEntity(BriefDto dto);
}
