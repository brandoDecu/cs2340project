package com.theLads.spacetrader.entity.enums;

public enum TechLevel {
    PREAGRICULTURE (0),
    AGRICULTURE (1),
    MEDIEVAL (2),
    RENNAISSANCE (3),
    EARLYINDUSTRIAL (4),
    INDUSTRIAL (5),
    POSTINDUSTRIAL (6),
    HITECH (7);

    TechLevel(int index) {
        this.index = index;
    }

    private final int index;

    public int getIndex() {
        return index;
    }


}
