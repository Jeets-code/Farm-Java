package farmSim;

/**
 * Implements Corn Crop, extends the Crop class, implements Purchaseable interface.
 * 
 * @author James Harris, Manjeet Panwar
 * @version 6/05/2020
 * @see Crop
 */

public class Corn extends Crop implements Purchaseable{

	/**
	 * Purchase price of Corn. Static so accessible without instantiation for shop.
	 */
	static int purchasePrice = 20;

	
	/**
	 * description of Corn. Static so accessible without instantiation for shop.
	 */
	static String description = "Daily Growth Rate: 10%\n"
            + "Sale price: 100\n"
            + "Cost: 20";
	
	/**
	 * Creates Corn object by calling constructor of Crop with, 
	 * Corns attributes.
	 */
	
	public Corn() {
		super("Corn", 100, 10);
	}

	
	/**
	 * Creates Corn object from sale file data.
	 * 
	 * @param currentGrowth currentGrowth
	 * @param dailyGrowthRate dailyGrowthRate
	 */
	public Corn(int currentGrowth, int dailyGrowthRate) {
		super("Corn", 100, currentGrowth, dailyGrowthRate);
	}
}
