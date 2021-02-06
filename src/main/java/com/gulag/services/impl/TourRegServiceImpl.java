package com.gulag.services.impl;

import com.gulag.entity.TourRegEntity;
import com.gulag.enums.TournamentStatus;
import com.gulag.repos.TourRegRepository;
import com.gulag.services.TourRegService;
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
public class TourRegServiceImpl implements TourRegService {

    TourRegRepository tourRegRepository;

    public List<TourRegEntity> findAllByTournamentId(Long tournamentId) {
        return tourRegRepository.findAllByTournamentId(tournamentId);
    }

    public TourRegEntity registerOnTournament(TourRegEntity registration) {
        log.info("In Service: {}", registration);
        return tourRegRepository.save(registration);
    }

    public List<TourRegEntity> findAll() {
        return tourRegRepository.findAll();
    }

    public void deleteRegistration(Long userId, Long tournamentId) {
        tourRegRepository.delete(tourRegRepository.findTournamentRegistrationByUserIdAndTournamentId(userId, tournamentId));
    }

    @Override
    public List<TourRegEntity> findAllTourRegByUserAndStatus(Long userId, TournamentStatus status) {
        return tourRegRepository.findAllByUser_IdAndTournament_Status(userId, status);
    }

    @Override
    public List<TourRegEntity> findAllTourRegByUser(Long userId) {
        return tourRegRepository.findAllByUser_Id(userId);
    }
}
