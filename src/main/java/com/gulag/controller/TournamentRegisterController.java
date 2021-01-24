package com.gulag.controller;

import com.gulag.dto.TournamentRegistrationDto;
import com.gulag.dto.UserDto;
import com.gulag.entity.TournamentRegistration;
import com.gulag.services.TournamentRegistrationDtoService;
import com.gulag.services.TournamentRegistrationService;
import com.gulag.services.UserDtoService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RestController
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@RequestMapping("/register")
public class TournamentRegisterController {


    TournamentRegistrationService registrationService;
    UserDtoService userDtoService;
    TournamentRegistrationDtoService registrationDtoService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "participants/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<UserDto> getParticipants(@PathVariable("id") Long tournamentId) {
        return userDtoService.getAllParticipantOfTournamentRegistration(
                registrationService.findAllByTournamentId(tournamentId));

    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public TournamentRegistration registerTournament(@RequestBody TournamentRegistration registration) {
        return registrationService.registerTournament(registration);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<TournamentRegistrationDto> findAllRegisters() {
        return registrationDtoService.getAllTournaments(registrationService.findAll());
    }

    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public boolean deleteByUserIdAndTournamentId(
            @RequestParam Long userId,
            @RequestParam Long tournamentId) {
        return registrationService.deleteRegistration(userId, tournamentId);
    }

}
