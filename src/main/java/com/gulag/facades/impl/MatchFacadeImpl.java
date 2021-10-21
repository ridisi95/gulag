package com.gulag.facades.impl;

import com.gulag.entity.MatchEntity;
import com.gulag.entity.TournamentEntity;
import com.gulag.facades.MatchFacade;
import com.gulag.services.MatchService;
import com.gulag.services.TournamentService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigInteger;

@Service
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@RequiredArgsConstructor
public class MatchFacadeImpl implements MatchFacade {

    MatchService matchService;
    TournamentService tournamentService;

    @Transactional
    @Override
    public MatchEntity addMatchToGulag(BigInteger id, Long tournamentId) {

        MatchEntity match = matchService.fetchMatchFromCod(id);
        TournamentEntity tournamentEntity = tournamentService.findById(tournamentId);
        tournamentEntity.addMatch(match);
//        tournamentService.saveTournament(tournamentEntity);

        return matchService.save(match);
    }
}
