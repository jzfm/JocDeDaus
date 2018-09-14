package com.JocDeDaus.Persistance;

import com.JocDeDaus.Domain.Game;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class GameRepository {

    private static List<Game> games = new ArrayList<>();

    GameRepository(){}

    public void saveGame(Game game) throws Exception {
        if (game == null)
            throw new Exception();

        games.add(game);
    }

    public List<Game> getAllGamesByPlayerId(int playerId){
        List<Game> gameList = new ArrayList<>();
        for (Game game : games) {
            if (game.getPlayer().getId() == playerId)
                gameList.add(game);
        }
        return gameList;
    }
}
