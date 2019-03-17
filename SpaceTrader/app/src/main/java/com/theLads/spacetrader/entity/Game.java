package com.theLads.spacetrader.entity;

import com.theLads.spacetrader.entity.enums.GameDifficulty;
import com.theLads.spacetrader.entity.enums.ItemType;

import java.util.List;

public class Game {

    private GameDifficulty difficulty;
    private Player player;
    private int gameId;
    private Galaxy galaxy;

    /*
    Constructor for Game
     */
    public Game(GameDifficulty difficulty, Player player, Galaxy galaxy) {
        this.galaxy = galaxy;
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

    public Galaxy getGalaxy() {
        return galaxy;
    }

    public String getPlanetName() {return galaxy.getPlanetName();}

    public List<Integer> getCargoQuantities() {
        return player.getCargoQuantities();
    }

    public List<Double> getMarketPrices() {
        return galaxy.getMarketPrices();
    }

    public List<Integer> getMarketQuantities() {
        return galaxy.getMarketQuantities();
    }

    public void buyItem(ItemType item, int quantity, double price) {
        galaxy.buyItem(item, quantity);
        player.buyItem(item, quantity, price);
    }

    public void sellItem(ItemType item, int quantity, double price) {
        galaxy.sellItem(item, quantity);
        player.sellItem(item, quantity, price);
    }

    public double getCredits() {return player.getCredits();}

    public List<SolarSystem> getSolarSystems() {return galaxy.getSolarSystems();}

    public List<String> getSolarSystemNames() {return galaxy.getSolarSystemNames();}

    public List<Integer> getSolarSystemDistances() {return galaxy.getDistances();}

    public void travelTo(SolarSystem solarSystem) {
        galaxy.travelTo(solarSystem);
    }

    public int getFuel() {return player.getFuel();}

    public SolarSystem getCurrentSolarSystem() {return galaxy.getCurrentSolarSystem();}

    public int getDistanceTo(SolarSystem solarSystem) {return galaxy.getDistanceTo(solarSystem);}


}
