package com.gulag.controller;

import com.gulag.dto.TourRegDTO;
import com.gulag.dto.UserDTO;
import com.gulag.entity.TourRegEntity;
import com.gulag.mapper.TourRegDtoMapper;
import com.gulag.services.TourRegService;
import com.gulag.services.UserDtoService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RestController
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@RequestMapping("/register")
public class TourRegController {


    TourRegService registrationService;
    UserDtoService userDtoService;

    @Autowired
    TourRegDtoMapper mapper;


    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "participants/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<UserDTO> getParticipants(@PathVariable("id") Long tournamentId) {
        return userDtoService.getAllParticipantOfTournamentRegistration(
                registrationService.findAllByTournamentId(tournamentId));

    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public TourRegDTO registerTournament(@RequestBody TourRegDTO registration) {
        log.info(registration.toString());
        TourRegEntity tourRegEntity = mapper.mapDTOToEntity(registration);
        log.info(tourRegEntity.toString());
        return mapper.mapEntityToDTO(registrationService.registerTournament(tourRegEntity));
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<TourRegDTO> findAllRegisters() {
        return mapper.mapListEntitiesToDTOs(registrationService.findAll());
    }

    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public void deleteByUserIdAndTournamentId(
            @RequestParam Long userId,
            @RequestParam Long tournamentId) {
        registrationService.deleteRegistration(userId, tournamentId);
    }

}
