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

    /** the data repository */
    private Repository myRepository;

    private Map<String, Object> interactorMap;

    private Game game;

    private Player player;

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

//    public void createGame(GameDifficulty diff,String id, int pilot, int fighter, int trader, int enginr, int name) {
//        game = new Game(diff);
//        player = new Player(id, pilot, fighter, trader, enginr, name)
//    }

}
