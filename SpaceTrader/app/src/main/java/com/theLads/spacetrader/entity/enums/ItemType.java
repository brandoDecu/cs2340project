package com.theLads.spacetrader.entity.enums;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Enum class for type of items for the marketplace
 */

public enum ItemType {

    WATER (0, 30),
    FURS (1, 30),
    FOOD (2, 40),
    ORE (3, 10),
    GAMES (4, 15),
    FIREARMS (5, 100),
    MEDICINE (6, 30),
    MACHINES (7, 30),
    NARCOTICS (8, 100000),
    ROBOTS (9, 10000);

    private final int index;
    private final double basePrice;

    public int getIndex() { return index;}
    public double getBasePrice() {return basePrice;}

    ItemType(int index, double basePrice) {
        this.index = index;
        this.basePrice = basePrice;
    }
}
