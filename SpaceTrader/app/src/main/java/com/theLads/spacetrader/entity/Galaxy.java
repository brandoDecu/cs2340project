package com.theLads.spacetrader.entity;

import android.util.Log;

import com.theLads.spacetrader.entity.enums.ItemType;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;

import static java.lang.Math.abs;
import static java.lang.Math.sqrt;

public class Galaxy {

    private List<SolarSystem> solarSystemsList = new ArrayList<>();
    private SolarSystem currentSolarSystem;
    private static int numSolarSystems;


    /**
     * Galaxy constructor that creates a galaxy upon game entry
     */

    public Galaxy() {
        solarSystemsList.add(new SolarSystem("XiPing"));
        solarSystemsList.add(new SolarSystem("Squanch"));
        solarSystemsList.add(new SolarSystem("Ugan"));
        solarSystemsList.add(new SolarSystem("Squimble"));
        solarSystemsList.add(new SolarSystem("Urth"));
        solarSystemsList.add(new SolarSystem("Usuh"));
        solarSystemsList.add(new SolarSystem("Yumin"));
        solarSystemsList.add(new SolarSystem("Etaly"));
        solarSystemsList.add( new SolarSystem("Pelonia"));
        solarSystemsList.add(new SolarSystem("Cretan"));

        numSolarSystems = solarSystemsList.size();

        // Current solar system is random upon starting the game
        Random rand = new Random();
        currentSolarSystem = solarSystemsList.get(rand.nextInt(numSolarSystems-1));
    }

    public List<SolarSystem> getSolarSystems() {
        return solarSystemsList;
    }

    public List<String> getSolarSystemNames() {
        List<SolarSystem> solarSystems = getSolarSystems();
        List<String> names = new ArrayList<>();
        for (int i = 0; i < numSolarSystems; i++) {
            names.add(solarSystems.get(i).getName());
        }
        return names;
    }

    public List<Integer> getDistances() {
        List<SolarSystem> solarSystems = getSolarSystems();
        List<Integer> distances  = new ArrayList<>();
        for (int i = 0; i < numSolarSystems; i++) {
            int xcoord = solarSystems.get(i).getxCoord();
            int ycoord = solarSystems.get(i).getyCoord();

            int currxCoord = currentSolarSystem.getxCoord();
            int curryCoord = currentSolarSystem.getyCoord();

            int xDist = abs(xcoord - currxCoord);
            int yDist = abs(ycoord - curryCoord);
            distances.add((int) sqrt(xDist*xDist + yDist*yDist));
        }
        return distances;
    }

    public String getPlanetName() {return currentSolarSystem.getName();}

    public List<Double> getMarketPrices() {
        return currentSolarSystem.getMarketPrices();
    }

    public List<Integer> getMarketQuantities() {
        return currentSolarSystem.getMarketQuantities();
    }

    public void buyItem(ItemType item, int quantity) {
        currentSolarSystem.buyItem(item, quantity);
    }

    public void sellItem(ItemType item, int quantity) {
        currentSolarSystem.sellItem(item, quantity);
    }

    public void travelTo(SolarSystem solarSystem) {
        currentSolarSystem = solarSystem;
    }
}
