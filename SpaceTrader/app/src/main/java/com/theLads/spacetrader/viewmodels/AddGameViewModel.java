package com.theLads.spacetrader.viewmodels;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.support.annotation.NonNull;
import android.util.Log;

import com.theLads.spacetrader.entity.Galaxy;
import com.theLads.spacetrader.entity.Game;
import com.theLads.spacetrader.entity.enums.GameDifficulty;
import com.theLads.spacetrader.entity.Player;
import com.theLads.spacetrader.model.GameInteractor;
import com.theLads.spacetrader.model.Model;

public class AddGameViewModel extends AndroidViewModel {

    private final GameInteractor interactor;
    public AddGameViewModel(@NonNull Application application) {
        super(application);
        interactor = Model.getInstance().getGameInteractor();
    }


    public void createGame(GameDifficulty diff, String name, int pilot, int fighter, int trader, int enginr) {
//        validate data here

        Player player = new Player(name, pilot, fighter, trader, enginr);
        Galaxy galaxy = new Galaxy();
        Log.d("Player Made: ", player.toString());
        Game game = new Game(diff, player, galaxy);
        Log.d("Game Made: ", player.toString());
        interactor.addGame(game);
    }
}
