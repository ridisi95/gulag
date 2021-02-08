package com.gulag.dto;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class MatchDTO {

    long id;

    BigInteger actiMatchId;

    TournamentDTO tournament;

    Date startMatch;

    Date endMatch;

    int duration;

    String mode;

    String map;

    String gameType;

    short playerCount;

    List<PlayerDTO> players;
}
