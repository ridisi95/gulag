package com.gulag.dto;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.math.BigInteger;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PlayerDTO {

    long id;

    BigInteger unoNumber;

    short kills;

    short assists;

    short headshots;

    short deaths;

    float kdRation;

    int score;

    int teamSurvivalTime;

    short teamPlacement;

    int damageDone;

    int damageTaken;

    short gulagKills;

    short gulagDeaths;
}
