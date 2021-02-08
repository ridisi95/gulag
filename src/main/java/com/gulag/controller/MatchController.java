package com.gulag.controller;

import com.gulag.dto.MatchDTO;
import com.gulag.entity.MatchEntity;
import com.gulag.facades.MatchFacade;
import com.gulag.mapper.MatchMapper;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigInteger;

@RestController
@RequestMapping("/matches")
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@RequiredArgsConstructor
public class MatchController {

    MatchFacade matchFacade;
    MatchMapper matchMapper;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/fetch")
    public MatchDTO addMatchResultById(
            @RequestParam BigInteger codMatchId,
            @RequestParam Long tournamentId) {

        MatchEntity matchEntity = matchFacade.addMatchToGulag(codMatchId, tournamentId);
        return matchMapper.mapToDTO(matchEntity);
    }
}


