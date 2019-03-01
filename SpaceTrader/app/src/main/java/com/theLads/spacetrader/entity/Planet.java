package com.theLads.spacetrader.entity;

import java.util.Random;

public class Planet {

    private String name;

    private int techLvl;

    private int resources;

    /**
     * Planet constructor that takes in a name and creates a planet with random values for tech,
     * resources, and location in the solar system
     * @param nam name of the planet
     */

    Planet(String nam) {

        this.name = nam;

        Random r1 = new Random();
        int lowTech = 0;
        int highTech = 7;
        int resultTech = r1.nextInt(highTech-lowTech) + lowTech;
        this.techLvl = resultTech;


        Random r2 = new Random();
        int lowResource = 0;
        int highResource = 12;
        int resultResource = r2.nextInt(highResource-lowResource) + lowResource;
        this.resources =  resultResource;
    }

    /**
     * Getter method for the name of planet
     * @return String name
     */

    public String getName() {
        return name;
    }

    /**
     * Getter method for the tech level of the planet
     * @return tech level
     */

    public int getTechLvl() {
        return techLvl;
    }

    /**
     * Getter method for the resources level of planet
     * @return resources level
     */

    public int getResources() {
        return resources;
    }

}
