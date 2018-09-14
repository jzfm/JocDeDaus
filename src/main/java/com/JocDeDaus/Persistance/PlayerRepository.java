package com.JocDeDaus.Persistance;

import com.JocDeDaus.Domain.Player;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PlayerRepository {

    private static List<Player> players = new ArrayList<>();

    public PlayerRepository(){}

    public void savePlayer(Player player) throws Exception {
        if (player == null)
            throw new Exception();
        if (playerExistByName(player.getName()))
            throw new Exception();

        players.add(player);
    }

    public List<Player> getAllPlayers(){ return players; }

    public Player getPlayerById(int playerId) throws Exception {
        if (playerId <= 0 || !playerExistById(playerId))
            throw new Exception();
        for (Player player : players) {
            if (player.getId() == playerId)
                return player;
        }
        return null;
    }

    public boolean playerExistByName(String name){
        for (Player player : players) {
            if (player.getName().equals(name))
                return true;
        }
        return false;
    }

    public boolean playerExistById(int id){
        for (Player player : players) {
            if (player.getId() == id)
                return true;
        }
        return false;
    }
}
