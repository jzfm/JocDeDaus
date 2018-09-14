package com.JocDeDaus.Domain;

public class Game {

    private int id;
    private Dice dice1, dice2;
    private boolean win;
    private Player player;
    private static int COUNTER=1;

    public Game(){}

    public Game(Player player) throws Exception {
        if (player == null)
            throw new Exception();

        dice1= new Dice();
        dice2 = new Dice();
        this.player = player;
        this.id = COUNTER;

        if (dice1.getResult() + dice2.getResult() == 7){
            win = true;
        }else{
            win = false;
        }
        ++COUNTER;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Dice getDice1() {
        return dice1;
    }

    public void setDice1(Dice dice1) {
        this.dice1 = dice1;
    }

    public Dice getDice2() {
        return dice2;
    }

    public void setDice2(Dice dice2) {
        this.dice2 = dice2;
    }

    public boolean isWin() {
        return win;
    }

    public void setWin(boolean win) {
        this.win = win;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }
}
