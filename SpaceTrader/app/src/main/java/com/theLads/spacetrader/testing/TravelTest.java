package com.theLads.spacetrader.testing;

import com.theLads.spacetrader.entity.Galaxy;
import com.theLads.spacetrader.entity.Game;
import com.theLads.spacetrader.entity.Player;
import com.theLads.spacetrader.entity.SolarSystem;
import com.theLads.spacetrader.entity.enums.GameDifficulty;
import com.theLads.spacetrader.entity.enums.ShipType;
import com.theLads.spacetrader.model.GameInteractor;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static junit.framework.TestCase.fail;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;

/**
 * JUnit class to test the creation of a Player. Tests for correct credit assignment and skill point
 * assignment. Additionally checks that the player will not be created with more than 16 credits.
 *
 * Author: Brando de Courten
 */

public class TravelTest {
    private static Player player;
    private static Galaxy galaxy;
    private static Game game;

    @Before
    public static void setUp() {
        player = new Player("Darren", 4, 4, 4, 4);
        galaxy = new Galaxy();
        game = new Game(GameDifficulty.BEGINNER, player, galaxy);

    }


    @Test
    public static void travelWithNoFuel() {
        //travels to Fitness
        SolarSystem starting = galaxy.getCurrentSolarSystem();
        galaxy.travelTo(galaxy.getSolarSystems().get(0));
        Assert.assertEquals(galaxy.getCurrentSolarSystem(), starting);
    }

}
