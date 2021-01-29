package com.gulag.dto;

import com.gulag.enums.TournamentRole;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.Date;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TournamentDTO {

    Long id;
    TournamentRole status;
    Date tournamentDate;
    String title;
}
