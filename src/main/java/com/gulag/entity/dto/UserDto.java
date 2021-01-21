package com.gulag.entity.dto;

import com.gulag.entity.UserEntity;
import lombok.Data;

@Data
public class UserDto {

    private Long id;
    private String username;
    private String email;
    private String unoTag;
    private Integer numberOfWins;
    private Integer numberOfAppearances;

    public UserDto(UserEntity user) {
        this.id = user.getId();
        this.username = user.getUsername();
        this.email = user.getEmail();
        this.unoTag = user.getUnoTag();
        this.numberOfWins = user.getNumberOfWins();
        this.numberOfAppearances = user.getNumberOfAppearances();
    }
}
