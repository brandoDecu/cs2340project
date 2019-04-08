package com.theLads.spacetrader.testing;

import com.theLads.spacetrader.entity.Player;
import com.theLads.spacetrader.entity.enums.ShipType;
import org.junit.Test;

import static junit.framework.TestCase.fail;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;

/**
 * JUnit class to test the creation of a Player. Tests for correct credit assignment and skill point
 * assignment. Additionally checks that the player will not be created with more than 16 credits.
 *
 * Author: Zack Vogel
 */

public class PlayerCreationTest {


    @Test
    public final void allEqualNoExtraCredits() {
        Player testPlayer = new Player("Test Player", 4, 4, 4, 4 );
        assertEquals(1000, testPlayer.getCredits(), 0.0);
        assertEquals(4, testPlayer.getEngineerSkill());
        assertEquals(4, testPlayer.getPilotSkill());
        assertEquals(4, testPlayer.getFighterSkill());
        assertEquals(4, testPlayer.getTraderSkill());
        assertEquals(ShipType.GNAT, testPlayer.getShip().getType());
    }

    @Test
    public final void PlayerExtraCredits1() {
        Player testPlayer = new Player("Test Player", 3, 4, 4, 4);
        assertEquals(1100, testPlayer.getCredits(), 0.0);
        assertEquals(4, testPlayer.getEngineerSkill());
        assertEquals(3, testPlayer.getPilotSkill());
        assertEquals(4, testPlayer.getFighterSkill());
        assertEquals(4, testPlayer.getTraderSkill());
        assertEquals(ShipType.GNAT, testPlayer.getShip().getType());
    }

    @Test
    public final void PlayerExtraCredits2() {
        Player testPlayer = new Player("Test Player", 0, 0, 0, 0);
        assertEquals(2600, testPlayer.getCredits(), 0.0);
        assertEquals(0, testPlayer.getEngineerSkill());
        assertEquals(0, testPlayer.getPilotSkill());
        assertEquals(0, testPlayer.getFighterSkill());
        assertEquals(0, testPlayer.getTraderSkill());
        assertEquals(ShipType.GNAT, testPlayer.getShip().getType());
    }

    @Test
    public void testExceptionMessage() {
        try {
            Player testPlayer = new Player("Test Player",
                    17, 0, 0, 0);
            fail("Expected an IllegalArgumentException to be thrown");
        } catch (IllegalArgumentException anIllegalArgumentException) {
            assertThat(anIllegalArgumentException.getMessage(), is("Total " +
                    "skill points for player creation will be " +
                    "less than or equal to 16."));
        }
    }
}
