package farmSim;

/**
 * This class implements Farmer Items, extends the Item class.
 * 
 * @author James Harris, Manjeet Panwar
 * @version 6/05/2020
 * @see Item
 */

public class FarmerItem extends Item{
	/**
	 * The amount the item increases the farmers daily actions for one day.
	 */
	private int actionBoostTemporary;
	
	/**
	 * The amount the item increases the farmer daily actions permanently.
	 */
	private int actionBoostPermentant;
	
	
	/**
	 * Constructor for farmer items, calls super with item name.
	 * 
	 * @param itemName the item name
	 * @param tempBoost the value for actionBoostTemporary to be initialized to
	 * @param permBoost the value for actionBoostPermentant to be initialized to
	 */
	public FarmerItem(String itemName, int tempBoost, int permBoost) {
		
		super(itemName);
		this.actionBoostTemporary = tempBoost;
		this.actionBoostPermentant = permBoost;
	}


	/**
	 * Returns the items temporary action boost.
	 * @return actionBoostTemporary
	 */
	public int getActionBoostTemporary() {
		return actionBoostTemporary;
	}

	/**
	 * Returns the items permanent action boost. 
	 * @return actionBoostPermentant
	 */
	public int getActionBoostPermentant() {
		return actionBoostPermentant;
	}

}
