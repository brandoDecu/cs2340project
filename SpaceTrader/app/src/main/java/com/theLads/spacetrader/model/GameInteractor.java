package com.theLads.spacetrader.model;

import android.util.Log;

import com.theLads.spacetrader.entity.Game;
import com.theLads.spacetrader.entity.Player;
import com.theLads.spacetrader.entity.enums.ItemType;

import java.util.List;


public class GameInteractor extends Interactor {

    public GameInteractor(Repository repo) {
        super(repo);
    }


    public void addGame (Game g) {
        getRepository().addGame(g);
    }


    public Game getCurrentGame() {
        return getRepository().getCurrentGame();
    }


    public List<Integer> getCargoQuantities() {
        return getCurrentGame().getCargoQuantities();
    }

    public List<Double> getMarketPrices() {
        return getCurrentGame().getMarketPrices();
    }

    public List<Integer> getMarketQuantities() {
        return getCurrentGame().getMarketQuantities();
    }

    public void buyItem(ItemType item, int quantity, double price) {
        getCurrentGame().buyItem(item, quantity, price);
    }

    public void sellItem(ItemType item, int quantity, double price) {
        getCurrentGame().sellItem(item, quantity, price);
    }

    public double getCredits() {return getCurrentGame().getCredits();}
}