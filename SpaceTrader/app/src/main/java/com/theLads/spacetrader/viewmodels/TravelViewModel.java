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

/**
 * The version of ViewModel for travelling
 */
public class TravelViewModel extends AndroidViewModel {
    private final GameInteractor interactor;
    private Game currentGame;
    private Player player;

    /**
     * TravelViewModel constructor which creates a TravelViewModel upon travel menu entry
     * @param application the application to be passed to AndroidViewModel super constructor
     */
    public TravelViewModel(@NonNull Application application) {
        super(application);
        interactor = Model.getInstance().getGameInteractor();
    }

    /**
     * gets the name of the Planet
     * @return Planet name
     */
    public String getPlanetName() {return interactor.getPlanetName();}

    /**
     * gets a list of the SolarSystems in the game
     * @return a list of SolarSystem
     */
    public List<SolarSystem> getSolarSystems() { return interactor.getSolarSystems();}

    /**
     * gets a list of SolarSystem names
     * @return a list of SolarSystem names
     */
    public List<String> getSolarSystemNames() {return interactor.getSolarSystemNames();}

    /**
     * gets a list of SolarSystem distances
     * @return a list of SolarSystem distances
     */
    public List<Integer> getSolarSystemDistances() {return interactor.getSolarSystemDistances();}

    /**
     * gets the amount of fuel a player has
     * @return the amount of fuel a player has
     */
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


    /**
     * police take half the player's money, and all of their narotics and firearms
     */
    @SuppressWarnings({"FeatureEnvy", "MagicNumber"})
    public void bustedByPolice() {
        player = getCurrentPlayer();
        player.setCredits(player.getCredits()*0.5);
        player.sellItem(ItemType.FIREARMS, player.getCargoQuantities().get(ItemType.FIREARMS.ordinal()), 0);
        player.sellItem(ItemType.NARCOTICS, player.getCargoQuantities().get(ItemType.NARCOTICS.ordinal()), 0);
    }

    /**
     * used to have player travel to desired SolarSystem if requirements are met
     * @param solarSystem   the desired SolarSystem to travel to
     */
    public void travelTo(SolarSystem solarSystem) {
        int index = getSolarSystems().indexOf(solarSystem);
        int fuelRequired = getSolarSystemDistances().get(index);
        if (getFuel() >= fuelRequired) {
            interactor.travelTo(solarSystem);
        } else {
            throw new IllegalArgumentException("You need " + fuelRequired + " fuel to travel here");
        }
    }

    /**
     * gets the distance from current SolarSystem to desired SolarSystem
     * @param solarSystem   the desired SolarSystem to travel to
     * @return              the distance from current SolarSystem to desired SolarSystem
     */
    public int getDistanceTo(SolarSystem solarSystem) {return interactor.getDistanceTo(solarSystem);}

    /**
     * gets the current SolarSystem
     * @return  the current SolarSystem
     */
    public SolarSystem getCurrentSolarSystem() {return interactor.getCurrentSolarSystem();}














}