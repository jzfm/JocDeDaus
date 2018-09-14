package com.JocDeDaus.Application.DTO;

import com.JocDeDaus.Domain.Dice;
import com.JocDeDaus.Domain.Game;
import com.JocDeDaus.Domain.Player;
import com.google.gson.annotations.Expose;

public class GameDTO {

    @Expose
    private int id;
    private Dice dice1, dice2;
    @Expose
    private boolean win;
    private Player player;
    @Expose
    private int results;
    @Expose
    private String playerName;


    public GameDTO(){}

    public GameDTO(Game game) throws Exception {
        if (game == null)
            throw new Exception();

        this.id = game.getId();
        this.dice1 = game.getDice1();
        this.dice2 = game.getDice2();
        this.win = game.isWin();
        this.player = game.getPlayer();
        this.results = game.getDice1().getResult() + game.getDice2().getResult();
        this.playerName = game.getPlayer().getName();
    }

    public int getId() {
        return id;
    }

    public Dice getDice1() {
        return dice1;
    }

    public Dice getDice2() {
        return dice2;
    }

    public boolean isWin() {
        return win;
    }

    public Player getPlayer() {
        return player;
    }

    public int getResults() { return results; }

    public String getPlayerName() { return playerName; }
}
