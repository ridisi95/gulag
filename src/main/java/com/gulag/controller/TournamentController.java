package com.gulag.controller;

import com.gulag.dto.TournamentDTO;
import com.gulag.entity.TournamentEntity;
import com.gulag.mapper.TourEntityDTOMapper;
import com.gulag.services.TournamentService;
import com.gulag.validation.marker.OnCreate;
import com.gulag.validation.marker.OnUpdate;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import javax.validation.Valid;

@RequiredArgsConstructor
@RestController
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@RequestMapping("/tournaments")
public class TournamentController {

    TourEntityDTOMapper mapper;
    TournamentService tournamentService;

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public TournamentDTO registerTournament(@Validated(OnCreate.class) @Valid @RequestBody TournamentDTO registration) {
        TournamentEntity tourRegEntity = mapper.mapDTOToEntity(registration);
        return mapper.mapEntityToDTO(tournamentService.saveTournament(tourRegEntity));
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<TournamentDTO> findAllTournaments() {
        return mapper.mapListEntitiesToDTOs(tournamentService.findAllTournaments());
    }

    @PatchMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public TournamentDTO updateTournamentStatus(@Validated(OnUpdate.class) @Valid @RequestBody TournamentDTO tournamentDTO) {
        TournamentEntity tourRegEntity = mapper.mapDTOToEntity(tournamentDTO);
        return mapper.mapEntityToDTO(tournamentService.updateStatusOfTournament(tourRegEntity));
    }
}
