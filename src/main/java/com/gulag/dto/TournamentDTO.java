package com.gulag.dto;

import com.gulag.enums.TournamentStatus;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.Date;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TournamentDTO {

    Long id;
    TournamentStatus status;
    Date tournamentDate;
    String title;
}
