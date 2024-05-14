package junitTests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import farmSim.Farm;
import farmSim.GameState;

public class GameStateTest {

	GameState testGameState;
	
	@Before
	public void setUp() throws Exception {
		testGameState = new GameState(5, "Jacob", "Jacobs Farm", "FastCrops");
	}

	@Test
	public void testGameStateConstructor() {
		assertEquals(2, testGameState.getActionsLeft());
		assertEquals(1, testGameState.getCurrentDay());
		assertEquals(null, testGameState.getItemToTendWith());
		assertEquals(5, testGameState.getnumOfDaysGameLasts());
		assertEquals(false, testGameState.isHasTendedFarm());
	}
	
	
	
	@Test
	public void testSetters() {
		testGameState.setActionsLeft(5);
		assertEquals(5, testGameState.getActionsLeft());
		testGameState.setCurrentDay(9);
		assertEquals(9, testGameState.getCurrentDay());
		testGameState.setHasTendedFarm(true);
		assertEquals(true, testGameState.isHasTendedFarm());
		testGameState.setItemToTendWith("Water");
		assertEquals("Water", testGameState.getItemToTendWith());
		testGameState.setnumOfDaysGameLasts(15);
		assertEquals(15, testGameState.getnumOfDaysGameLasts());
	}
	
	
	@Test
	public void testIncrementCurrentDay() {
		testGameState.incrementCurrentDay();
		assertEquals(2, testGameState.getCurrentDay());
		testGameState.incrementCurrentDay();
		testGameState.incrementCurrentDay();
		assertEquals(4, testGameState.getCurrentDay());
	}
	
	@Test
	public void testChangeActionsLeft() {
		testGameState.changeActionsLeft(2);
		assertEquals(4, testGameState.getActionsLeft());
		testGameState.changeActionsLeft(5);
		assertEquals(9, testGameState.getActionsLeft());
	}
	
	@Test
	public void testGetFarm() {
		Farm testFarm = testGameState.getFarm();
		assertEquals("Jacobs Farm", testFarm.getFarmName());
	}

}
