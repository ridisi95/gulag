package com.gulag.services;

import com.gulag.entity.TourRegEntity;
import com.gulag.enums.TournamentStatus;

import java.util.List;

public interface TourRegService {

    List<TourRegEntity> findAllByTournamentId(Long tournamentId);

    TourRegEntity registerOnTournament(TourRegEntity registration);

    TourRegEntity registerOnTournament(Long TournamentId, Long UserId);

    //TODO useless method should be removed
    @Deprecated
    List<TourRegEntity> findAll();

    void deleteRegistration(Long userId, Long tournamentId);

    List<TourRegEntity> findAllTourRegByUserAndStatus(Long userId, TournamentStatus status);

    List<TourRegEntity> findAllTourRegByUser(Long userId);
}
