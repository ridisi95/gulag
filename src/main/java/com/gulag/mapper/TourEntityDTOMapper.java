package com.gulag.mapper;

import com.gulag.dto.TournamentDTO;
import com.gulag.entity.TournamentEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface TourEntityDTOMapper {

    TournamentDTO mapEntityToDTO(
            TournamentEntity tournamentEntity);

    TournamentEntity mapDTOToEntity(
            TournamentDTO tournamentDTO);

    List<TournamentDTO> mapListEntitiesToDTOs
            (List<TournamentEntity> tournamentEntities);
}
