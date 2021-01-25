package com.gulag.repos;

import com.gulag.entity.TourRegEntity;
import com.gulag.relationship.TourRegRelationId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TourRegRepository extends JpaRepository<TourRegEntity, TourRegRelationId> {

    List<TourRegEntity> findAllByTournamentId(Long tournamentId);

    Optional<Integer> deleteByUserId(Long userId);

    TourRegEntity findTournamentRegistrationByUserIdAndTournamentId
            (Long userId, Long tournamentId);
}
