package com.theLads.spacetrader.entity;

public enum ShipType {
    GNAT ("GNAT", 100,500);

    private String typeName;

    private int maxHealth;

    private int cargoCapacity;

    /**
     * Constructor for the type of ship to be created
     * @param typeName name of the type of ship
     * @param maxHealth the overall total health the ship can have
     * @param cargoCapacity the overall total capacity a ship can have
     */

    ShipType(String typeName, int maxHealth, int cargoCapacity) {
        this.typeName = typeName;
        this.maxHealth = maxHealth;
        this.cargoCapacity = cargoCapacity;
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
