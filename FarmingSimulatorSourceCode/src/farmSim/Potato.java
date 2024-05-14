package farmSim;


/**
 * Implements Potato Crop, extends the Crop class, implements Purchaseable interface.
 * 
 * @author James Harris, Manjeet Panwar
 * @version 6/05/2020
 * @see Crop
 */
public class Potato extends Crop implements Purchaseable{

	/**
	 * Purchase price of Potato. Static so accessible without instantiation for shop
	 */
	static int purchasePrice = 20;

	
	/**
	 * description of Potato. Static so accessible without instantiation for shop
	 */
	static String description = "Daily Growth Rate: 50%\n"
            + "Sale price: 40\n"
            + "Cost: 20";
	
	/**
	 * Creates Potato object by calling constructor of Crop with.
	 * Potato attributes
	 */
	public Potato() {
		super("Potato", 40, 50);
	}
	
	
	/**
	 * Creates Potato object from sale file data.
	 * 
	 * @param currentGrowth currentGrowth
	 * @param dailyGrowthRate dailyGrowthRate
	 */
	public Potato(int currentGrowth, int dailyGrowthRate) {
		super("Potato", 40, currentGrowth, dailyGrowthRate);
	}

}
