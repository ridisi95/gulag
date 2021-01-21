package com.gulag.services;

import com.gulag.entity.TournamentRegistration;
import com.gulag.entity.dto.UserDto;
import com.gulag.repos.TournamentRegistrationRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@Service
public class TournamentRegistrationService {

    private final TournamentRegistrationRepository tour;
    private final UserService userService;

    public List<UserDto> findAllUsersByTournamentId(Long tournamentId) {
        List<TournamentRegistration> allUserIdByTournamentId = tour.findAllByTournamentId(tournamentId);
        List<UserDto> users = new ArrayList<>();
        for (TournamentRegistration temp : allUserIdByTournamentId) {
            users.add(new UserDto(userService.findByUserId(temp.getUserId())));
        }
        return users;
    }

    public TournamentRegistration registerTournament(TournamentRegistration registration) {
        if (registration != null) {
            Optional<TournamentRegistration> temp =
                    tour.findTournamentRegistrationByUserIdAndTournamentId(registration.getUserId(),
                            registration.getTournamentId());
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
