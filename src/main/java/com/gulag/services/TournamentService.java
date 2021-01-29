package com.gulag.services;

import com.gulag.entity.TournamentEntity;
import com.gulag.enums.TournamentRole;

import java.util.List;

public interface TournamentService {

    TournamentEntity saveTournament(TournamentEntity tournamentEntity);

    List<TournamentEntity> findAllTournaments();

    TournamentEntity findById(Long tournamentId);

    TournamentEntity updateStatusOfTournament(Long tournamentId, TournamentRole status);

}
