package com.theLads.spacetrader.viewmodels;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.support.annotation.NonNull;

import com.theLads.spacetrader.entity.Game;
import com.theLads.spacetrader.entity.Player;
import com.theLads.spacetrader.entity.SolarSystem;
import com.theLads.spacetrader.entity.enums.ItemType;
import com.theLads.spacetrader.model.GameInteractor;

import com.theLads.spacetrader.model.Model;

import java.util.List;

public class TravelViewModel extends AndroidViewModel {
    private final GameInteractor interactor;
    private Game currentGame;
    private Player player;

    public TravelViewModel(@NonNull Application application) {
        super(application);
        interactor = Model.getInstance().getGameInteractor();
    }
    public String getPlanetName() {return interactor.getPlanetName();}

    public List<SolarSystem> getSolarSystems() { return interactor.getSolarSystems();}

    public List<String> getSolarSystemNames() {return interactor.getSolarSystemNames();}

    private List<Integer> getSolarSystemDistances() {return interactor.getSolarSystemDistances();}

    private int getFuel() {return interactor.getFuel();}

    private Game getCurrentGame() {
        currentGame = interactor.getCurrentGame();
        return currentGame;
    }
    private Player getCurrentPlayer() {
        currentGame = getCurrentGame();
        player =  currentGame.getPlayer();
        return player;
    }

    @SuppressWarnings({"FeatureEnvy", "MagicNumber"})
    public void bustedByPolice() {
        player = getCurrentPlayer();
        player.setCredits(player.getCredits()*0.5);
        player.sellItem(ItemType.FIREARMS, player.getCargoQuantities().get(ItemType.FIREARMS.ordinal()), 0);
        player.sellItem(ItemType.NARCOTICS, player.getCargoQuantities().get(ItemType.NARCOTICS.ordinal()), 0);
    }

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