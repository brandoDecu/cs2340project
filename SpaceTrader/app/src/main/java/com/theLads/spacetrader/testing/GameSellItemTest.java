package com.theLads.spacetrader.testing;

import com.theLads.spacetrader.entity.Galaxy;
import com.theLads.spacetrader.entity.Game;
import com.theLads.spacetrader.entity.Player;
import com.theLads.spacetrader.entity.Ship;
import com.theLads.spacetrader.entity.enums.GameDifficulty;
import com.theLads.spacetrader.entity.enums.ItemType;

import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.fail;

public class GameSellItemTest {

    @Test
    public final void sellItem() {
        Player testPlayer = new Player("test", 4,4,4,4);
        Galaxy testGalaxy = new Galaxy();
        Game testGame = new Game(GameDifficulty.EASY, testPlayer, testGalaxy);

        try {
            testGame.sellItem(ItemType.WATER, 1, ItemType.WATER.getBasePrice());
            fail("Expected an exception to be thrown");
        } catch (IllegalArgumentException e) {
            assertThat(e.getMessage(), is("Cargo hold is full"));
        }
    }

    @SuppressWarnings("RedundantCast")
    @Test
    public final void sellWithFullCargo(){
        Player testPlayer = new Player("test", 4,4,4,4);
        Galaxy testGalaxy = new Galaxy();
        Game testGame = new Game(GameDifficulty.EASY, testPlayer, testGalaxy);
        Ship testShip = testPlayer.getShip();
        testShip.setItemQuantity(ItemType.WATER, 2);

        testGame.sellItem(ItemType.WATER, 1, ItemType.WATER.getBasePrice());

        Assert.assertEquals(1020, (int) testPlayer.getCredits());
        Assert.assertEquals(1, (int) testPlayer.getShip().getQuantityOf(ItemType.WATER));
    }


}
