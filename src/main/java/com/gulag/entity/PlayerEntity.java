package com.gulag.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.math.BigInteger;

import static javax.persistence.CascadeType.DETACH;
import static javax.persistence.CascadeType.MERGE;
import static javax.persistence.CascadeType.PERSIST;
import static javax.persistence.CascadeType.REFRESH;

@Getter
@Setter
@Entity
@Table(name = "players")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PlayerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "uno_number")
    BigInteger unoNumber;

    @Column(name = "kills")
    short kills;

    @Column(name = "assists")
    short assists;

    @Column(name = "headshots")
    short headshots;

    @Column(name = "deaths")
    short deaths;

    @Column(name = "kd_ratio")
    float kdRation;

    @Column(name = "score")
    int score;

    @Column(name = "team_survival_time")
    int teamSurvivalTime;

    @Column(name = "team_placement")
    short teamPlacement;

    @Column(name = "damage_done")
    int damageDone;

    @Column(name = "damage_taken")
    int damageTaken;

    @Column(name = "gulag_kills")
    short gulagKills;

    @Column(name = "gulag_deaths")
    short gulagDeaths;

    @ManyToOne(cascade = {PERSIST, MERGE, DETACH, REFRESH})
    @JoinColumn(name = "match_id")
    MatchEntity match;
}
