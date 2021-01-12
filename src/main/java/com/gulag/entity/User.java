package com.gulag.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity(name = "usrs")
public class User {

    public User() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String username;
    private String password;
    private String roleName;

}
