package com.gulag.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.math.BigInteger;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;

@Data
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserDTO {

    static final String NAME_REGEXP = "^(?=.{1,255}$)([A-Za-z]+)$";

    Long id;

    @NotBlank
    @Pattern(regexp = "^(?=.{3,20}$)(?![_.])(?!.*[_.]{2})[a-zA-Z0-9._]+(?<![_.])$")
    String username;

    @NotBlank
    @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,}$")
    String password;

    @NotBlank
    @Email(message = "invalid email")
    String email;

    @Positive
    BigInteger unoNumber;

    @NotBlank
    @Pattern(regexp = "^(?=.{5,20}$)(?![_.])(?!.*[_.]{2})\\w+#+\\d+(?<![_.])$")
    String unoTag;

    @PositiveOrZero
    Integer numberOfWins;

    @PositiveOrZero
    Integer numberOfAppearances;

    @Pattern(regexp = NAME_REGEXP)
    String firstName;

    @Pattern(regexp = NAME_REGEXP)
    String lastName;
}
