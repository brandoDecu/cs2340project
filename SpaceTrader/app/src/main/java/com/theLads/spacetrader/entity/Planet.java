package com.theLads.spacetrader.entity;

public enum Planet {

    ALDEA ("Aldea"),
    ANDEVIAN("Andevian"),
    ANTEDI("Antedi"),
    BALOSNEE("Balosnee"),
    BARATAS("Baratas"),
    BRAX("Brax"),			// One of the heroes in Master of Magic
    BRETEL("Bretel"),		// This is a Dutch device for keeping your pants up.
    CALONDIA("Calondia"),
    CAMPOR("Campor"),
    CAPELLE("Capelle"),		// The city I lived in while programming this game
    CARZON("Carzon"),
    CASTOR("Castor"),		// A Greek demi-god
    CESTUR("Cestus"),
    CHERON("Cheron"),
    COURTENEY("Courteney"),	// After Courteney Cox…
    DALED("Daled"),
    DAMAST("Damast"),
    DALVOS("Davlos");

    private String name;

    private int techLvl;

    private int resources;



    Planet(String nam) {
        this.name = name;

        this.techLvl = (int) (Math.random() * 7);
        this.resources = (int) (Math.random() * 12);
    }

    public String getName() {
        return name;
    }

    public int getTechLvl() {
        return techLvl;
    }

    public int getResources() {
        return resources;
    }

}
