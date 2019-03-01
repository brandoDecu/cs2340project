package com.theLads.spacetrader.entity;

import java.util.LinkedList;

public class SolarSystem {

    private Planet planet;

    private String name;

    private int techLevel;

    private int resourceLevel;

    private int xCoord;

    private int yCoord;

    /**
     * Solar system constructor that builds a solar system for the game
     * @param name Name of the solar system to be created; creates a planet with the same name
     */

    SolarSystem(String name) {
        this.planet = new Planet(name);
        this.name = planet.getName();

        this.xCoord = (int) (Math.random() * 100);
        this.yCoord = (int) (Math.random() * 150);

        techLevel = planet.getTechLvl();
        resourceLevel = planet.getResources();
    }

    /**
     * Getter method for the name of solar system
     * @return String
     */
    public String getName() {
        return name;
    }

    /**
     * Getter method for the tech level of solar system
     * @return int
     */
    public int getTechLevel() {
        return techLevel;
    }

    /**
     * Getter method for the resource level of solar system
     * @return int
     */
    public int getResourceLevel() {
        return resourceLevel;
    }
    @Override
    public String toString() {
        return String.format("Solar System %s, Resource Level: %d, Tech Level: %d, " +
                        "Location: (%d, %d)", name,
                resourceLevel, techLevel, xCoord, yCoord);
    }
}
