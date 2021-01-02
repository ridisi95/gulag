package com.gulag.controller;

import com.gulag.entity.Player;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/players")
public class PlayerController {

    @GetMapping
    public List<Player> getCustomers() {

        //@TODO remove hardcode and use DB to get list of players
        List<Player> players = Arrays.asList(
                Player.builder().id(1).nickName("smol").build(),
                Player.builder().id(2).nickName("stasyan").build());
        return players;
    }
}
