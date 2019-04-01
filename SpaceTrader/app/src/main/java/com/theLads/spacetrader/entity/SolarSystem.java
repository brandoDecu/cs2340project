package com.theLads.spacetrader.entity;

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

    public SolarSystem(String name) {
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

    public int getxCoord() {
        return xCoord;
    }

    public int getyCoord() {
        return yCoord;
    }

    public TechLevel getTechLvl() {return planet.getTechLvl();}

    public Resources getResources() {return planet.getResources();}

    public List<Double> getMarketPrices() {
        return planet.getMarketPrices();
    }

    public List<Integer> getMarketQuantities() {
        return planet.getMarketQuantities();
    }

    public void buyItem(ItemType item, int quantity) {
        planet.buyItem(item, quantity);
    }

    public void sellItem(ItemType item, int quantity) {
        planet.sellItem(item, quantity);

    }

    @Override
    public String toString() {
        return String.format("Solar System: %s, Location: (%d, %d)", planet.getName(), xCoord, yCoord);
    }
}
