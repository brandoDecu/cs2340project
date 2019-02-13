package com.example.spacetrader.viewmodels;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.support.annotation.NonNull;

import com.example.spacetrader.entity.Player;
import com.example.spacetrader.model.Model;
import com.example.spacetrader.model.PlayerInteractor;

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
