package com.theLads.spacetrader.viewmodels;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.support.annotation.NonNull;
import android.util.Log;

import com.theLads.spacetrader.entity.Game;
import com.theLads.spacetrader.model.GameInteractor;

import com.theLads.spacetrader.model.Model;

public class BuySellViewModel extends AndroidViewModel {
    private GameInteractor interactor;
    public BuySellViewModel(@NonNull Application application) {
        super(application);
        interactor = Model.getInstance().getGameInteractor();
    }

}

