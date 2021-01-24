package com.gulag.services;

import com.gulag.entity.TournamentRegistration;
import com.gulag.repos.TournamentRegistrationRepository;
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
public class TournamentRegistrationService {

    TournamentRegistrationRepository tour;

    public List<TournamentRegistration> findAllByTournamentId(Long tournamentId) {
        return tour.findAllByTournamentId(tournamentId);
    }

    public TournamentRegistration registerTournament(TournamentRegistration registration) {
        if (registration != null) {
            Optional<TournamentRegistration> temp =
                    tour.findTournamentRegistrationByUserIdAndTournamentId(
                            registration.getUser().getId(), registration.getTournamentId());
            if (temp.isEmpty()) {
                return tour.save(registration);
            }
        }
        return null;
    }

    public Optional<TournamentRegistration> findById(Long registerId) {
        return tour.findById(registerId);
    }

    public List<TournamentRegistration> findAll() {
        return tour.findAll();
    }

    public boolean deleteRegistration(Long userId, Long tournamentId) {
        Optional<TournamentRegistration> tournament
                = tour.findTournamentRegistrationByUserIdAndTournamentId(userId, tournamentId);
        if (tournament.isPresent()) {
            tour.delete(tournament.get());
        } else {
            return false;
        }
        return findById(tournament.get().getId()).isEmpty();
    }
}
