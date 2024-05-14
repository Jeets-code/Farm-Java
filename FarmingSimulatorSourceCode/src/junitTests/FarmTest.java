package junitTests;

import static org.junit.Assert.*;


import org.junit.Before;
import org.junit.Test;

import farmSim.Carrot;
import farmSim.Chicken;
import farmSim.CommonFood;
import farmSim.Corn;
import farmSim.Farm;
import farmSim.Farmer;
import farmSim.Fertilizer;
import farmSim.Hat;
import farmSim.Item;
import farmSim.Potato;
import farmSim.Sheep;

public class FarmTest {

	Farm testFarm;
	
	@Before
	public void setUp() throws Exception {
		testFarm = new Farm("Jacobs Farm", new Farmer("Jacob"), "FastCrops");
		testFarm.addItem(new Hat());
		testFarm.addItem(new CommonFood());
		testFarm.addItem(new Fertilizer());
		testFarm.addNewCrop(new Corn());
		testFarm.addNewCrop(new Potato());
		testFarm.addNewCrop(new Carrot());
		testFarm.addNewAnimal(new Chicken());
		testFarm.addNewAnimal(new Sheep());
	}

	@Test
	public void testIsAnimalArrayFull() {
		assertEquals(false, testFarm.isAnimalArrayFull());
		testFarm.addNewAnimal(new Sheep());
		testFarm.addNewAnimal(new Sheep());
		assertEquals(true, testFarm.isAnimalArrayFull());
	}
	

	@Test
	public void testGetItemsOfTypes() {
		for(Item testItem: testFarm.getItemsOfType(new String[]{"CommonFood"})){
			assertEquals("CommonFood", testItem.getItemName());
		}
		for(Item testItem: testFarm.getItemsOfType(new String[]{"CommonFood", "Fertilizer"})){
			if(testItem.getItemName() == "Fertilizer"){
				assertEquals("Fertilizer", testItem.getItemName());
			}else{
				assertEquals("CommonFood", testItem.getItemName());
			}	
		}	
		
		testFarm.addItem(new CommonFood());
		testFarm.addItem(new CommonFood());
		testFarm.addItem(new CommonFood());
		
		int itemCount = 0;
		for(Item testItem: testFarm.getItemsOfType(new String[]{"CommonFood"})){
			assertEquals("CommonFood", testItem.getItemName());
			itemCount ++;
		}
		
		
		assertEquals(4, itemCount);
	}
	
	
	@Test
	public void testGetItemsOfType() {
		for(Item testItem: testFarm.getItemsOfType("CommonFood")){
			assertEquals("CommonFood", testItem.getItemName());
		}
		for(Item testItem: testFarm.getItemsOfType("Fertilizer")){
			assertEquals("Fertilizer", testItem.getItemName());
		}
		
	}
}
