/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.lodz.uni.math.gamebowling;

import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import pl.lodz.uni.math.exception.*;

/**
 *
 * @author user
 */
public class GameTest {

	static Game game;
	static int firstRoll;
	static int secondRoll;

	public void test() {

	}

	@BeforeClass
	public static void setUpClass() throws FrameException, RollException {

		game = new Game();
		firstRoll = 2;
		secondRoll = 3;
	}

	@AfterClass
	public static void tearDownClass() {
	}

	@Before
	public void setUp() throws FrameException, RollException {

	}

	@After
	public void tearDown() {
	}

	@Test
	public void testPerfectGame() throws FrameException, RollException {
		game.setFirstBonusRoll(new Roll(10));
		game.setSecondBonusRoll(new Roll(10));
		assertEquals((Integer) 300, game.startGame(new Roll(10), new Roll()));
	}

	@Test
	public void testAllSpareGame() throws FrameException, RollException {
		game.setFirstBonusRoll(new Roll(5));

		assertEquals((Integer) 150, game.startGame(new Roll(5), new Roll(5)));
	}

	@Test
	public void testNormalGame() throws FrameException, RollException {
		assertEquals((Integer) 50, game.startGame(new Roll(firstRoll), new Roll(secondRoll)));
	}

}
