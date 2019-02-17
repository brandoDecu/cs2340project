package com.theLads.spacetrader.entity;

public enum ShipType {
    GNAT ("GNAT", 100,500);

    private String typeName;

    private int maxHealth;

    private int cargoCapaticy;



    ShipType(String typeName, int maxHealth, int cargoCapaticy) {
        this.typeName = typeName;
        this.maxHealth = maxHealth;
        this.cargoCapaticy = cargoCapaticy;
    }

    public String getTypeName() {
        return typeName;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public int getCargoCapaticy() {
        return cargoCapaticy;
    }


}
