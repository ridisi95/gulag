package com.gulag.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.math.BigInteger;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Null;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;

@Data
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserDTO {

    static final String NAME_REGEXP = "^(?=.{1,255}$)([A-Za-z]+)$";

    @Null
    Long id;

    @NotBlank
    @Pattern(regexp = "^(?=.{3,20}$)(?![_.])(?!.*[_.]{2})[a-zA-Z0-9._]+(?<![_.])$", message = "{error.field}")
    String username;

    @NotBlank
    @Pattern(regexp = "^\\$2a\\$10\\$\\S+$", message = "{error.field.password}")
    String password;

    @NotBlank
    @Email()
    String email;

    @Positive
    BigInteger unoNumber;

    @NotBlank
    @Pattern(regexp = "^(?=.{5,20}$)(?![_.])(?!.*[_.]{2})\\w+#+\\d+(?<![_.])$", message = "{error.field.unoTag}")
    String unoTag;

    @Null
    Integer numberOfWins;

    @Null
    Integer numberOfAppearances;

    @Pattern(regexp = NAME_REGEXP, message = "{error.field}")
    String firstName;

    @Pattern(regexp = NAME_REGEXP, message = "{error.field}")
    String lastName;
}
