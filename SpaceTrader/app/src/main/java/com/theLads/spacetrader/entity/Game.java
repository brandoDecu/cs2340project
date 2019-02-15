package com.theLads.spacetrader.entity;

public class Game {

    private GameDifficulty difficulty;
    private Player player;
    private int gameId;

    /*
    Constructor for Game
     */
    public Game(GameDifficulty difficulty, Player player) {
        this.difficulty = difficulty;
        this.player = player;
    }



    /* Getter for ID */
    public int getGameId() { return gameId; }

    // We need to make the ID based on the username
    public void setGameId(int id) {this.gameId = id; }


    /* Getter for difficulty */
    public GameDifficulty getDifficulty() {
        return difficulty;
    }

    /* Getter for player */
    public Player getPlayer() {
        return player;
    }

}
