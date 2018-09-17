package com.JocDeDaus.Application;

import com.JocDeDaus.Application.DTO.GameDTO;
import com.JocDeDaus.Domain.Game;
import com.JocDeDaus.Domain.Player;
import com.JocDeDaus.Persistance.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;

@Controller
public class GameController {

    @Autowired
    PlayerRepository playerRepository;

    private GameDTO createGame(Player player, int diceNumber) throws Exception {
        Game game = new Game(diceNumber);
        playerRepository.saveGame(player, game);
        return new GameDTO(game);
    }

    public List<GameDTO> getAllGamesByPlayerId(int playerId) throws Exception {
        List<GameDTO> gameDTOList = new ArrayList<>();
        Player player = playerRepository.getPlayerById(playerId);
        for (Game game : player.getGames()) {
            GameDTO gameDTO = new GameDTO(game);
            gameDTOList.add(gameDTO);
        }
        return gameDTOList;
    }

    public GameDTO playerPlays(int playerId, int diceNumber) throws Exception {
        Player player = playerRepository.getPlayerById(playerId);
        GameDTO game = createGame(player, diceNumber);
        player.setWinRate();
        return game;
    }

    public void deleteAllGamesByPlayerId(int playerId) throws Exception {
        Player player = playerRepository.getPlayerById(playerId);
        playerRepository.deleteAllGamesByPlayerId(playerId);
        player.setWinRate();
    }
}
