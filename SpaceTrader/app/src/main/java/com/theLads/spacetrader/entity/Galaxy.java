package com.theLads.spacetrader.entity;

import android.util.Log;

import java.util.ArrayList;
import java.util.Collection;

public class Galaxy {

    Collection<SolarSystem> solarSystemsList = new ArrayList<>();

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
    }

}
