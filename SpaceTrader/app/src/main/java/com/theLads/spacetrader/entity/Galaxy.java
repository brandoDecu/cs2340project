package com.theLads.spacetrader.entity;

import android.util.Log;

import java.util.ArrayList;
import java.util.Collection;

public class Galaxy {

    Collection<SolarSystem> galaxyList = new ArrayList<>();

    /**
     * Galaxy constructor that creates a galaxy upon game entry
     */

    public Galaxy() {
        SolarSystem xi = new SolarSystem("Xi");
        galaxyList.add(xi);
        Log.d("Solar System Created", xi.toString());

        SolarSystem liberia = new SolarSystem("Liberia");
        galaxyList.add(liberia);
        Log.d("Solar System Created", liberia.toString());

        SolarSystem ugan = new SolarSystem("Ugan");
        galaxyList.add(ugan);
        Log.d("Solar System Created", ugan.toString());

        SolarSystem russ = new SolarSystem("Russ");
        galaxyList.add(russ);
        Log.d("Solar System Created", russ.toString());

        SolarSystem ukra = new SolarSystem("Ukra");
        galaxyList.add(ukra);
        Log.d("Solar System Created", ukra.toString());

        SolarSystem usa = new SolarSystem("Usa");
        galaxyList.add(usa);
        Log.d("Solar System Created", usa.toString());

        SolarSystem yumin = new SolarSystem("Yumin");
        galaxyList.add(yumin);
        Log.d("Solar System Created", yumin.toString());

        SolarSystem etaly = new SolarSystem("Etaly");
        galaxyList.add(etaly);
        Log.d("Solar System Created", etaly.toString());

        SolarSystem peland = new SolarSystem("Peland");
        galaxyList.add(peland);
        Log.d("Solar System Created", peland.toString());

        SolarSystem cretan = new SolarSystem("Cretan");
        galaxyList.add(cretan);
        Log.d("Solar System Created", cretan.toString());
    }

}
