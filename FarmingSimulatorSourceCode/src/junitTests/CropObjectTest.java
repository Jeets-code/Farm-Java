package junitTests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import farmSim.Beetroot;
import farmSim.Carrot;
import farmSim.Corn;
import farmSim.Crop;
import farmSim.Lettuce;
import farmSim.Potato;
import farmSim.Wheat;

public class CropObjectTest {

	Crop testCrop;
	
	@Before
	public void setUp() throws Exception {
		testCrop = new Crop("Corn", 20, 20);
	}

	@Test
	public void cropConstructorNormalTest() {
		assertEquals("Corn", testCrop.getCropType());
		assertEquals(0, testCrop.getCurrentGrowth());
		assertEquals(20, testCrop.getSalePrice());
		assertEquals(20, testCrop.getDailyGrowthRate());
		assertEquals("Corn\nCurrent Growth: 0\nDaily Growth Rate: 20\nDays Till"
		        + " Fully Grown: 5\nIs harvestable: false", testCrop.getCropDescription());
		assertEquals(false, testCrop.getIsHarvestable());
	}
	
	@Test
	public void checkReadyToHarvestTest() {
		testCrop.changeCurrentGrowth(100);
		assertEquals(100, testCrop.getCurrentGrowth());
		assertEquals(true, testCrop.getIsHarvestable());
	}
	
	@Test
	public void checkSetGrowthRateTest() {
		testCrop.setDailyGrowthRate(50);
		assertEquals(50, testCrop.getDailyGrowthRate());
	}
	
	@Test
	public void tendCropTest() {
		testCrop.tendCrop(30, 25);
		assertEquals(45, testCrop.getDailyGrowthRate());
		assertEquals(30, testCrop.getCurrentGrowth());
		testCrop.tendCrop(100, 25);
		assertEquals(100, testCrop.getCurrentGrowth());
		assertEquals(true, testCrop.getIsHarvestable());
	}
	
	@Test
	public void calcuateDaysTillGrownTest(){
		testCrop.tendCrop(30, 25);
		assertEquals("Corn\nCurrent Growth: 30\nDaily Growth Rate: 45\nDays "
		        + "Till Fully Grown: 2\nIs harvestable: false", testCrop.getCropDescription());
	}
	
	@Test
	public void cropConstructorSaveFileTest() {
		testCrop = new Crop("Beetroot", 15, 30, 40);
		assertEquals("Beetroot", testCrop.getCropType());
		assertEquals(30, testCrop.getCurrentGrowth());
		assertEquals(15, testCrop.getSalePrice());
		assertEquals(40, testCrop.getDailyGrowthRate());
		assertEquals("Beetroot\nCurrent Growth: 30\nDaily Growth Rate: "
		        + "40\nDays Till Fully Grown: 2\nIs harvestable: false", testCrop.getCropDescription());
		assertEquals(false, testCrop.getIsHarvestable());
	}
	
	@Test
	public void beetrootConstructorTest() {
		Beetroot testBeetroot = new Beetroot();
		assertEquals("Beetroot", testBeetroot.getCropType());
		assertEquals(60, testBeetroot.getSalePrice());
		assertEquals(30, testBeetroot.getDailyGrowthRate());
		
		Beetroot testBeetroot2 = new Beetroot(40, 50);
		assertEquals("Beetroot", testBeetroot2.getCropType());
		assertEquals(60, testBeetroot2.getSalePrice());
		assertEquals(40, testBeetroot2.getCurrentGrowth());
		assertEquals(50, testBeetroot2.getDailyGrowthRate());
	}
	
	@Test
	public void carrotConstructorTest() {
		Carrot testingCrop = new Carrot();
		assertEquals("Carrot", testingCrop.getCropType());
		assertEquals(50, testingCrop.getSalePrice());
		assertEquals(40, testingCrop.getDailyGrowthRate());
		
		Carrot testingCrop2 = new Carrot(40, 50);
		assertEquals("Carrot", testingCrop2.getCropType());
		assertEquals(50, testingCrop2.getSalePrice());
		assertEquals(40, testingCrop2.getCurrentGrowth());
		assertEquals(50, testingCrop2.getDailyGrowthRate());
	}
	
	@Test
	public void cornConstructorTest() {
		Corn testingCrop = new Corn();
		assertEquals("Corn", testingCrop.getCropType());
		assertEquals(100, testingCrop.getSalePrice());
		assertEquals(10, testingCrop.getDailyGrowthRate());
		
		Corn testingCrop2 = new Corn(40, 50);
		assertEquals("Corn", testingCrop2.getCropType());
		assertEquals(100, testingCrop2.getSalePrice());
		assertEquals(40, testingCrop2.getCurrentGrowth());
		assertEquals(50, testingCrop2.getDailyGrowthRate());
	}
	
	@Test
	public void lettuceConstructorTest() {
		Lettuce testingCrop = new Lettuce();
		assertEquals("Lettuce", testingCrop.getCropType());
		assertEquals(90, testingCrop.getSalePrice());
		assertEquals(20, testingCrop.getDailyGrowthRate());
		
		Lettuce testingCrop2 = new Lettuce(40, 50);
		assertEquals("Lettuce", testingCrop2.getCropType());
		assertEquals(90, testingCrop2.getSalePrice());
		assertEquals(40, testingCrop2.getCurrentGrowth());
		assertEquals(50, testingCrop2.getDailyGrowthRate());
	}
	
	@Test
	public void potatoConstructorTest() {
		Potato testingCrop = new Potato();
		assertEquals("Potato", testingCrop.getCropType());
		assertEquals(40, testingCrop.getSalePrice());
		assertEquals(50, testingCrop.getDailyGrowthRate());
		
		Potato testingCrop2 = new Potato(40, 50);
		assertEquals("Potato", testingCrop2.getCropType());
		assertEquals(40, testingCrop2.getSalePrice());
		assertEquals(40, testingCrop2.getCurrentGrowth());
		assertEquals(50, testingCrop2.getDailyGrowthRate());
	}
	
	@Test
	public void wheatConstructorTest() {
		Wheat testingCrop = new Wheat();
		assertEquals("Wheat", testingCrop.getCropType());
		assertEquals(100, testingCrop.getSalePrice());
		assertEquals(35, testingCrop.getDailyGrowthRate());
		
		Wheat testingCrop2 = new Wheat(40, 50);
		assertEquals("Wheat", testingCrop2.getCropType());
		assertEquals(100, testingCrop2.getSalePrice());
		assertEquals(40, testingCrop2.getCurrentGrowth());
		assertEquals(50, testingCrop2.getDailyGrowthRate());
	}
	
	
}
