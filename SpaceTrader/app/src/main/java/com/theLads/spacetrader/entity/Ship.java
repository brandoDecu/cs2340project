package com.theLads.spacetrader.entity;

public class Ship {
    private ShipType type;
    private int health;


    /*
    Constructor for Ship
     */
    public Ship(ShipType type) {

        this.type = type;
        this.health = type.getMaxHealth();
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
}
