package com.theLads.spacetrader.entity;

public class Game {
    private GameDifficulty difficulty;

    /*
    Constructor for Game
     */
    public Game(GameDifficulty difficulty) {
        this.difficulty = difficulty;
    }

    /*
    Getter for difficulty
     */
    public GameDifficulty getDifficulty() {
        return difficulty;
    }
}
