package com.gulag.services;

import com.gulag.entity.TourRegEntity;
import com.gulag.repos.TourRegRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@Service
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class TourRegService {

    TourRegRepository tour;

    public List<TourRegEntity> findAllByTournamentId(Long tournamentId) {
        return tour.findAllByTournamentId(tournamentId);
    }

    public TourRegEntity registerTournament(TourRegEntity registration) {
        log.info("In Service: {}", registration);
        return tour.save(registration);
    }

    public List<TourRegEntity> findAll() {
        return tour.findAll();
    }

    public void deleteRegistration(Long userId, Long tournamentId) {
        tour.delete(tour.findTournamentRegistrationByUserIdAndTournamentId(userId, tournamentId));
    }
}
