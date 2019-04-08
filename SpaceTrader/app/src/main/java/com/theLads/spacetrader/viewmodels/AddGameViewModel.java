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

/**
 * The version of ViewModel for adding a game
 */
public class AddGameViewModel extends AndroidViewModel {

    private final GameInteractor interactor;

    /**
     * AddGameViewModel constructor that creates an AddGameViewModel on new game start
     * @param application
     */
    public AddGameViewModel(@NonNull Application application) {
        super(application);
        interactor = Model.getInstance().getGameInteractor();
    }


    /**
     * Creates a Player and a Game uppon game creation
     * @param diff      difficulty of the new game
     * @param name      name of the player
     * @param pilot     pilot skill of the player
     * @param fighter   fighter skill of the player
     * @param trader    trader skill of the player
     * @param enginr    engineer skill of the player
     */
    public void createGame(GameDifficulty diff, String name, int pilot, int fighter,
                           int trader, int enginr) {
//        validate data here

        Player player = new Player(name, pilot, fighter, trader, enginr);
        Galaxy galaxy = new Galaxy();
        Log.d("Player Made: ", player.toString());
        Game game = new Game(diff, player, galaxy);
        Log.d("Game Made: ", player.toString());
        interactor.addGame(game);
        player.setSolarSystem(galaxy.getCurrentSolarSystem());
    }
}
