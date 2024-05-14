package farmSim;

/**
 * Implements Beetroot Crop, extends the Crop class, implements Purchaseable interface.
 * 
 * @author James Harris, Manjeet Panwar
 * @version 6/05/2020
 * @see Crop
 */

public class Beetroot extends Crop implements Purchaseable{

	
	/**
	 * Purchase price of Beetroot. Static so accessible without instantiation for shop.
	 */
	static int purchasePrice = 30;

	
	/**
	 * description of Beetroot. Static so accessible without instantiation for shop.
	 */
	static String description = "Daily Growth Rate: 30%\n"
	        + "Sale price: 60\n"
	        + "Cost: 30";
	
	/**
	 * Creates Beetroot object by calling constructor of Crop with, 
	 * Beetroot attributes.
	 */
	public Beetroot() {
		super("Beetroot", 60, 30);
	}
	
	
	/**
	 * Creates Beetroot object from sale file data.
	 * 
	 * @param currentGrowth currentGrowth
	 * @param dailyGrowthRate dailyGrowthRate
	 */
	public Beetroot(int currentGrowth, int dailyGrowthRate) {
		super("Beetroot", 60, currentGrowth, dailyGrowthRate);
	}

}
