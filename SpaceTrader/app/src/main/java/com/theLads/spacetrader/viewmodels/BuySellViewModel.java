package com.theLads.spacetrader.viewmodels;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.support.annotation.NonNull;

import com.theLads.spacetrader.entity.enums.ItemType;
import com.theLads.spacetrader.model.GameInteractor;

import com.theLads.spacetrader.model.Model;

import java.util.List;

/**
 * The version of ViewModel for buying and selling
 */
public class BuySellViewModel extends AndroidViewModel {
    private final GameInteractor interactor;

    /**
     * BuySellViewModel constructor created when buying or selling
     * @param application the application passed onto the AndroidViewModel super constructor
     */
    public BuySellViewModel(@NonNull Application application) {
        super(application);
        interactor = Model.getInstance().getGameInteractor();
    }

    /**
     * gets a list of quantities of items in cargo
     * @return a list of quantities of items in cargo
     */
    public List<Integer> getCargoQuantities() {
        return interactor.getCargoQuantities();
    }

// --Commented out by Inspection START (4/1/2019 10:58 AM):
//    public List<Double> getMarketPrices() {
//        return interactor.getMarketPrices();
//    }
// --Commented out by Inspection STOP (4/1/2019 10:58 AM)


    /**
     * gets credits
     * @return credits
     */
    public double getCredits() { return interactor.getCredits();}


    /**
     * gets a list of quantities of items in market
     * @return a list of quantities of items in market
     */
    public List<Integer> getMarketQuantities() {
        return interactor.getMarketQuantities();
    }

    /**
     * gets market prices
     * @return market prices
     */
    public List<Double> getMarketPrices() {
        return interactor.getMarketPrices();
    }

    /**
     * buys an item for the player if requiremnts are met
     * @param item      the ItemType desired
     * @param quantity  the quantity desired
     * @param price     the price desired
     */
    public void buyItem(ItemType item, int quantity, double price) {
        if ((price * quantity) <= getCredits()) {
            interactor.buyItem(item, quantity, price);
        } else {
            throw new IllegalArgumentException("You have insufficient funds");
        }
    }

    /**
     * sells an item for the player if requiremnts are met
     * @param item      the ItemType desired to be sold
     * @param quantity  the quantity desired to be sold
     * @param price     the price desired to be sold
     */
    public void sellItem(ItemType item, int quantity, double price) {
        if (getCargoQuantities().get(item.ordinal()) >= quantity) {
            interactor.sellItem(item, quantity, price);
        } else {
            throw new IllegalArgumentException("You don't have enough of this item");
        }

    }







}

