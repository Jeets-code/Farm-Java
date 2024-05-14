package farmSim;

/**
 * This class implements Crop Items, extends the Item class.
 * 
 * @author James Harris, Manjeet Panwar
 * @version 6/05/2020
 * @see Item
 */
public class CropItem extends Item {
	
	/**
	 * The amount the item increases the current growth of the Crop.
	 */
	private int growthBoostTemporary;
	
	/**
	 * The amount the item increases the daily growth rate of the crop.
	 */
	private int growthBoostPermentant;
	
	/**
	 * Constructor for Crop items, calls super with item name.
	 * 
	 * @param itemName the name of the item
	 * @param growthBoostTemporary the value for growthBoostTemporary to be initialized to
	 * @param growthBoostPermentant the value for growthBoostPermentant to be initialized to
	 */
	public CropItem(String itemName, int growthBoostTemporary, int growthBoostPermentant) {
		super(itemName);
		this.growthBoostTemporary = growthBoostTemporary;
		this.growthBoostPermentant = growthBoostPermentant;
		
	}

	/**
	 * Returns the temporary growth boost.
	 * @return growthBoostTemporary
	 */
	public int getGrowthBoostTemporary() {
		return growthBoostTemporary;
	}

	/**
	 * Returns the permanent growth boost.
	 * @return growthBoostPermentant
	 */
	public int getGrowthBoostPermentant() {
		return growthBoostPermentant;
	}

}
