package com.gulag.repos;

import com.gulag.entity.TournamentRegistration;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TournamentRegistrationRepository extends JpaRepository<TournamentRegistration, Long> {

    List<TournamentRegistration> findAllByTournamentId(Long tournamentId);

    Optional<Integer> deleteByUserId(Long userId);

    Optional<TournamentRegistration> findTournamentRegistrationByUserIdAndTournamentId
            (Long userId, Long tournamentId);
}
