package com.gulag.controller;

import com.gulag.entity.PlayerEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/players")
public class PlayerController {

    @GetMapping
    public List<PlayerEntity> getCustomers() {

        //@TODO remove hardcode and use DB to get list of players
        List<PlayerEntity> players = Arrays.asList(
                PlayerEntity.builder().id(1).nickName("smol").build(),
                PlayerEntity.builder().id(2).nickName("stasyan").build());
        return players;
    }
}
