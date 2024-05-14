package farmSim;

/**
 * Implements Lettuce Crop, extends the Crop class, implements Purchaseable interface.
 * 
 * @author James Harris, Manjeet Panwar
 * @version 6/05/2020
 * @see Crop
 */

public class Lettuce extends Crop implements Purchaseable{
	
	/**
	 * Purchase price of Lettuce. Static so accessible without instantiation for shop.
	 */
	static int purchasePrice = 10;

	
	/**
	 * description of Lettuce. Static so accessible without instantiation for shop.
	 */
	static String description = "Daily Growth Rate: 20%\n"
            + "Sale price: 90\n"
            + "Cost: 10";
	
	/**
	 * Creates Lettuce object by calling constructor of Crop with. 
	 * Lettuce attributes
	 */
	public Lettuce() {
		super("Lettuce", 90, 20);
		
	}
	
	/**
	 * Creates Lettuce object from sale file data.
	 * 
	 * @param currentGrowth currentGrowth
	 * @param dailyGrowthRate dailyGrowthRate
	 */
	public Lettuce(int currentGrowth, int dailyGrowthRate) {
		super("Lettuce", 90, currentGrowth, dailyGrowthRate);
	}
	
}
