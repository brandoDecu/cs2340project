package com.theLads.spacetrader.model;

import android.util.Log;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.theLads.spacetrader.entity.Game;
import com.theLads.spacetrader.entity.Player;

/**
 * This class is an abstraction of the data storage for the business classes
 * Normally this would pass through to our ROOM (database) objects.   To keep this assignment
 * simple, we are just using in-memory storage
 */
class Repository implements Serializable {

    /***
     * This provides a mechanism to generate simple unique numbers to be used as
     * keys in the application
     */
    private static int next_id = 1;

    /**
     * Gives each new instance a unique ID
     * @return the unique ID
     */
    private static int getNextUniqueID() {
        int result = next_id;
        next_id++;
        return result;
    }

    private Game currentGame;


    /** all the Games known in the application */
    private final List<Game> allGames;

    /**
     * Make a new Repository object
     */
    public Repository() {
        allGames = new ArrayList<>();
    }


    /**
     * get all the games in the system
     * @return list of all students
     */
    public List<Game> getAllGames() { return Collections.unmodifiableList(allGames);}

    /**
     * get current game in system
     * @return current game
     */
    public Game getCurrentGame(){
        return currentGame;
    }

    /** add a new player to the system
     *
     * @param g the game to add
     */
    public void addGame(Game g) {
        g.setGameId(Repository.getNextUniqueID());
        currentGame = g;
        allGames.add(g);
    }




    /**
     * Updates the values stored in a Game. This is useless right now
     * @param g the game to update
     */
    @SuppressWarnings("FeatureEnvy")
    public void updateGame(Game g) {
        for (Game game: allGames) {
            if (game.getGameId() == g.getGameId()) {
                Player player = game.getPlayer();
                Player p = g.getPlayer();
                player.setName(p.getName());
                player.setFighterSkill(p.getFighterSkill());
                player.setPilotSkill(p.getPilotSkill());
                player.setTraderSkill(p.getTraderSkill());
                player.setEngineerSkill(p.getEngineerSkill());
                player.setCredits(p.getCredits());
                player.setShip(p.getShip());
                return;
            }
        }
        Log.d("APP", "Game not found with id = " + g.getGameId());
    }
}
