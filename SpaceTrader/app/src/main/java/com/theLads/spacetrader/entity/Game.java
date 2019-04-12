package com.theLads.spacetrader.entity;

import com.theLads.spacetrader.entity.enums.GameDifficulty;
import com.theLads.spacetrader.entity.enums.ItemType;

import java.io.Serializable;
import java.util.List;

public class Game implements Serializable {

    private final GameDifficulty difficulty;
    private final Player player;
    private int gameId;
    private final Galaxy galaxy;

    /**
     * Game constructor
     * @param difficulty difficulty of game set by player
     * @param player player that the game will use
     * @param galaxy galaxy that the game will use
     */
    public Game(GameDifficulty difficulty, Player player, Galaxy galaxy) {
        this.galaxy = galaxy;
        this.difficulty = difficulty;
        this.player = player;
    }

    /**
     * getter method that returns game ID
     * @return gameID
     */
    public int getGameId() { return gameId; }

    /**
     * getter method that returns the galaxy
     * @return galaxy
     */
    public Galaxy getGalaxy() { return galaxy; }

    /**
     * getter method that returns the difficulty
     * @return difficulty
     */
    public GameDifficulty getDifficulty() { return difficulty; }

    /**
     * setter method to set game ID
     * @param id game id
     */
    public void setGameId(int id) {
        this.gameId = id;
    }

    /**
    Getter method for player
     */
    public Player getPlayer() {
        return player;
    }
    /**
    Getter method for planet name
     */
    public String getPlanetName() {return galaxy.getPlanetName();}

    /**
     * Getter method for player name
     * @return name of player
     */
    public String getPlayerName() {return player.getName();}

    /**
    Getter method for cargo quantities on player's ship
     */
    public List<Integer> getCargoQuantities() {
        return player.getCargoQuantities();
    }

    /**
    Getter method for planet market prices
     */
    public List<Double> getMarketPrices() {
        return galaxy.getMarketPrices();
    }

    /**
    Getter method for quantities of items in markets
     */
    public List<Integer> getMarketQuantities() {
        return galaxy.getMarketQuantities();
    }

    /**
     * Buying method to buy items from a market place
     * @param item item to buy
     * @param quantity quantity of item to buy
     * @param price price of item being bought
     */
    public void buyItem(ItemType item, int quantity, double price) {
        galaxy.buyItem(item, quantity);
        player.buyItem(item, quantity, price);
    }

    /**
     * method to sell items to market place
     * @param item item to sell
     * @param quantity quantity of item to sell
     * @param price price of item being sold
     */
    public void sellItem(ItemType item, int quantity, double price) {
        galaxy.sellItem(item, quantity);
        player.sellItem(item, quantity, price);
    }

    /**
     * getter method for credits
     * @return credits
     */
    public double getCredits() {return player.getCredits();}

    /**
     * getter method for solar system list in game
     * @return list of solar systems
     */
    public List<SolarSystem> getSolarSystems() {return galaxy.getSolarSystems();}

    /**
     * getter method that returns list of solar system names
     * @return list of solar system names
     */
    public List<String> getSolarSystemNames() {return galaxy.getSolarSystemNames();}

    /**
     * getter method that returns a list of solar system distances to other solar systems
     * @return list of distances to other solar systems from current solar system
     */
    public List<Integer> getSolarSystemDistances() {return galaxy.getDistances();}

    /**
     * method to travel to another solar system
     * @param solarSystem solar system to travel to
     */
    public void travelTo(SolarSystem solarSystem) {
        if (!galaxy.contains(solarSystem)) {
            throw new IllegalArgumentException("SolarSystem: " + solarSystem.getName()
                    + " is not in the galaxy");
        }
        int index = getSolarSystems().indexOf(solarSystem);
        int fuelRequired = getSolarSystemDistances().get(index);
        if (getFuel() < fuelRequired) {
            throw new IllegalArgumentException("You need " + fuelRequired + " fuel to travel here");
        }
        player.useFuel(galaxy.getDistanceTo(solarSystem));
        galaxy.travelTo(solarSystem);
    }

    /**
     * getter method to get a player's current fuel on their ship
     * @return fuel
     */
    public int getFuel() {return player.getFuel();}

    /**
     * getter method for current solar system player is in
     * @return current solar system
     */
    public SolarSystem getCurrentSolarSystem() {return galaxy.getCurrentSolarSystem();}

    /**
     * getter method for getting distance to other solar system
     * @param solarSystem solar system to get to
     * @return distance to other solar system
     */
    public int getDistanceTo(SolarSystem solarSystem) {return galaxy.getDistanceTo(solarSystem);}

}
