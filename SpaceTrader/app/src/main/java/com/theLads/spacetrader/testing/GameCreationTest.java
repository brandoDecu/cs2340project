package com.theLads.spacetrader.testing;

import com.theLads.spacetrader.entity.Galaxy;
import com.theLads.spacetrader.entity.Game;
import com.theLads.spacetrader.entity.Player;
import com.theLads.spacetrader.entity.enums.GameDifficulty;
import com.theLads.spacetrader.entity.enums.ShipType;

import android.app.Application;
import com.theLads.spacetrader.viewmodels.AddGameViewModel;

import org.junit.Test;
import static org.junit.Assert.assertEquals;


/**
 * JUnit class to test the createGame method, which creates an instance of Game, Player, and Galaxy.
 * Tests for correct Player and Game instance created with proper attributes,
 * as well as a non-Null Galaxy of the correct size.
 *
 * Author: Joshua Martin-Jaffe
 */

public class GameCreationTest {

        @Test
        public final void galaxyNotNull() {
            Application application = new Application();
            AddGameViewModel viewModel = new AddGameViewModel(application);
            Galaxy galaxy = new Galaxy();

            viewModel.createGame(GameDifficulty.HARD, "Test", 1, 2, 3, 10);
            Game testG = viewModel.getInteractor().getCurrentGame();

            assert(testG.getGalaxy() != null);
            assertEquals(galaxy.getSolarSystems().size(), testG.getSolarSystems().size());
        }

        @Test
        public final void playerAttributeAssignment() {
            Application application = new Application();
            AddGameViewModel viewModel = new AddGameViewModel(application);
            viewModel.createGame(GameDifficulty.NORMAL, "Test", 3, 5, 7, 1);
            Game testG = viewModel.getInteractor().getCurrentGame();

            assert(testG.getPlayer() != null);

            assertEquals(ShipType.GNAT, testG.getPlayer().getShip().getType());
            assertEquals(1000, testG.getCredits(), 0.0);
            assertEquals("Test", testG.getPlayerName());
            assertEquals(3, testG.getPlayer().getPilotSkill());
            assertEquals(5, testG.getPlayer().getFighterSkill());
            assertEquals(7, testG.getPlayer().getTraderSkill());
            assertEquals(1, testG.getPlayer().getEngineerSkill());
        }

        @Test
        public final void gameAttributeAssignment() {
            Application application = new Application();
            AddGameViewModel viewModel = new AddGameViewModel(application);

            Player testP = new Player("Test", 1, 2, 3, 10);
            Game originalGame = new Game(GameDifficulty.IMPOSSIBLE, testP, new Galaxy());


            viewModel.createGame(GameDifficulty.IMPOSSIBLE, "Test", 1, 2, 3, 10);
            Game testG = viewModel.getInteractor().getCurrentGame();

            assert(testG.getGameId() >= 0);
            assert(testG.getCargoQuantities().equals(originalGame.getCargoQuantities()));
            assertEquals(GameDifficulty.IMPOSSIBLE, testG.getDifficulty());


        }

}
