package com.theLads.spacetrader.viewmodels;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.support.annotation.NonNull;
import android.util.Log;

import com.theLads.spacetrader.entity.Game;
import com.theLads.spacetrader.entity.Planet;
import com.theLads.spacetrader.entity.SolarSystem;
import com.theLads.spacetrader.entity.enums.ItemType;
import com.theLads.spacetrader.model.GameInteractor;

import com.theLads.spacetrader.model.Model;

import java.util.List;

public class TravelViewModel extends AndroidViewModel {
    private GameInteractor interactor;

    public TravelViewModel(@NonNull Application application) {
        super(application);
        interactor = Model.getInstance().getGameInteractor();
    }
    public String getPlanetName() {return interactor.getPlanetName();}

    public List<SolarSystem> getSolarSystems() { return interactor.getSolarSystems();}

    public List<String> getSolarSystemNames() {return interactor.getSolarSystemNames();}

    public List<Integer> getSolarSystemDistances() {return interactor.getSolarSystemDistances();}

    public int getFuel() {return interactor.getFuel();}

    public void travelTo(SolarSystem solarSystem) {
        int index = getSolarSystems().indexOf(solarSystem);
        int fuelRequired = getSolarSystemDistances().get(index);
        if (getFuel() >= fuelRequired) {
            interactor.travelTo(solarSystem);
        } else {
            throw new IllegalArgumentException("You need " + fuelRequired + " fuel to travel here");
        }
    }

    public int getDistanceTo(SolarSystem solarSystem) {return interactor.getDistanceTo(solarSystem);}

    public SolarSystem getCurrentSolarSystem() {return interactor.getCurrentSolarSystem();}














}