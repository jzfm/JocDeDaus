package com.JocDeDaus.Application;

import com.JocDeDaus.Application.DTO.GameDTO;
import com.JocDeDaus.Domain.Game;
import com.JocDeDaus.Domain.Player;
import com.JocDeDaus.Persistance.GameRepository;
import com.JocDeDaus.Persistance.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;

@Controller
public class GameController {

    @Autowired
    GameRepository gameRepository;

    @Autowired
    PlayerRepository playerRepository;

    public GameDTO createGame(int playerId) throws Exception {
        Player player = playerRepository.getPlayerById(playerId);
        Game game = new Game(player);
        gameRepository.saveGame(game);
        return new GameDTO(game);
    }

    public List<GameDTO> getAllGamesByPlayerId(int playerId) throws Exception {
        List<GameDTO> gameDTOList = new ArrayList<>();
        for (Game game : gameRepository.getAllGamesByPlayerId(playerId)) {
            GameDTO gameDTO = new GameDTO(game);
            gameDTOList.add(gameDTO);
        }
        return gameDTOList;
    }
}
