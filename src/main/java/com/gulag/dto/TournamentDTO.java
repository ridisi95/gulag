package com.gulag.dto;

import com.gulag.enums.TournamentStatus;
import com.gulag.validation.marker.OnCreate;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.Date;
import java.util.Set;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TournamentDTO {

    @Null(groups = OnCreate.class)
    Long id;

    @Null(groups = OnCreate.class)
    TournamentStatus status;

    @NotNull
    Date tournamentDate;

    @NotNull
    String title;

    @Null(groups = OnCreate.class)
    Set<MatchDTO> matchEntityList;

    Set<UserDTO> users;
}
