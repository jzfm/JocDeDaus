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

    public List<Game> getAllGamesByPlayerId(int playerId) throws Exception {
        if (playerId <= 0)
            throw new Exception();
        List<Game> gameList = new ArrayList<>();
        for (Game game : games) {
            if (game.getPlayer().getId() == playerId)
                gameList.add(game);
        }
        return gameList;
    }

    public double getPlayerWinRate(int playerId) throws Exception {
        double totalWins = 0;
        List<Game> playerGames = getAllGamesByPlayerId(playerId);
        for (Game game : playerGames) {
            if (game.isWin())
                ++totalWins;
        }
        if (playerGames.size() != 0) {
            return ((totalWins * 100) / playerGames.size());
        }else{
            return  0.00;
        }
    }
}
