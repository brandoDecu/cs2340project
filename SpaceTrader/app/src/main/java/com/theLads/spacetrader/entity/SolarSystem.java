package com.theLads.spacetrader.entity;

import android.annotation.SuppressLint;

import com.theLads.spacetrader.entity.enums.ItemType;
import com.theLads.spacetrader.entity.enums.Resources;
import com.theLads.spacetrader.entity.enums.TechLevel;

import java.io.Serializable;
import java.util.List;


public class SolarSystem implements Serializable {

    private final Planet planet;

    private final int xCoord;

    private final int yCoord;

    /**
     * Solar system constructor that builds a solar system for the game
     * @param name Name of the solar system to be created; creates a planet with the same name
     */

    SolarSystem(String name) {
        this.planet = new Planet(name);

        this.xCoord = (int) (Math.random() * 100);
        this.yCoord = (int) (Math.random() * 150);
    }

    /**
     * Getter method for the name of solar system
     * @return String
     */
    public String getName() {
        return planet.getName();
    }

    /**
     * getter method for x coordinate of solar system
     * @return x coordinate of solar system
     */
    int getxCoord() {
        return xCoord;
    }

    /**
     * getter method for y coordinate of solar system
     * @return y coordinate of solar system
     */
    int getyCoord() {
        return yCoord;
    }

    /**
     * getter method for tech level of planet
     * @return tech level of planet
     */
    public TechLevel getTechLvl() {return planet.getTechLvl();}

    /**
     * getter method for resource level of planet
     * @return resource level of planet
     */
    public Resources getResources() {return planet.getResources();}

    /**
     * getter method for market prices on a planet
     * @return market prices
     */
    List<Double> getMarketPrices() {
        return planet.getMarketPrices();
    }

    /**
     * getter method for market quantities of items
     * @return market quantities of items on a planet
     */
    List<Integer> getMarketQuantities() {
        return planet.getMarketQuantities();
    }

    /**
     * buy method to buy items from market
     * @param item item to buy
     * @param quantity quantity of item to buy
     */
    void buyItem(ItemType item, int quantity) {
        planet.buyItem(item, quantity);
    }

    /**
     * sell method to sell items to market
     * @param item item to sell
     * @param quantity quantity of item to sell
     */
    void sellItem(ItemType item, int quantity) {
        planet.sellItem(item, quantity);

    }

    @SuppressWarnings("NullableProblems")
    @SuppressLint("DefaultLocale")
    @Override
    public String toString() {
        return String.format("Solar System: %s, Location: (%d, %d)", planet.getName(), xCoord, yCoord);
    }
}
