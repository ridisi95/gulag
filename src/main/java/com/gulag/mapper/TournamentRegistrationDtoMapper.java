package com.gulag.mapper;

import com.gulag.dto.TournamentRegistrationDto;
import com.gulag.entity.TournamentRegistration;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface TournamentRegistrationDtoMapper {

    TournamentRegistrationDto tournamentRegistrationTournamentRegistrationDto(
            TournamentRegistration tournamentRegistration);

    List<TournamentRegistrationDto> listTournamentRegistrationTournamentDt
            (List<TournamentRegistration> tournamentRegistrations);
}
