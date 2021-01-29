package com.gulag.controller;

import com.gulag.dto.TourRegDTO;
import com.gulag.dto.UserDTO;
import com.gulag.entity.TourRegEntity;
import com.gulag.mapper.TourRegDTOMapper;
import com.gulag.mapper.UserEntityDTOMapper;
import com.gulag.services.TourRegService;
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

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "participants/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<UserDTO> getParticipantsInTournament(@PathVariable("id") Long tournamentId) {
        return userMapper.listUserEntitiesToUserDTOs(
                registrationService.findAllByTournamentId(tournamentId)
                .stream().map(TourRegEntity::getUser).collect(Collectors.toList()));

    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public TourRegDTO registerTournament(@RequestBody TourRegDTO registration) {
        TourRegEntity tourRegEntity = tourRegMapper.mapDTOToEntity(registration);
        return tourRegMapper.mapEntityToDTO(registrationService.registerOnTournament(tourRegEntity));
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

}
