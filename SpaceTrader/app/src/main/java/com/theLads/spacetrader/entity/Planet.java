package com.theLads.spacetrader.entity;

import com.theLads.spacetrader.entity.enums.ItemType;
import com.theLads.spacetrader.entity.enums.Resources;
import com.theLads.spacetrader.entity.enums.TechLevel;

import java.util.List;
import java.util.Random;

public class Planet {

    private String name;

    private TechLevel techLvl;

    private Resources resources;

    private MarketPlace market;

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
        this.techLvl = TechLevel.values()[resultTech];


        Random r2 = new Random();
        int lowResource = 0;
        int highResource = 12;
        int resultResource = r2.nextInt(highResource-lowResource) + lowResource;
        this.resources =  Resources.values()[resultResource];

        this.market = new MarketPlace(techLvl, resources);
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

    public TechLevel getTechLvl() {
        return techLvl;
    }

    /**
     * Getter method for the resources level of planet
     * @return resources level
     */

    public Resources getResources() {
        return resources;
    }


    public List<Double> getMarketPrices() {
        return market.getPrices();
    }

    public List<Integer> getMarketQuantities() {
        return market.getMarketQuantities();
    }

    public void buyItem(ItemType item, int quantity) {
        market.setItemQuantity(item, market.getQuantityOf(item) - quantity);
    }

    public void sellItem(ItemType item, int quantity) {
        market.setItemQuantity(item, market.getQuantityOf(item) + quantity);

    }

}
