package com.theLads.spacetrader.entity.enums;

/**
 * Enum class for type of items for the marketplace
 */

public enum ItemType {

    WATER (0, 80),
    FURS (1, 125),
    FOOD (2, 250),
    ORE (3, 100),
    GAMES (4, 150),
    FIREARMS (5, 1000),
    MEDICINE (6, 300),
    MACHINES (7, 300),
    NARCOTICS (8, 40000),
    ROBOTS (9, 20000);

    private final int index;
    private final double basePrice;

    public int getIndex() { return index;}
    public double getBasePrice() {return basePrice;}

    ItemType(int index, double basePrice) {
        this.index = index;
        this.basePrice = basePrice;
    }
}
