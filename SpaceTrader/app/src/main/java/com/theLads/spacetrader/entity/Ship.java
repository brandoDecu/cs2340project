package com.theLads.spacetrader.entity;

import android.content.ClipData;

import com.theLads.spacetrader.entity.enums.ItemType;
import com.theLads.spacetrader.entity.enums.ShipType;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Ship {

    private ShipType type;
    private int health;
    private List<Integer> cargoQuantities = new ArrayList<>();

    /**
     * Ship constructor that takes in a ShipType enum and creates a ship for the player
     * @param type
     */
    public Ship(ShipType type) {

        this.type = type;
        this.health = type.getMaxHealth();
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

    public int getCargoCapacity() {
        return type.getCargoCapacity();
    }

    public List<Integer> getCargoQuantities() {
        return cargoQuantities;
    }

    public int getFuel() {return cargoQuantities.get(ItemType.FUEL.ordinal());}

    public int getQuantityOf(ItemType item) {
        return cargoQuantities.get(item.ordinal());
    }

    public void setItemQuantity(ItemType item, int quantity) {
        cargoQuantities.set(item.ordinal(), quantity);
    }


    @Override
    public String toString() {
        return "Ship Type: " + type + " with Max Health: " +
                health + " with Cargo Capacity: " + getCargoCapacity();
    }
}
