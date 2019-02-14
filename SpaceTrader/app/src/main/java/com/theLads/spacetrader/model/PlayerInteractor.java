package com.theLads.spacetrader.model;

import android.util.Log;

import com.theLads.spacetrader.entity.Player;


public class PlayerInteractor extends Interactor {

    public PlayerInteractor(Repository repo) {
        super(repo);
    }


    public void addPlayer (Player p) {
        getRepository().addPlayer(p);
    }

    public void updatePlayer(Player p) {
        getRepository().updatePlayer(p);
        Log.d("APP", "Interactor: updating player: " + p);
    }
}
