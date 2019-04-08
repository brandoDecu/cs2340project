package com.theLads.spacetrader.entity;

import com.theLads.spacetrader.entity.enums.ItemType;
import com.theLads.spacetrader.entity.enums.Resources;
import com.theLads.spacetrader.entity.enums.TechLevel;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

class MarketPlace implements Serializable {


    private final List<Integer> itemQuantity = new ArrayList<>();

    private final List<Double> itemPrice = new ArrayList<>();

    MarketPlace(TechLevel techLvl, Resources resources) {
        for(ItemType item : ItemType.values()) {
            //noinspection MagicNumber
            itemQuantity.add((new Random().nextInt(40)+10));
            itemPrice.add((item.getBasePrice()*(item.ordinal() + 1))/(resources.ordinal() +
                    techLvl.ordinal() + 1));
        }
    }

    List<Integer> getMarketQuantities() {
        return Collections.unmodifiableList(itemQuantity);
    }

    List<Double> getPrices() {
        return Collections.unmodifiableList(itemPrice);
    }


    int getQuantityOf(ItemType item) {
        return itemQuantity.get(item.ordinal());
    }


    void setItemQuantity(ItemType item, int quantity) {
        itemQuantity.set(item.ordinal(), quantity);
    }

}
