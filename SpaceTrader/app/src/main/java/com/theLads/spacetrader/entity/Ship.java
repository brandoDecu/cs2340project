package com.theLads.spacetrader.entity;

public class Ship {

    private ShipType type;
    private int health;
    private int cargoCapacity;

    /*
    Constructor for Ship
     */
    public Ship(ShipType type) {

        this.type = type;
        this.health = type.getMaxHealth();
        this.cargoCapacity = type.getCargoCapaticy();
    }



    /*
    Getter for ShipType
     */
    public ShipType getType() {
        return type;
    }

    /*
    Getter for health
     */
    public int getHealth() {
        return health;
    }

    @Override
    public String toString() {
        return "Ship Type: " + type + " with Max Health: " +
                health + " with Cargo Capacity: " + cargoCapacity;
    }
}
