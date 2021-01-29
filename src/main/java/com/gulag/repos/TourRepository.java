package com.gulag.repos;

import com.gulag.entity.TournamentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TourRepository extends JpaRepository<TournamentEntity, Long> {
}
