package com.JocDeDaus.Domain;

import com.JocDeDaus.Application.DTO.PlayerDTO;

import java.util.ArrayList;
import java.util.List;

public class Player {

    private int id;
    private String name;
    private List<Game> games;
    private double winRate;
    private static int COUNTER=1;

    public Player(){}

    public Player(PlayerDTO player) throws Exception {
        if (player == null || player.getName() == null || player.getName().equals(""))
            throw new Exception();

        this.id = COUNTER;
        this.name = player.getName();
        this.games = new ArrayList<>();
        this.winRate = 0.00;
        ++COUNTER;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Game> getGames() {
        return games;
    }

    public void setGames(List<Game> games) {
        this.games = games;
    }

    public double getWinrate() { return winRate; }

    public void setWinRate() {
        List<Game> totalGames = getGames();
        double totalWins = 0;
        for (Game game : totalGames) {
            if (game.isWin())
                ++totalWins;
        }
        if (totalGames.size() != 0) {
            winRate = ((totalWins * 100) / totalGames.size());
        }else{
            winRate = 0.00;
        }
    }
}