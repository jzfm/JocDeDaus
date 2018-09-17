package com.JocDeDaus.API;

import com.JocDeDaus.Application.DTO.GameDTO;
import com.JocDeDaus.Application.GameController;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class GameRestController {

    @Autowired
    GameController controller;

    @PostMapping(value = "/players/{playerId}/games", produces = "application/json;charset=UTF-8")
    public String playerPlays(@PathVariable int playerId, @RequestBody String diceNumber) throws Exception {

        Integer numberPlayerSelect = new Gson().fromJson(diceNumber, Integer.class);

        GameDTO newGame = controller.createGame(playerId, numberPlayerSelect);

        return toJson(newGame);
    }


    @GetMapping(value = "/players/{playerId}/games", produces = "application/json;charset=UTF-8")
    public String getPlayerGameList(@PathVariable int playerId) throws Exception {

        List<GameDTO> games = controller.getAllGamesByPlayerId(playerId);

        return toJson(games);
    }

    private String toJson(Object object){

        Gson gson=new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
        return gson.toJson(object);
    }

    @DeleteMapping(value = "players/{playerId}/games", produces = "application/json;charset=UTF-8")
    public void deleteAllPlayerThrows(@PathVariable int playerId) throws Exception {
        controller.deleteAllGamesByPlayerId(playerId);
    }
}
