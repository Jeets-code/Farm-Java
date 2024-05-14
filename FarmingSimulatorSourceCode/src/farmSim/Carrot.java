package farmSim;

/**
 * Implements Carrot Crop, extends the Crop class, implements Purchaseable interface.
 * 
 * @author James Harris, Manjeet Panwar
 * @version 6/05/2020
 * @see Crop
 */

public class Carrot extends Crop implements Purchaseable{

	/**
	 * Purchase price of Carrot. Static so accessible without instantiation for shop
	 */
	static int purchasePrice = 30;

	
	/**
	 * description of Carrot. Static so accessible without instantiation for shop
	 */
	static String description = "Daily Growth Rate: 40%\n"
            + "Sale price: 50\n"
            + "Cost: 30";
	
	/**
	 * Creates Carrot object by calling constructor of Crop with, 
	 * Carrots attributes.
	 */
	public Carrot() {
		//cropType, salePrice, dailyGrowthRate
		super("Carrot", 50, 40);
		
	}

	
	/**
	 * Creates Carrot object from sale file data.
	 * 
	 * @param currentGrowth currentGrowth
	 * @param dailyGrowthRate dailyGrowthRate
	 */
	public Carrot(int currentGrowth, int dailyGrowthRate) {
		super("Carrot", 50, currentGrowth, dailyGrowthRate);
	}

}
