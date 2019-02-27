package com.theLads.spacetrader.entity;

import java.util.LinkedList;

public class SolarSystem {

    private Planet planet;

    private String name;

    private int techLevel;

    private int resourceLevel;

    private int xCoord;

    private int yCoord;


    SolarSystem(String name) {
        this.planet = new Planet(name);
        this.name = planet.getName();

        this.xCoord = (int) (Math.random() * 100);
        this.yCoord = (int) (Math.random() * 150);

        techLevel = planet.getTechLvl();
        resourceLevel = planet.getResources();
    }
    public String getName() {
        return name;
    }
    public int getTechLevel() {
        return techLevel;
    }
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
