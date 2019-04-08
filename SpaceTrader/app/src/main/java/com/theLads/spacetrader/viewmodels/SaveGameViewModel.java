package com.theLads.spacetrader.viewmodels;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.support.annotation.NonNull;

import com.theLads.spacetrader.model.GameInteractor;
import com.theLads.spacetrader.model.Model;

public class SaveGameViewModel extends AndroidViewModel {
    private final GameInteractor interactor;


    public SaveGameViewModel(@NonNull Application application) {
        super(application);
        interactor = Model.getInstance().getGameInteractor();
    }

    public String getPlayerName() {
        return interactor.getPlayerName();
    }


}
