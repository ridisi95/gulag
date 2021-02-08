package com.gulag.entity;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;

import static javax.persistence.CascadeType.DETACH;
import static javax.persistence.CascadeType.MERGE;
import static javax.persistence.CascadeType.PERSIST;
import static javax.persistence.CascadeType.REFRESH;

@Data
@Entity
@Table(name = "matches")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class MatchEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "acti_match_id")
    BigInteger actiMatchId;

    @ManyToOne(cascade = {PERSIST, MERGE, DETACH, REFRESH})
    @JoinColumn(name = "tournament_id")
    TournamentEntity tournament;

    @Column(name = "start_match")
    Date startMatch;

    @Column(name = "end_match")
    Date endMatch;

    @Column(name = "duration")
    int duration;

    @Column(name = "mode")
    String mode;

    @Column(name = "map")
    String map;

    @Column(name = "gametype")
    String gameType;

    @Column(name = "playercount")
    short playerCount;

    @OneToMany(mappedBy = "match", cascade = CascadeType.ALL)
    List<PlayerEntity> players;
}

