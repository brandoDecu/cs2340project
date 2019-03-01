package com.theLads.spacetrader.entity;

import com.theLads.spacetrader.entity.enums.ItemType;
import com.theLads.spacetrader.entity.enums.Resources;
import com.theLads.spacetrader.entity.enums.TechLevel;

import java.util.HashMap;
import java.util.Map;

public class MarketPlace {



    Map<ItemType, Integer> itemQuantity = new HashMap<>();

    Map<ItemType, Integer> itemPrice = new HashMap<>();

    public MarketPlace(TechLevel techLvl, Resources resources) {
        for(ItemType item : ItemType.values()) {
            itemQuantity.put(item, 10);
            itemPrice.put(item,20);
        }
    }

    public Map<ItemType, Integer> getItemQuantity() {
        return itemQuantity;
    }

    public Map<ItemType, Integer> getItemPrice() {
        return itemPrice;
    }
}
