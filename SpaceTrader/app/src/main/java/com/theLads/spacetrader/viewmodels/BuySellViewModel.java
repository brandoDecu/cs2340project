package com.theLads.spacetrader.viewmodels;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.support.annotation.NonNull;
import android.util.Log;

import com.theLads.spacetrader.entity.Game;
import com.theLads.spacetrader.entity.enums.ItemType;
import com.theLads.spacetrader.model.GameInteractor;

import com.theLads.spacetrader.model.Model;

import java.util.List;

public class BuySellViewModel extends AndroidViewModel {
    private final GameInteractor interactor;
    public BuySellViewModel(@NonNull Application application) {
        super(application);
        interactor = Model.getInstance().getGameInteractor();
    }

    public List<Integer> getCargoQuantities() {
        return interactor.getCargoQuantities();
    }

    public List<Double> getMarketPrices() {
        return interactor.getMarketPrices();
    }

    public double getCredits() { return interactor.getCredits();}


    public List<Integer> getMarketQuantities() {
        return interactor.getMarketQuantities();
    }

    public void buyItem(ItemType item, int quantity, double price) {
        if (price * quantity <= getCredits()) {
            interactor.buyItem(item, quantity, price);
        } else {
            throw new IllegalArgumentException("You have insufficient funds");
        }
    }

    public void sellItem(ItemType item, int quantity, double price) {
        if (getCargoQuantities().get(item.ordinal()) >= quantity) {
            interactor.sellItem(item, quantity, price);
        } else {
            throw new IllegalArgumentException("You don't have enough of this item");
        }

    }







}

