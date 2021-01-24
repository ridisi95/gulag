package com.gulag.dto;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TournamentRegistrationDto {

    Long id;
    Long tournamentId;
    UserDto user;
}
