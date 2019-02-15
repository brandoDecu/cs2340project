package com.theLads.spacetrader.viewmodels;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.support.annotation.NonNull;

import com.theLads.spacetrader.entity.Player;
import com.theLads.spacetrader.model.Model;
import com.theLads.spacetrader.model.PlayerInteractor;

public class EditAddPlayerViewModel extends AndroidViewModel {

    private PlayerInteractor interactor;
    public EditAddPlayerViewModel(@NonNull Application application) {
        super(application);
        interactor = Model.getInstance().getPlayerInteractor();
    }

    public void updatePlayer(Player player ) {
        interactor.updatePlayer(player);
    }

    public void addPlayer(Player player) {

        interactor.addPlayer(player);
    }
}
