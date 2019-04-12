package com.theLads.spacetrader.testing;

import com.theLads.spacetrader.entity.Galaxy;
import com.theLads.spacetrader.entity.Game;
import com.theLads.spacetrader.entity.Player;
import com.theLads.spacetrader.entity.SolarSystem;
import com.theLads.spacetrader.entity.enums.GameDifficulty;
import com.theLads.spacetrader.viewmodels.TravelViewModel;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.fail;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * JUnit class to test the creation of a Player. Tests for correct credit assignment and skill point
 * assignment. Additionally checks that the player will not be created with more than 16 credits.
 *
 * Author: Brando de Courten
 */

public class TravelTest {
    private Player player;
    private Galaxy galaxy;
    private Game game;
    private TravelViewModel viewModel;


    @Before
    public void setUp() {
        player = new Player("Darren", 4, 4, 4, 4);
        galaxy = new Galaxy();
        game = new Game(GameDifficulty.BEGINNER, player, galaxy);
        player.setFuel(100000);
    }

    @Test
    public void travelToPlanet1() {
        //travels to Fitness
        SolarSystem starting = galaxy.getCurrentSolarSystem();
        int distance = galaxy.getDistanceTo(galaxy.getSolarSystems().get(1));
        game.travelTo(galaxy.getSolarSystems().get(1));
        Assert.assertEquals(galaxy.getSolarSystems().get(1), galaxy.getCurrentSolarSystem());
        Assert.assertEquals(100000 - distance, player.getFuel());
    }

    @Test
    public void travelToPlanet2() {
        //travels to Fitness
        SolarSystem starting = galaxy.getCurrentSolarSystem();
        int distance = galaxy.getDistanceTo(galaxy.getSolarSystems().get(2));
        game.travelTo(galaxy.getSolarSystems().get(2));
        Assert.assertEquals(galaxy.getSolarSystems().get(2), galaxy.getCurrentSolarSystem());
        Assert.assertEquals(100000 - distance, player.getFuel());
    }

    @Test
    public void travelToPlanet3() {
        //travels to Fitness
        SolarSystem starting = galaxy.getCurrentSolarSystem();
        int distance = galaxy.getDistanceTo(galaxy.getSolarSystems().get(3));
        game.travelTo(galaxy.getSolarSystems().get(3));
        Assert.assertEquals(galaxy.getSolarSystems().get(3), galaxy.getCurrentSolarSystem());
        Assert.assertEquals(100000 - distance, player.getFuel());
    }

    @Test
    public void travelToPlanetNotInGalaxy() {
        //travels to Fitness
        SolarSystem starting = galaxy.getCurrentSolarSystem();
        SolarSystem newSS = new SolarSystem("newSS");
        try {
            game.travelTo(newSS);
            fail("Expected an IllegalArgumentException to be thrown");
        } catch (IllegalArgumentException anIllegalArgumentException) {
            assertThat(anIllegalArgumentException.getMessage(), is("SolarSystem: "
                    + newSS.getName() + " is not in the galaxy"));
        }

        Assert.assertEquals(starting, galaxy.getCurrentSolarSystem());
        Assert.assertEquals(100000, player.getFuel());
    }

    @Test
    public void travelWithNoFuel() {
        player.setFuel(0);
        //travels to Fitness
        SolarSystem starting = galaxy.getCurrentSolarSystem();
        int distance = galaxy.getDistanceTo(galaxy.getSolarSystems().get(3));
        try {
            game.travelTo(galaxy.getSolarSystems().get(3));
            fail("Expected an IllegalArgumentException to be thrown");
        } catch (IllegalArgumentException anIllegalArgumentException) {
            assertThat(anIllegalArgumentException.getMessage(), is("You need " + distance
                    + " fuel to travel here"));
        }

        Assert.assertEquals(starting, galaxy.getCurrentSolarSystem());
        Assert.assertEquals(0, player.getFuel());
    }









}
