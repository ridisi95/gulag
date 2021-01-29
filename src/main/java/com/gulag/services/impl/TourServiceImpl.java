package com.gulag.services.impl;

import com.gulag.entity.TournamentEntity;
import com.gulag.enums.TournamentStatus;
import com.gulag.repos.TourRepository;
import com.gulag.services.TournamentService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class TourServiceImpl implements TournamentService {

    TourRepository tourRepository;

    @Override
    public TournamentEntity saveTournament(TournamentEntity tournamentEntity) {
        return tourRepository.save(tournamentEntity);
    }

    @Override
    public List<TournamentEntity> findAllTournaments() {
        return tourRepository.findAll();
    }

    @Override
    public TournamentEntity findById(Long tournamentId) {
        return tourRepository.findById(tournamentId).orElseThrow(IllegalArgumentException::new);
    }

    @Override
    public TournamentEntity updateStatusOfTournament(Long tournamentId, TournamentStatus status) {
        TournamentEntity tournamentById = findById(tournamentId);
        tournamentById.setStatus(status);
        return saveTournament(tournamentById);
    }
}
