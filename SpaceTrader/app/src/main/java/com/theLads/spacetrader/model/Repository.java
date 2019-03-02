package com.theLads.spacetrader.model;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import com.theLads.spacetrader.entity.Game;
import com.theLads.spacetrader.entity.Player;

/**
 * This class is an abstraction of the data storage for the business classes
 * Normally this would passthrough to our ROOM (database) objects.   To keep this assignment
 * simple, we are just using in-memory storage
 */
public class Repository {

    /***
     * This provides a mechanism to generate simple unique numbers to be used as
     * keys in the application
     */
    private static int next_id = 1;

    private static int getNextUniqueID() {
        return next_id++;
    }

    private Game currentGame;


    /** all the students known in the application */
    private List<Game> allGames;

    /**
     * Make a new Repository object
     */
    public Repository() {
        allGames = new ArrayList<>();
    }


    /**
     * get all the students in teh system
     * @return list of all students
     */
    public List<Game> getAllGames() { return allGames;}

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
