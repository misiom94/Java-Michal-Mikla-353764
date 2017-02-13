/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.lodz.uni.math.gamebowling;

import org.apache.log4j.BasicConfigurator;
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
public class RollTest {
	Roll oneRoll;
	Roll secondRoll;
	Roll exceptionRoll;

	public void test() {

	}

	@BeforeClass
	public static void setUpClass() {

		BasicConfigurator.configure();
	}

	@AfterClass
	public static void tearDownClass() {
	}

	@Before
	public void setUp() throws RollException {
		oneRoll = new Roll(5);
		secondRoll = new Roll();
	}

	@After
	public void tearDown() {
	}
        
        @Test
	public void testGetRollDefaultScoreTest() {
		assertEquals((Integer) 0, secondRoll.getScore());

	}

	@Test
	public void testGetRollScoreTest() {
		assertEquals((Integer) 5, oneRoll.getScore());

	}

	@Test(expected = RollException.class)
	public void testThrowRollScoreExceptionTest() throws RollException {
		exceptionRoll = new Roll(11);
	}

	

}
