package com.gulag.controller;

import com.gulag.dto.TourRegDTO;
import com.gulag.dto.TournamentDTO;
import com.gulag.entity.TournamentEntity;
import com.gulag.enums.TournamentRole;
import com.gulag.mapper.TourEntityDTOMapper;
import com.gulag.services.TournamentService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor(onConstructor = @__({@Autowired}))
@RestController
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@RequestMapping("/tournaments")
public class TournamentController {

    TourEntityDTOMapper mapper;
    TournamentService tournamentService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public TournamentDTO registerTournament(@RequestBody TournamentDTO registration) {
        TournamentEntity tourRegEntity = mapper.mapDTOToEntity(registration);
        return mapper.mapEntityToDTO(tournamentService.saveTournament(tourRegEntity));
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<TournamentDTO> findAllTournaments() {
        return mapper.mapListEntitiesToDTOs(tournamentService.findAllTournaments());
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value = "/status", produces = MediaType.APPLICATION_JSON_VALUE)
    public TournamentDTO updateTournamentStatus(@RequestParam Long tournamentId,
                                                @RequestParam TournamentRole status) {
        TournamentEntity tournamentById = tournamentService.findById(tournamentId);
        tournamentById.setStatus(status);
        return mapper.mapEntityToDTO(tournamentService.saveTournament(tournamentById));
    }
}
