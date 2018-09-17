package com.JocDeDaus.Application.DTO;

import com.JocDeDaus.Domain.Dice;
import com.JocDeDaus.Domain.Game;
import com.JocDeDaus.Domain.Player;
import com.google.gson.annotations.Expose;

import java.util.List;

public class GameDTO {

    @Expose
    private int id;
    private List<Dice> diceList;
    @Expose
    private boolean win;
    private Player player;
    private List<Integer> diceResults;
    @Expose
    private String playerName;
    @Expose
    private String diceResultsExpose;
    @Expose
    private double winRate;


    public GameDTO(){}

    public GameDTO(Game game) throws Exception {
        if (game == null)
            throw new Exception();

        this.id = game.getId();
        this.diceList = game.getDiceList();
        this.win = game.isWin();
        this.player = game.getPlayer();
        this.diceResults = game.getDiceResults();
        this.playerName = game.getPlayer().getName();
        this.diceResultsExpose = game.getDiceResults().toString();
        this.winRate = player.getWinrate();
    }

    public int getId() {
        return id;
    }

    public boolean isWin() {
        return win;
    }

    public Player getPlayer() {
        return player;
    }

    public String getPlayerName() { return playerName; }
}
