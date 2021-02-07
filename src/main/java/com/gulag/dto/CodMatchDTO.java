package com.gulag.dto;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.math.BigInteger;
import java.util.List;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class CodMatchDTO {

    BigInteger matchID;

    int utcStartSeconds;

    int utcEndSeconds;

    int duration;

    String map;

    String mode;

    String gameType;

    short playerCount;

    List<CodPlayerDTO> allPlayers;

}
