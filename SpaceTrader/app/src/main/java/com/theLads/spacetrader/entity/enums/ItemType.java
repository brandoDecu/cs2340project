package com.theLads.spacetrader.entity.enums;

/**
 * Enum class for type of items for the marketplace
 */

public enum ItemType {

    WATER (0),
    FURS (1),
    FOOD (2),
    ORE (3),
    GAMES (4),
    FIREARMS (5),
    MEDICINE (6),
    MACHINES (7),
    NARCOTICS (8),
    ROBOTS (9);

    private final int index;

    public int getIndex() { return index;}

    ItemType(int index) { this.index = index;}
}
