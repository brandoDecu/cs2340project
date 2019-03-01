package com.theLads.spacetrader.entity;

import com.theLads.spacetrader.entity.enums.ShipType;

public class Ship {

    private ShipType type;
    private int health;
    private int cargoCapacity;

    /**
     * Ship constructor that takes in a ShipType enum and creates a ship for the player
     * @param type
     */
    public Ship(ShipType type) {

        this.type = type;
        this.health = type.getMaxHealth();
        this.cargoCapacity = type.getCargoCapacity();
    }



    /**
    Getter for ShipType
     @return ShipType of ship
     */
    public ShipType getType() {
        return type;
    }

    /**
    Getter for health
     @return max health
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
