package com.example.spacetrader.model;

import java.util.HashMap;
import java.util.Map;

/**
 * This class provides all the interactors for the application.
 *
 */

public class Model {

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
        interactorMap.put("Player", new PlayerInteractor(myRepository));
    }


    public PlayerInteractor getPlayerInteractor() {
        return (PlayerInteractor) interactorMap.get("Player");
    }
}
