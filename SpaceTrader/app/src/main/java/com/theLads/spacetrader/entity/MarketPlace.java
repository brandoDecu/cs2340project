package com.theLads.spacetrader.entity;

import android.content.ClipData;

import com.theLads.spacetrader.entity.enums.ItemType;
import com.theLads.spacetrader.entity.enums.Resources;
import com.theLads.spacetrader.entity.enums.TechLevel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MarketPlace {



    private List<Integer> itemQuantity = new ArrayList<>();

    private List<Double> itemPrice = new ArrayList<>();

    public MarketPlace(TechLevel techLvl, Resources resources) {
        for(ItemType item : ItemType.values()) {
            itemQuantity.add(50);
            itemPrice.add(9.99);
        }
    }

    public List<ItemType> getItems() {
        return new ArrayList<ItemType>(Arrays.asList(ItemType.values()));
    }

    public List<Integer> getMarketQuantities() {
        return itemQuantity;
    }

    public List<Double> getPrices() {
        return itemPrice;
    }

    public double getCostOf(ItemType item) {
        return itemPrice.get(item.getIndex());
    }

    public int getQuantityOf(ItemType item) {
        return itemQuantity.get(item.getIndex());
    }


    public void setItemQuantity(ItemType item, int quantity) {
        itemQuantity.set(item.getIndex(), quantity);
    }


}
