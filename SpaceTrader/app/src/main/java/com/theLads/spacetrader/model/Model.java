package com.theLads.spacetrader.model;

import com.theLads.spacetrader.entity.Game;
import com.theLads.spacetrader.entity.GameDifficulty;
import com.theLads.spacetrader.entity.Player;

import java.util.HashMap;
import java.util.Map;

/**
 * This class provides all the interactors for the application.
 *
 */

public class Model {
//    Model is a facade so that UI knows nothing about the backend

    /** the data repository */
    private Repository myRepository;

    private Map<String, Object> interactorMap;

    private static  Model instance = new Model();

    public static Model getInstance() { return instance; }



    /**
     * Make a new Model instance
     */
    private Model() {
        myRepository = new Repository();
        interactorMap = new HashMap<>();
        registerInteractors();
    }

    private void registerInteractors() {
        interactorMap.put("Game", new GameInteractor(myRepository));
    }


    public GameInteractor getGameInteractor() {
        return (GameInteractor) interactorMap.get("Game");
    }




}
