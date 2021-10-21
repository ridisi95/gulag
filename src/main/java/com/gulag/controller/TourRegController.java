package com.gulag.controller;

import com.gulag.dto.TourRegDTO;
import com.gulag.dto.TournamentDTO;
import com.gulag.dto.UserDTO;
import com.gulag.entity.TourRegEntity;
import com.gulag.enums.TournamentStatus;
import com.gulag.mapper.TourEntityDTOMapper;
import com.gulag.mapper.TourRegDTOMapper;
import com.gulag.mapper.UserEntityDTOMapper;
import com.gulag.services.TourRegService;
import io.swagger.annotations.ApiOperation;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RequiredArgsConstructor
@RestController
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@RequestMapping("/register")
public class TourRegController {

    TourRegService registrationService;
    TourRegDTOMapper tourRegMapper;
    UserEntityDTOMapper userMapper;
    TourEntityDTOMapper tournamentMapper;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "participants/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<UserDTO> getParticipantsInTournament(@PathVariable("id") Long tournamentId) {
        return userMapper.mapEntityToDTO(
                registrationService.findAllByTournamentId(tournamentId)
                        .stream().map(TourRegEntity::getUser).collect(Collectors.toList()));

    }

    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value = "register new user on certain tournament")
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public TourRegDTO registerTournament(@RequestParam Long tournamentId, @RequestParam Long userId) {
//        TourRegEntity tourRegEntity = tourRegMapper.mapDTOToEntity(registration);
//        return tourRegMapper.mapEntityToDTO(registrationService.registerOnTournament(tourRegEntity));
//        TourRegEntity tourRegEntity = new TourRegEntity(tournamentId, userId);
        return null;
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<TourRegDTO> findAllRegisters() {
        return tourRegMapper.mapListEntitiesToDTOs(registrationService.findAll());
    }

    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public void deleteByUserIdAndTournamentId(
            @RequestParam Long userId,
            @RequestParam Long tournamentId) {
        registrationService.deleteRegistration(userId, tournamentId);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "tournaments", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<TournamentDTO> getTournamentByUser(@RequestParam Long userId) {
        return tournamentMapper.mapListEntitiesToDTOs(registrationService.findAllTourRegByUser(userId).stream()
                .map(TourRegEntity::getTournament).collect(Collectors.toList()));
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "tournaments/{status}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<TournamentDTO> getTournamentByUserAndStatus(
            @RequestParam Long userId, @PathVariable TournamentStatus status) {
        return tournamentMapper.mapListEntitiesToDTOs(
                registrationService.findAllTourRegByUserAndStatus(userId, status).stream()
                .map(TourRegEntity::getTournament).collect(Collectors.toList()));
    }

}
