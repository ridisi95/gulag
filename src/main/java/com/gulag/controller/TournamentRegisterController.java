package com.gulag.controller;

import com.gulag.entity.TournamentRegistration;
import com.gulag.entity.dto.UserDto;
import com.gulag.services.TournamentRegistrationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/register")
public class TournamentRegisterController {

    private final TournamentRegistrationService registrationService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "participants/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<UserDto> getParticipants(@PathVariable("id") Long tournamentId) {
        return registrationService.findAllUsersByTournamentId(tournamentId);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public TournamentRegistration registerTournament(@RequestBody TournamentRegistration registration) {
        return registrationService.registerTournament(registration);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<TournamentRegistration> findAllRegisters() {
        return registrationService.findAll();
    }

    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public boolean deleteByUserIdAndTournamentId(
            @RequestParam(name = "user") Long userId,
            @RequestParam(name = "tour") Long tournamentId) {
        return registrationService.deleteRegistration(userId, tournamentId);
    }

}
