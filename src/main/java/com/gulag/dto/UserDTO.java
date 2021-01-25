package com.gulag.dto;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserDTO {

    Long id;
    String username;
    String password;
    String email;
    String unoTag;
    Integer numberOfWins;
    Integer numberOfAppearances;

}
