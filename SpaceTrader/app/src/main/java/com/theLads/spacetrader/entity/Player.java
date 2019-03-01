package com.theLads.spacetrader.entity;

import com.theLads.spacetrader.entity.enums.GameDifficulty;
import com.theLads.spacetrader.entity.enums.ShipType;

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
    private int credits;

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
        this.credits = 1000;
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

    public int getCredits() {return credits;}

    public Ship getShip() {return ship;}


    //Setter methods for the Player attributes
    public void setName(String nam) { characterName = nam; }

    public void setPilotSkill(int skill) {pilotSkill = skill; }

    public void setFighterSkill(int skill) {fighterSkill = skill; }

    public void setTraderSkill(int skill) {traderSkill = skill; }

    public void setEngineerSkill(int skill) {engineerSkill = skill; }

    public void setCredits(int credits) {this.credits = credits;}

    public void setShip(Ship ship) {this.ship = ship; }



    @Override
    public String toString() {
        return String.format("Player: %s, Pilot: %d, Fighter: %d, Trader: %d," +
                        "Engineer: %d, Credits: %d, " + ship,
                characterName, pilotSkill, fighterSkill,
                traderSkill, engineerSkill, credits);
    }

}

