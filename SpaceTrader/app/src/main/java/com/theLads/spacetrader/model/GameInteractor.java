package com.theLads.spacetrader.model;

import com.theLads.spacetrader.entity.Game;
import com.theLads.spacetrader.entity.Player;
import com.theLads.spacetrader.entity.SolarSystem;
import com.theLads.spacetrader.entity.enums.ItemType;

import java.util.List;


/**
 * Class for the GameInteractor
 */
public class GameInteractor {

    private final Repository myRepository;

    /**
     * GameInteractor constructor
     * @param repo the repository that this GameInteractor relies on
     */
    GameInteractor(Repository repo) {

        this.myRepository = repo;
    }


    /**
     * Passes Game g to addGame method of Repository
     * @param g the Game to be passed through/used
     */
    public void addGame (Game g) {
        myRepository.addGame(g);
    }

    /**
     * gets the current game from the repository
     * @return the current game
     */
    public Game getCurrentGame() {
        return myRepository.getCurrentGame();
    }


    /**
     * gets the name of the Planet
     * @return the Plane name
     */
    public String getPlanetName() {return getCurrentGame().getPlanetName();}


    public String getPlayerName() {return getCurrentGame().getPlayerName();}


    /**
     * sets the amount of credits a player has
     * @param credits the amount of credits to set a player's wealth to
     */
    public void setCredits(double credits) {
        Player player = getCurrentGame().getPlayer();
        player.setCredits(credits);
    }


    /**
     * gets the quantities of each item in cargo in the form of a List
     * @return a List of quantities of the items in the cargo
     */
    public List<Integer> getCargoQuantities() {
        return getCurrentGame().getCargoQuantities();
    }

    /**
     * gets the prices of each item in the store in the form of a List
     * @return a List of prices of the items in the store
     */
    public List<Double> getMarketPrices() {
        return getCurrentGame().getMarketPrices();
    }

    /**
     * gets the quantities of each item in the store in the form of a List
     * @return a List of quantities of the items in the store
     */
    public List<Integer> getMarketQuantities() {
        return getCurrentGame().getMarketQuantities();
    }

    /**
     * passes on the parameters to Game.buyItem
     * @param item      the ItemType that is desired
     * @param quantity  the quanitity desired
     * @param price     the price per item
     */
    public void buyItem(ItemType item, int quantity, double price) {
        getCurrentGame().buyItem(item, quantity, price);
    }

    /**
     * passes on the parameters to Game.sellItem
     * @param item      the ItemType that is being sold
     * @param quantity  the quanitity sold
     * @param price     the price per item
     */
    public void sellItem(ItemType item, int quantity, double price) {
        getCurrentGame().sellItem(item, quantity, price);
    }

    /**
     * gets the amount of credits that a player has
     * @return the amount of credits a player has
     */
    public double getCredits() {return getCurrentGame().getCredits();}

    /**
     * gets a list of the available SolarSystems
     * @return a list of the available SolarSystems
     */
    public List<SolarSystem> getSolarSystems() {return getCurrentGame().getSolarSystems();}

    /**
     * gets a list of the available SolarSystems names
     * @return a list of the available SolarSystems names
     */
    public List<String> getSolarSystemNames() {return getCurrentGame().getSolarSystemNames();}

    /**
     * gets a list of the available SolarSystems distances
     * @return a list of the available SolarSystems distances
     */
    public List<Integer> getSolarSystemDistances() {
        return getCurrentGame().getSolarSystemDistances();
    }

    /**
     * used when player travels to another SolarSystem
     * @param solarSystem the SolarSystem that the player wants to travel to
     */
    public void travelTo(SolarSystem solarSystem) {
        getCurrentGame().travelTo(solarSystem);
    }

    /**
     * gets the amount of fuel in the player's inventory
     * @return the amount of fel in the player's inventory
     */
    public int getFuel() {return getCurrentGame().getFuel();}

    /**
     * gets the current SolarSystem that the player is in
     * @return current SolarSystem
     */
    public SolarSystem getCurrentSolarSystem() {return getCurrentGame().getCurrentSolarSystem();}

    /**
     * gets the distance from current SolarSystem to another
     * @param solarSystem SolarSystem used to calculate distance from current SolarSystem
     * @return the distance between the solarSystem and the current one
     */
    public int getDistanceTo(SolarSystem solarSystem) {
        return getCurrentGame().getDistanceTo(solarSystem);
    }

    public void setFuel(int fuel) {
        getCurrentGame().getPlayer().setFuel(fuel);
    }

}

