package com.gulag.services.impl;

import com.gulag.entity.TournamentEntity;
import com.gulag.exception.DataNotFoundException;
import com.gulag.mapper.TourEntityDTOMapper;
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
    TourEntityDTOMapper tourEntityDTOMapper;

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
        return tourRepository.findById(tournamentId).orElseThrow(DataNotFoundException::new);
    }

    @Override
    public TournamentEntity updateStatusOfTournament(TournamentEntity input) {
        TournamentEntity output = findById(input.getId());
        tourEntityDTOMapper.mapToEntity(input, output);
        return saveTournament(output);
    }
}
