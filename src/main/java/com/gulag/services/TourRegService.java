package com.gulag.services;

import com.gulag.entity.TourRegEntity;

import java.util.List;

public interface TourRegService {

    List<TourRegEntity> findAllByTournamentId(Long tournamentId);

    TourRegEntity registerOnTournament(TourRegEntity registration);

    List<TourRegEntity> findAll();

    void deleteRegistration(Long userId, Long tournamentId);
}
