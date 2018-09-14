package com.JocDeDaus.Application;

import com.JocDeDaus.Application.DTO.PlayerDTO;
import com.JocDeDaus.Domain.Game;
import com.JocDeDaus.Domain.Player;
import com.JocDeDaus.Persistance.GameRepository;
import com.JocDeDaus.Persistance.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;

@Controller
public class PlayerController {

    @Autowired
    private PlayerRepository playerRepository;

    @Autowired
    private GameRepository gameRepository;

    public PlayerDTO createPlayer(PlayerDTO playerDTO) throws Exception {
        Player player = new Player(playerDTO);
        playerRepository.savePlayer(player);
        return new PlayerDTO(player);
    }

    public List<PlayerDTO> getAllPlayers() throws Exception {
        List<PlayerDTO> playerDTOList = new ArrayList<>();
        for (Player player : playerRepository.getAllPlayers()) {
            player.setGames(gameRepository.getAllGamesByPlayerId(player.getId()));
            player.setWinRate();
            PlayerDTO playerDTO = new PlayerDTO(player);
            playerDTOList.add(playerDTO);
        }
        return playerDTOList;
    }
}
