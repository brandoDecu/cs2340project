package com.theLads.spacetrader.model;

import android.util.Log;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.theLads.spacetrader.entity.Game;
import com.theLads.spacetrader.entity.Player;
import com.theLads.spacetrader.entity.SolarSystem;
import com.theLads.spacetrader.entity.enums.ItemType;

/**
 * This class is an abstraction of the data storage for the business classes
 * Normally this would pass through to our ROOM (database) objects.   To keep this assignment
 * simple, we are just using in-memory storage
 */
class Repository implements Serializable {

    /***
     * This provides a mechanism to generate simple unique numbers to be used as
     * keys in the application
     */
    private static int next_id = 1;

    /**
     * Gives each new instance a unique ID
     * @return the unique ID
     */
    private static int getNextUniqueID() {
        int result = next_id;
        next_id++;
        return result;
    }

    private Game currentGame;


    /** all the Games known in the application */
    private final List<Game> allGames;

    /**
     * Make a new Repository object
     */
    public Repository() {
        allGames = new ArrayList<>();
    }


    /**
     * get all the games in the system
     * @return list of all students
     */
    public List<Game> getAllGames() { return Collections.unmodifiableList(allGames);}

    /**
     * get current game in system
     * @return current game
     */
    public Game getCurrentGame(){
        return currentGame;
    }

    /** add a new player to the system
     *
     * @param g the game to add
     */
    public void addGame(Game g) {
        g.setGameId(Repository.getNextUniqueID());
        currentGame = g;
        allGames.add(g);
    }




    /**
     * Updates the values stored in a Game. This is useless right now
     * @param g the game to update
     */
    @SuppressWarnings("FeatureEnvy")
    public void updateGame(Game g) {
        for (Game game: allGames) {
            if (game.getGameId() == g.getGameId()) {
                Player player = game.getPlayer();
                Player p = g.getPlayer();
                player.setName(p.getName());
                player.setFighterSkill(p.getFighterSkill());
                player.setPilotSkill(p.getPilotSkill());
                player.setTraderSkill(p.getTraderSkill());
                player.setEngineerSkill(p.getEngineerSkill());
                player.setCredits(p.getCredits());
                player.setShip(p.getShip());
                return;
            }
        }
        Log.d("APP", "Game not found with id = " + g.getGameId());
    }
    

    /**
     * gets the name of the Planet
     * @return the Plane name
     */
    public String getPlanetName() {return currentGame.getPlanetName();}


    public String getPlayerName() {return currentGame.getPlayerName();}


    /**
     * sets the amount of credits a player has
     * @param credits the amount of credits to set a player's wealth to
     */
    public void setCredits(double credits) {
        Player player = currentGame.getPlayer();
        player.setCredits(credits);
    }

    /**
     * gets the quantities of each item in cargo in the form of a List
     * @return a List of quantities of the items in the cargo
     */
    public List<Integer> getCargoQuantities() {
        return currentGame.getCargoQuantities();
    }

    /**
     * gets the prices of each item in the store in the form of a List
     * @return a List of prices of the items in the store
     */
    public List<Double> getMarketPrices() {
        return currentGame.getMarketPrices();
    }

    /**
     * gets the quantities of each item in the store in the form of a List
     * @return a List of quantities of the items in the store
     */
    public List<Integer> getMarketQuantities() {
        return currentGame.getMarketQuantities();
    }

    /**
     * passes on the parameters to Game.buyItem
     * @param item      the ItemType that is desired
     * @param quantity  the quanitity desired
     * @param price     the price per item
     */
    public void buyItem(ItemType item, int quantity, double price) {
        currentGame.buyItem(item, quantity, price);
    }

    /**
     * passes on the parameters to Game.sellItem
     * @param item      the ItemType that is being sold
     * @param quantity  the quanitity sold
     * @param price     the price per item
     */
    public void sellItem(ItemType item, int quantity, double price) {
        currentGame.sellItem(item, quantity, price);
    }

    /**
     * gets the amount of credits that a player has
     * @return the amount of credits a player has
     */
    public double getCredits() {return currentGame.getCredits();}

    /**
     * gets a list of the available SolarSystems
     * @return a list of the available SolarSystems
     */
    public List<SolarSystem> getSolarSystems() {return currentGame.getSolarSystems();}

    /**
     * gets a list of the available SolarSystems names
     * @return a list of the available SolarSystems names
     */
    public List<String> getSolarSystemNames() {return currentGame.getSolarSystemNames();}

    /**
     * gets a list of the available SolarSystems distances
     * @return a list of the available SolarSystems distances
     */
    public List<Integer> getSolarSystemDistances() {return currentGame.getSolarSystemDistances();}

    /**
     * used when player travels to another SolarSystem
     * @param solarSystem the SolarSystem that the player wants to travel to
     */
    public void travelTo(SolarSystem solarSystem) {
        currentGame.travelTo(solarSystem);
    }

    /**
     * gets the amount of fuel in the player's inventory
     * @return the amount of fel in the player's inventory
     */
    public int getFuel() {return currentGame.getFuel();}

    /**
     * gets the current SolarSystem that the player is in
     * @return current SolarSystem
     */
    public SolarSystem getCurrentSolarSystem() {return currentGame.getCurrentSolarSystem();}

    /**
     * gets the distance from current SolarSystem to another
     * @param solarSystem SolarSystem used to calculate distance from current SolarSystem
     * @return the distance between the solarSystem and the current one
     */
    public int getDistanceTo(SolarSystem solarSystem) {return currentGame.getDistanceTo(solarSystem);}


}
