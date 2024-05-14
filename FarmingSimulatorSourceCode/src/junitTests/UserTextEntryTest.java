package junitTests;

import static org.junit.Assert.*;

import farmSim.GameState;
import farmSim.GuiGameEnviroment;

import org.junit.Before;
import org.junit.Test;


public class UserTextEntryTest {
	GuiGameEnviroment testGameEnv;
	
	@Before
	public void setUp() throws Exception {
		testGameEnv = new GuiGameEnviroment();
		testGameEnv.setGameState(new GameState(5, "Jacob", "Jacobs Farm", "BetterAnimals"));
	}

	@Test
	public void testCheckLegalName() {
		assertTrue(testGameEnv.checkLegalName("Jacob"));
		assertTrue(testGameEnv.checkLegalName("xxx"));
		assertTrue(testGameEnv.checkLegalName("abcdefghijklmno"));
		assertFalse(testGameEnv.checkLegalName("abcdefghijklmnop"));
		assertFalse(testGameEnv.checkLegalName("ab"));
		assertFalse(testGameEnv.checkLegalName("123123"));
		assertFalse(testGameEnv.checkLegalName("jcob lstnmae"));
		assertFalse(testGameEnv.checkLegalName("jame5"));
		assertFalse(testGameEnv.checkLegalName(""));
		assertFalse(testGameEnv.checkLegalName("jam5 dfg dfghjkdf 5 dfghjk hjk"));
	}


	@Test
	public void testCheckLegalNumberOfDays() {
		assertTrue(testGameEnv.checkLegalNumberOfDays("5"));
		assertTrue(testGameEnv.checkLegalNumberOfDays("8"));
		assertTrue(testGameEnv.checkLegalNumberOfDays("10"));
		assertFalse(testGameEnv.checkLegalNumberOfDays("4"));
		assertFalse(testGameEnv.checkLegalNumberOfDays("11"));
		assertFalse(testGameEnv.checkLegalNumberOfDays("0"));
		assertFalse(testGameEnv.checkLegalNumberOfDays("100"));
		assertFalse(testGameEnv.checkLegalNumberOfDays("String"));
		assertFalse(testGameEnv.checkLegalNumberOfDays("5a"));
		assertFalse(testGameEnv.checkLegalNumberOfDays("-50"));
	
	}
	
}
