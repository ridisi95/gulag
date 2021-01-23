package com.gulag.entity.dto;

import com.gulag.entity.UserEntity;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserDto {

    Long id;
    String username;
    String email;
    String unoTag;
    Integer numberOfWins;
    Integer numberOfAppearances;

    public UserDto(UserEntity user) {
        this.id = user.getId();
        this.username = user.getUsername();
        this.email = user.getEmail();
        this.unoTag = user.getUnoTag();
        this.numberOfWins = user.getNumberOfWins();
        this.numberOfAppearances = user.getNumberOfAppearances();
    }
}
