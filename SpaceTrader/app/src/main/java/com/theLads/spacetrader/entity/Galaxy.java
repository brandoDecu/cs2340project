package com.theLads.spacetrader.entity;

import android.util.Log;

import com.theLads.spacetrader.entity.enums.ItemType;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;

public class Galaxy {

    private List<SolarSystem> solarSystemsList = new ArrayList<>();
    private SolarSystem currentSolarSystem;


    /**
     * Galaxy constructor that creates a galaxy upon game entry
     */

    public Galaxy() {
        SolarSystem xi = new SolarSystem("Xi");
        solarSystemsList.add(xi);
        Log.d("Solar System Created", xi.toString());

        SolarSystem liberia = new SolarSystem("Liberia");
        solarSystemsList.add(liberia);
        Log.d("Solar System Created", liberia.toString());

        SolarSystem ugan = new SolarSystem("Ugan");
        solarSystemsList.add(ugan);
        Log.d("Solar System Created", ugan.toString());

        SolarSystem russ = new SolarSystem("Russ");
        solarSystemsList.add(russ);
        Log.d("Solar System Created", russ.toString());

        SolarSystem ukra = new SolarSystem("Ukra");
        solarSystemsList.add(ukra);
        Log.d("Solar System Created", ukra.toString());

        SolarSystem usa = new SolarSystem("Usa");
        solarSystemsList.add(usa);
        Log.d("Solar System Created", usa.toString());

        SolarSystem yumin = new SolarSystem("Yumin");
        solarSystemsList.add(yumin);
        Log.d("Solar System Created", yumin.toString());

        SolarSystem etaly = new SolarSystem("Etaly");
        solarSystemsList.add(etaly);
        Log.d("Solar System Created", etaly.toString());

        SolarSystem peland = new SolarSystem("Peland");
        solarSystemsList.add(peland);
        Log.d("Solar System Created", peland.toString());

        SolarSystem cretan = new SolarSystem("Cretan");
        solarSystemsList.add(cretan);
        Log.d("Solar System Created", cretan.toString());

        // Current solar system is random upon starting the game
        Random rand = new Random();
        currentSolarSystem = solarSystemsList.get(rand.nextInt(solarSystemsList.size()-1));
    }

    public Collection<SolarSystem> getSolarSystemsList() {
        return solarSystemsList;
    }


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
}
