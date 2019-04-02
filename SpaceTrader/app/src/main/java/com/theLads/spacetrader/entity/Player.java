package com.theLads.spacetrader.entity;

import com.theLads.spacetrader.entity.enums.GameDifficulty;
import com.theLads.spacetrader.entity.enums.ItemType;
import com.theLads.spacetrader.entity.enums.ShipType;

import java.io.Serializable;
import java.util.List;


/** This class represents a single player for the Space Trader game. */

public class Player implements Serializable {

    private int playerId;

    /** This represents the pilot skill level. */
    private int pilotSkill;

    /** This represents the fighter skill level. */
    private int fighterSkill;

    /** This represents the trader skill level. */
    private int traderSkill;

    /** This represents the engineer skill level. */
    private int engineerSkill;

    /** This represents the name of the player's character. */
    private String characterName;

    /** This represents the player's ship */
    private Ship ship;

    /** Player credits*/
    private double credits;

    private GameDifficulty difficulty;

    /**
     *
     * @param nam name of Character
     * @param pilot pilot Skill attribute for character
     * @param fighter fighter Skill attribute for character
     * @param trader trader Skill attribute for character
     * @param engineer engineer Skill attribute for character
     */
    public Player(String nam, int pilot, int fighter, int trader, int engineer) {
        this.characterName = nam;
        this.pilotSkill = pilot;
        this.fighterSkill = fighter;
        this.traderSkill = trader;
        this.engineerSkill = engineer;
        this.ship = new Ship(ShipType.GNAT);

        int total = pilot + fighter + trader + engineer;
        this.credits = 1000 + (100 * (16 - total));
    }

    /**
     * getter method for player name
     * @return player name
     */
    public String getName() {
        return characterName;
    }

    /**
     * getter method for pilot skill
     * @return pilot skill level
     */
    public int getPilotSkill() {
        return pilotSkill;
    }

    /**
     * getter method for fighter skill
     * @return fighter skill level
     */
    public int getFighterSkill() {
        return fighterSkill;
    }

    /**
     * getter method for trader skill
     * @return trader skill level
     */
    public int getTraderSkill() {
        return traderSkill;
    }

    /**
     * getter method for engineer skill
     * @return engineer skill level
     */
    public int getEngineerSkill() {
        return engineerSkill;
    }

    /**
     * getter method for player credits
     * @return player credits
     */
    public double getCredits() {return credits;}

    /**
     * getter method for player's ship
     * @return player's ship
     */
    public Ship getShip() {return ship;}

    /**
     * getter method to get player's fuel
     * @return player's fuel
     */
    int getFuel() {return ship.getFuel();}


    /**
     * setter method for name
     * @param nam player name
     */
    public void setName(String nam) { characterName = nam; }

    /**
     * setter method for pilot skill
     * @param skill pilot skill
     */
    public void setPilotSkill(int skill) {pilotSkill = skill; }

    /**
     * setter method for fighter skill
     * @param skill fighter skill
     */
    public void setFighterSkill(int skill) {fighterSkill = skill; }

    /**
     * setter method for trader skill
     * @param skill trader skill
     */
    public void setTraderSkill(int skill) {traderSkill = skill; }

    /**
     * setter method for engineer skill
     * @param skill engineer skill
     */
    public void setEngineerSkill(int skill) {engineerSkill = skill; }

    /**
     * setter method for player credits
     * @param credits player credits
     */
    public void setCredits(double credits) {this.credits = credits;}

    /**
     * setter method for player ship
     * @param ship player ship
     */
    public void setShip(Ship ship) {this.ship = ship; }

    /**
     * getter method that returns cargo in player ship
     * @return cargo quantities in player ship
     */
    public List<Integer> getCargoQuantities() {
        return ship.getCargoQuantities();
    }

    /**
     * buy method to buy items
     * @param item item to buy
     * @param quantity quantity of item to buy
     * @param price price of item
     */
    void buyItem(ItemType item, int quantity, double price) {
        credits -= price*quantity;
        ship.setItemQuantity(item, ship.getQuantityOf(item) + quantity);
    }

    /**
     * method to sell items
     * @param item item to sell
     * @param quantity quantity of item to sell
     * @param price price item is sold at
     */
    public void sellItem(ItemType item, int quantity, double price) {
        credits += price*quantity;
        ship.setItemQuantity(item, ship.getQuantityOf(item) - quantity);
    }

    /**
     * method to use fuel to travel to planet
     * @param fuel player fuel
     */
    void useFuel(int fuel) {
        ship.setItemQuantity(ItemType.FUEL, ship.getQuantityOf(ItemType.FUEL) - fuel);
    }



    @Override
    public String toString() {
        return String.format("Player: %s, Pilot: %d, Fighter: %d, Trader: %d," +
                        "Engineer: %d, Credits: %.2f, " + ship,
                characterName, pilotSkill, fighterSkill,
                traderSkill, engineerSkill, credits);
    }

}

