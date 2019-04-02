package com.theLads.spacetrader.entity;

import com.theLads.spacetrader.entity.enums.ItemType;
import com.theLads.spacetrader.entity.enums.Resources;
import com.theLads.spacetrader.entity.enums.TechLevel;

import java.io.Serializable;
import java.util.List;
import java.util.Random;

class Planet implements Serializable {

    private final String name;

    private final TechLevel techLvl;

    private final Resources resources;

    private final MarketPlace market;

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
        int highResource = 12;
        int resultResource = r2.nextInt(5);
        if (resultResource <= 3) {
            this.resources = Resources.NOSPECIALRESOURCES;
        } else {
            resultResource = r2.nextInt(highResource);
            this.resources =  Resources.values()[resultResource];
        }
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

    TechLevel getTechLvl() {
        return techLvl;
    }

    /**
     * Getter method for the resources level of planet
     * @return resources level
     */

    Resources getResources() {
        return resources;
    }


    List<Double> getMarketPrices() {
        return market.getPrices();
    }

    List<Integer> getMarketQuantities() {
        return market.getMarketQuantities();
    }

    void buyItem(ItemType item, int quantity) {
        market.setItemQuantity(item, market.getQuantityOf(item) - quantity);
    }

    void sellItem(ItemType item, int quantity) {
        market.setItemQuantity(item, market.getQuantityOf(item) + quantity);

    }

}
