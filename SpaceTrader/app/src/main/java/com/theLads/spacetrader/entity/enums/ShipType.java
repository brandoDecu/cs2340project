package com.theLads.spacetrader.entity.enums;

public enum ShipType {
    GNAT ();

    private final String typeName;

    private final int maxHealth;

    private final int cargoCapacity;

    /**
     * Constructor for the type of ship to be created
     *
     */

    ShipType() {
        this.typeName = "GNAT";
        this.maxHealth = 100;
        this.cargoCapacity = 500;
    }

    public String getTypeName() {
        return typeName;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public int getCargoCapacity() {
        return cargoCapacity;
    }


}
