package com.gulag.facades.impl;

import com.gulag.entity.MatchEntity;
import com.gulag.facades.MatchFacade;
import com.gulag.services.MatchService;
import com.gulag.services.TournamentService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.math.BigInteger;

@Service
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@RequiredArgsConstructor
public class MatchFacadeImpl implements MatchFacade {

    MatchService matchService;
    TournamentService tournamentService;

    @Override
    public MatchEntity addMatchToGulag(BigInteger id, Long tournamentId) {

        MatchEntity match = matchService.fetchMatchFromCod(id);
        match.setTournament(tournamentService.findById(tournamentId));
        return matchService.save(match);
    }
}
