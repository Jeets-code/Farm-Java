package junitTests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import farmSim.Farmer;

public class FarmerObjectTest {
	Farmer testFarmer;

	@Before
	public void setUp() throws Exception {
		testFarmer = new Farmer("Jacob");
	}

	@Test
	public void testFarmerConstructor() {
		assertEquals(2, testFarmer.getDailyActions());
		assertEquals(40, testFarmer.getFarmerAge());
		assertEquals("Jacob", testFarmer.getFarmerName());
		assertEquals(0, testFarmer.getmoneyScore());
		
	}
	
	@Test
	public void testIncreseDailyActions() {
		testFarmer.increseDailyActions(2);
		assertEquals(4, testFarmer.getDailyActions());
	}
	
	@Test
	public void testchangeMoneyScore() {
		testFarmer.changeMoneyScore(50);
		assertEquals(50, testFarmer.getmoneyScore());
	}
	
	@Test
	public void testSetters() {
		testFarmer.setDailyActions(5);
		testFarmer.setFarmerAge(20);
		testFarmer.setMoneyScore(40);
		assertEquals(40, testFarmer.getmoneyScore());
		assertEquals(20, testFarmer.getFarmerAge());
		assertEquals(5, testFarmer.getDailyActions());
	}

}
