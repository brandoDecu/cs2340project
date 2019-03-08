package com.theLads.spacetrader.viewmodels;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.support.annotation.NonNull;
import android.util.Log;

import com.theLads.spacetrader.entity.Game;
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

    public List<SolarSystem> getSolarSystems() { return interactor.getSolarSystems();}

    public List<String> getSolarSystemNames() {return interactor.getSolarSystemNames();}

    public List<Integer> getSolarSystemDistances() {return interactor.getSolarSystemDistances();}

    public void travelTo(SolarSystem solarSystem) {
        interactor.travelTo(solarSystem);
    }










}