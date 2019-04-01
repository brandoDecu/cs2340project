package com.theLads.spacetrader.model;

import com.theLads.spacetrader.entity.Game;
import com.theLads.spacetrader.entity.Player;
import com.theLads.spacetrader.entity.SolarSystem;
import com.theLads.spacetrader.entity.enums.ItemType;

import java.util.List;


public class GameInteractor extends Interactor {

    public GameInteractor(Repository repo) {
        super(repo);
    }


    public void addGame (Game g) {
        getRepository().addGame(g);
    }


    public Game getCurrentGame() {
        return getRepository().getCurrentGame();
    }

    public String getPlanetName() {return getCurrentGame().getPlanetName();}

    public void setCredits(double credits) {
        Player player = getCurrentGame().getPlayer();
        player.setCredits(credits);
    }

    public List<Integer> getCargoQuantities() {
        return getCurrentGame().getCargoQuantities();
    }

    public List<Double> getMarketPrices() {
        return getCurrentGame().getMarketPrices();
    }

    public List<Integer> getMarketQuantities() {
        return getCurrentGame().getMarketQuantities();
    }

    public void buyItem(ItemType item, int quantity, double price) {
        getCurrentGame().buyItem(item, quantity, price);
    }

    public void sellItem(ItemType item, int quantity, double price) {
        getCurrentGame().sellItem(item, quantity, price);
    }

    public double getCredits() {return getCurrentGame().getCredits();}

    public List<SolarSystem> getSolarSystems() {return getCurrentGame().getSolarSystems();}

    public List<String> getSolarSystemNames() {return getCurrentGame().getSolarSystemNames();}

    public List<Integer> getSolarSystemDistances() {return getCurrentGame().getSolarSystemDistances();}

    public void travelTo(SolarSystem solarSystem) {
        getCurrentGame().travelTo(solarSystem);
    }

    public int getFuel() {return getCurrentGame().getFuel();}

    public SolarSystem getCurrentSolarSystem() {return getCurrentGame().getCurrentSolarSystem();}

    public int getDistanceTo(SolarSystem solarSystem) {return getCurrentGame().getDistanceTo(solarSystem);}
}