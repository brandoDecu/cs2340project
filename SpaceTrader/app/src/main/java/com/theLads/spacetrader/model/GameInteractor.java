package com.theLads.spacetrader.model;

import android.util.Log;

import com.theLads.spacetrader.entity.Game;
import com.theLads.spacetrader.entity.Player;


public class GameInteractor extends Interactor {

    public GameInteractor(Repository repo) {
        super(repo);
    }


    public void addGame (Game g) {
        getRepository().addGame(g);
    }

    public void updateGame(Game g) {
        getRepository().updateGame(g);
        Log.d("APP", "Interactor: updating game: " + g);
    }
}