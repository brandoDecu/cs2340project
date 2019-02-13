package com.theLads.spacetrader.model;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

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


    /** all the students known in the application */
    private List<Player> allPlayers;

    /**
     * Make a new Repository object
     */
    public Repository() {
        allPlayers = new ArrayList<>();
    }


    /**
     * get all the students in teh system
     * @return list of all students
     */
    public List<Player> getAllPlayers() { return allPlayers;}


    /** add a new player to the system
     *
     * @param player the student to add
     */
    public void addPlayer(Player player) {
        player.setPlayerId(Repository.getNextUniqueID());
        allPlayers.add(player);
    }

    /**
     * Updates the values stored in a Student
     * @param p the student to update
     */
    public void updatePlayer(Player p) {
        for (Player player: allPlayers) {
            if (player.getPlayerId() == p.getPlayerId()) {
                player.setName(p.getName());
                player.setFighterSkill(p.getFighterSkill());
                player.setPilotSkill(p.getPilotSkill());
                player.setTraderSkill(p.getTraderSkill());
                player.setEngineerSkill(p.getEngineerSkill());
                return;
            }
        }
        Log.d("APP", "Student not found with id = " + p.getPlayerId());
    }
}
