package com.theLads.spacetrader.entity;

import java.util.Random;

public class Planet {

    private String name;

    private int techLvl;

    private int resources;



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

    public String getName() {
        return name;
    }

    public int getTechLvl() {
        return techLvl;
    }

    public int getResources() {
        return resources;
    }

}
