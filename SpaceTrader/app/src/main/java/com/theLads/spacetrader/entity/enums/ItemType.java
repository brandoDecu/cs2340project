package com.theLads.spacetrader.entity.enums;

/**
 * Enum class for type of items for the marketplace
 */

public enum ItemType {

    WATER (20),
    FUEL (50),
    FURS (125),
    FOOD (250),
    ORE (100),
    GAMES (150),
    FIREARMS (1000),
    MEDICINE (300),
    MACHINES (300),
    NARCOTICS (40000),
    ROBOTS (20000);


    private final double basePrice;

    public double getBasePrice() {return basePrice;}

    ItemType(double basePrice) {
        this.basePrice = basePrice;
    }
}
