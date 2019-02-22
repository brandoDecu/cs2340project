package com.theLads.spacetrader.entity;

import java.util.LinkedList;

public class SolarSystem {

    private Planet planet;

    private String name;

    private int xCoord;

    private int yCoord;


    SolarSystem(Planet planet) {
        this.planet = planet;
        this.name = planet.getName();

        this.xCoord = (int) (Math.random() * 100);
        this.yCoord = (int) (Math.random() * 150);
    }
}
