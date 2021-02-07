package com.gulag.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.math.BigInteger;
import java.util.Map;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@JsonIgnoreProperties(ignoreUnknown = true)
public class CodPlayerDTO {

    BigInteger uno;

    BigInteger matchID;

    String username;

    short kills;

    short assists;

    short headshots;

    short deaths;

    short kdRatio;

    int score;

    int teamSurvivalTime;

    int teamPlacement;

    int damageDone;

    int damageTaken;

    short gulagKills;

    short gulagDeaths;

    @JsonProperty("player")
    private void unpackPlayer(Map<String, Object> player) {
        uno = new BigInteger((String)player.get("uno"));
        username = (String)player.get("username");
    }

    @JsonProperty("playerStats")
    private void unpackPlayerStats(Map<String, String> playerStats) {
        kills = (short)Float.parseFloat(playerStats.get("kills"));
        assists = (short)Float.parseFloat(playerStats.get("assists"));
        headshots = (short)Float.parseFloat(playerStats.get("headshots"));
        deaths = (short)Float.parseFloat(playerStats.get("deaths"));
        kdRatio = (short)Float.parseFloat(playerStats.get("kdRatio"));
        score = (int)Float.parseFloat(playerStats.get("score"));
        teamSurvivalTime = (int)Float.parseFloat(playerStats.get("teamSurvivalTime"));
        teamPlacement = (int)Float.parseFloat(playerStats.get("teamPlacement"));
        damageDone = (int)Float.parseFloat(playerStats.get("damageDone"));
        damageTaken = (int)Float.parseFloat(playerStats.get("damageTaken"));
        gulagKills = (short)Float.parseFloat(playerStats.get("gulagKills"));
        gulagDeaths = (short)Float.parseFloat(playerStats.get("gulagDeaths"));
    }

}
