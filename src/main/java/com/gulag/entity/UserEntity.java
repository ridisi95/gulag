package com.gulag.entity;

import com.gulag.enums.UserRole;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import java.math.BigInteger;
import java.util.Date;

@Data
@Entity
@Table(name = "users")
@NoArgsConstructor
@DynamicInsert
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(unique = true, nullable = false)
    String username;

    @ToString.Exclude
    @Column(nullable = false)
    String password;

    @Enumerated(EnumType.STRING)
    UserRole role;

    @Column(nullable = false)
    String email;

    @Column(nullable = false)
    BigInteger unoNumber;

    @Column(nullable = false)
    String unoTag;

    Integer numberOfWins;

    Integer numberOfAppearances;

    Date registrationDate;

    String firstName;

    String lastName;
}
