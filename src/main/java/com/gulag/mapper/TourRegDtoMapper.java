package com.gulag.mapper;

import com.gulag.dto.TourRegDTO;
import com.gulag.dto.UserDTO;
import com.gulag.entity.TourRegEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface TourRegDtoMapper {

    TourRegDTO mapEntityToDTO(
            TourRegEntity tournamentRegistration);

    TourRegEntity mapDTOToEntity(
            TourRegDTO tournamentRegistration);

    List<TourRegDTO> mapListEntitiesToDTOs
            (List<TourRegEntity> tournamentRegistrations);

}
