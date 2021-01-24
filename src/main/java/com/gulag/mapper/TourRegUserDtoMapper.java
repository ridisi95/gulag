package com.gulag.mapper;

import com.gulag.dto.UserDTO;
import com.gulag.entity.TourRegEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface TourRegUserDtoMapper {

    @Mappings({
            @Mapping(target="employeeId", source="reg.id"),
            @Mapping(target="employeeName", source="entity.name")
    })
    List<UserDTO> getAllParticipantsFromListTournamentRegistration(
            List<TourRegEntity> registrations);
}
