package com.theLads.spacetrader.entity;

import android.util.Log;

import com.theLads.spacetrader.entity.enums.ItemType;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;

import static java.lang.Math.abs;
import static java.lang.Math.sqrt;

public class Galaxy implements Serializable {

    private final List<SolarSystem> solarSystemsList = new ArrayList<>();
    private SolarSystem currentSolarSystem;
    private static int numSolarSystems;


    /**
     * Galaxy constructor that creates a galaxy upon game entry
     */

    public Galaxy() {
        solarSystemsList.add(new SolarSystem("Fitness"));
        solarSystemsList.add(new SolarSystem("Squanch"));
        solarSystemsList.add(new SolarSystem("Ugan"));
        solarSystemsList.add(new SolarSystem("Squimble"));
        solarSystemsList.add(new SolarSystem("Urth"));
        solarSystemsList.add(new SolarSystem("Mibo"));
        solarSystemsList.add(new SolarSystem("Yumin"));
        solarSystemsList.add(new SolarSystem("Catanze Aro"));
        solarSystemsList.add(new SolarSystem("Pelonia"));
        solarSystemsList.add(new SolarSystem("Cretan"));
        solarSystemsList.add(new SolarSystem("Egmo"));
        solarSystemsList.add(new SolarSystem("Gluon"));
        solarSystemsList.add(new SolarSystem("Zlyp"));
        solarSystemsList.add(new SolarSystem("Marze"));
        solarSystemsList.add(new SolarSystem("Ghyf"));
        solarSystemsList.add(new SolarSystem("JMJ 37"));
        solarSystemsList.add(new SolarSystem("Darrzeevee"));
        solarSystemsList.add(new SolarSystem("Jayrama"));
        solarSystemsList.add(new SolarSystem("Il Debran"));
        solarSystemsList.add(new SolarSystem("Has Maxel"));
        solarSystemsList.add(new SolarSystem("H20Bob"));
        solarSystemsList.add(new SolarSystem("Glich"));
        solarSystemsList.add(new SolarSystem("Zero"));
        solarSystemsList.add(new SolarSystem("ATL"));
        solarSystemsList.add(new SolarSystem("XiPing"));
        solarSystemsList.add(new SolarSystem("Arium"));
        solarSystemsList.add(new SolarSystem("Lonely"));
























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

    public SolarSystem getCurrentSolarSystem() {return currentSolarSystem;}

    public void buyItem(ItemType item, int quantity) {
        currentSolarSystem.buyItem(item, quantity);
    }

    public void sellItem(ItemType item, int quantity) {
        currentSolarSystem.sellItem(item, quantity);
    }

    public void travelTo(SolarSystem solarSystem) {
        currentSolarSystem = solarSystem;
    }

    public int getDistanceTo(SolarSystem solarSystem) {
        int index = solarSystemsList.indexOf(solarSystem);
        return getDistances().get(index);
    };
}
