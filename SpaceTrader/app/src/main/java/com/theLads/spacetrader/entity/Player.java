package com.theLads.spacetrader.entity;

import com.theLads.spacetrader.entity.enums.GameDifficulty;
import com.theLads.spacetrader.entity.enums.ItemType;
import com.theLads.spacetrader.entity.enums.ShipType;

import java.util.List;

/** This class represents a single player for the Space Trader game. */
public class Player {

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

    //Getter methods for the different attributes of the player class


    public String getName() {
        return characterName;
    }

    public int getPilotSkill() {
        return pilotSkill;
    }

    public int getFighterSkill() {
        return fighterSkill;
    }

    public int getTraderSkill() {
        return traderSkill;
    }

    public int getEngineerSkill() {
        return engineerSkill;
    }

    public double getCredits() {return credits;}

    public Ship getShip() {return ship;}

    public int getFuel() {return ship.getFuel();}


    //Setter methods for the Player attributes
    public void setName(String nam) { characterName = nam; }

    public void setPilotSkill(int skill) {pilotSkill = skill; }

    public void setFighterSkill(int skill) {fighterSkill = skill; }

    public void setTraderSkill(int skill) {traderSkill = skill; }

    public void setEngineerSkill(int skill) {engineerSkill = skill; }

    public void setCredits(double credits) {this.credits = credits;}

    public void setShip(Ship ship) {this.ship = ship; }



    public List<Integer> getCargoQuantities() {
        return ship.getCargoQuantities();
    }

    public void buyItem(ItemType item, int quantity, double price) {
        credits -= price*quantity;
        ship.setItemQuantity(item, ship.getQuantityOf(item) + quantity);
    }

    public void sellItem(ItemType item, int quantity, double price) {
        credits += price*quantity;
        ship.setItemQuantity(item, ship.getQuantityOf(item) - quantity);
    }

    public void useFuel(int fuel) {
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

