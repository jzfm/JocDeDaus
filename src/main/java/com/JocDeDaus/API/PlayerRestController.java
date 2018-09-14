package com.JocDeDaus.API;

import com.JocDeDaus.Application.DTO.PlayerDTO;
import com.JocDeDaus.Application.PlayerController;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PlayerRestController {

    @Autowired
    PlayerController controller;

    @PostMapping(value = "/players", produces = "application/json;charset=UTF-8")
    public String registerPlayer(@RequestBody String jPlayer) throws Exception {

        PlayerDTO newPlayer = new Gson().fromJson(jPlayer, PlayerDTO.class);

        PlayerDTO player = controller.createPlayer(newPlayer);

        return toJson(player);
    }

    @GetMapping(value = "/players", produces = "application/json;charset=UTF-8")
    public String playerList() throws Exception {

        List<PlayerDTO> players = controller.getAllPlayers();

        return toJson(players);
    }

    private String toJson(Object object){

        Gson gson=new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
        return gson.toJson(object);
    }
}
