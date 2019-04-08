package com.theLads.spacetrader.entity;

import com.theLads.spacetrader.entity.enums.ItemType;
import com.theLads.spacetrader.entity.enums.ShipType;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Ship implements Serializable {

    private final ShipType type;
    private final int health;
    private final List<Integer> cargoQuantities = new ArrayList<>();

    /**
     * Ship constructor that takes in a ShipType enum and creates a ship for the player
     */
    Ship() {

        this.type = ShipType.GNAT;
        this.health = ShipType.GNAT.getMaxHealth();
        for(ItemType item : ItemType.values()) {
            cargoQuantities.add(0);
        }
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

    private int getCargoCapacity() {
        return type.getCargoCapacity();
    }

    List<Integer> getCargoQuantities() {
        return Collections.unmodifiableList(cargoQuantities);
    }

    /**
     * getter method for fuel
     * @return fuel
     */
    int getFuel() {return cargoQuantities.get(ItemType.FUEL.ordinal());}

    /**
     * getter method for quantity of item on ship
     * @param item item to get quantity of
     * @return quantity of item on ship
     */
    public int getQuantityOf(ItemType item) {
        return cargoQuantities.get(item.ordinal());
    }

    /**
     * setter method to set item quantity on ship
     * @param item item to set
     * @param quantity quantity to item to add to ship
     */
    public void setItemQuantity(ItemType item, int quantity) {
        cargoQuantities.set(item.ordinal(), quantity);
    }


    @SuppressWarnings("NullableProblems")
    @Override
    public String toString() {
        return "Ship Type: " + type + " with Max Health: " +
                health + " with Cargo Capacity: " + getCargoCapacity();
    }
}
