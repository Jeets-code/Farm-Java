package farmSim;


/**
 * Implements Wheat Crop, extends the Crop class, implements Purchaseable interface.
 * 
 * @author James Harris, Manjeet Panwar
 * @version 6/05/2020
 * @see Crop
 */
public class Wheat extends Crop implements Purchaseable{

	/**
	 * Purchase price of Wheat. Static so accessible without instantiation for shop.
	 */
	static int purchasePrice = 60;

	
	/**
	 * description of Wheat. Static so accessible without instantiation for shop.
	 */
	static String description = "Daily Growth Rate: 35%\n"
            + "Sale price: 100\n"
            + "Cost: 60";
	
	
	/**
	 * Creates Wheat object by calling constructor of Crop with,
	 * Wheat attributes.
	 */
	public Wheat() {
		super("Wheat", 100, 35);
	}
	
	
	/**
	 * Creates Wheat object from sale file data.
	 * 
	 * @param currentGrowth currentGrowth
	 * @param dailyGrowthRate dailyGrowthRate
	 */
	public Wheat(int currentGrowth, int dailyGrowthRate) {
		super("Wheat", 100, currentGrowth, dailyGrowthRate);
	}
	
}
