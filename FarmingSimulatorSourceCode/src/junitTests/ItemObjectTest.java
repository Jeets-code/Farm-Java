package junitTests;

import static org.junit.Assert.*;

import org.junit.Test;

import farmSim.AnimalItem;
import farmSim.CommonFood;
import farmSim.CropItem;
import farmSim.FarmerItem;
import farmSim.Fertilizer;
import farmSim.Hat;
import farmSim.LuxuryFood;
import farmSim.Pesticide;
import farmSim.ProteinBar;
import farmSim.Water;

public class ItemObjectTest {

	
	@Test
	public void animalItemTest() {
		AnimalItem commonFood = new CommonFood();
		assertEquals(20, commonFood.getHappinessBoost());
		assertEquals(10, commonFood.getHealthBoost());
		assertEquals("CommonFood", commonFood.getItemName());
		
		AnimalItem luxuryFood = new LuxuryFood();
		assertEquals(30, luxuryFood.getHappinessBoost());
		assertEquals(30, luxuryFood.getHealthBoost());
		assertEquals("LuxuryFood", luxuryFood.getItemName());
	}
	
	@Test
	public void cropItemTest() {
		CropItem fertilizer = new Fertilizer();
		assertEquals(40, fertilizer.getGrowthBoostTemporary());
		assertEquals(0, fertilizer.getGrowthBoostPermentant());
		assertEquals("Fertilizer", fertilizer.getItemName());
		
		CropItem pesticide = new Pesticide();
		assertEquals(0, pesticide.getGrowthBoostTemporary());
		assertEquals(30, pesticide.getGrowthBoostPermentant());
		assertEquals("Pesticide", pesticide.getItemName());
		
		CropItem water = new Water();
		assertEquals(10, water.getGrowthBoostTemporary());
		assertEquals(0, water.getGrowthBoostPermentant());
		assertEquals("Water", water.getItemName());
	}
	
	@Test
	public void farmerItemTest() {
		FarmerItem hat = new Hat();
		assertEquals(0, hat.getActionBoostTemporary());
		assertEquals(1, hat.getActionBoostPermentant());
		assertEquals("Hat", hat.getItemName());
		
		FarmerItem proteinBar = new ProteinBar();
		assertEquals(1, proteinBar.getActionBoostTemporary());
		assertEquals(0, proteinBar.getActionBoostPermentant());
		assertEquals("ProteinBar", proteinBar.getItemName());
		
	}

}
