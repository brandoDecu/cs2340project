package com.theLads.spacetrader.entity;

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

    public List<Integer> getItemQuantity() {
        return itemQuantity;
    }

    public List<Double> getItemPrice() {
        return itemPrice;
    }

    public void setItemQuantity(ItemType item, int quantity) {
        int index = getItems().indexOf(item);
        itemQuantity.set(index, quantity);
    }
}
