package farmSim;

/**
 * This class implements Animal Items, extends the Item class.
 * 
 * @author James Harris, Manjeet Panwar
 * @version 6/05/2020
 * @see Item
 */
public class AnimalItem extends Item {
	
	
	
	/**
	 * The amount the item increases animal happiness.
	 */
	private int happinessBoost;
	
	/**
	 * The amount the item increases animal health.
	 */
	private int healthBoost;
	
	
	/**
	 * Constructor for Animal item. Calls Super with item name.
	 * 
	 * @param itemName the name of the item
	 * @param happinessBoost the value for happinessBoost to be initialized to
	 * @param healthBoost the value for healthBoost to be initialized to
	 */
	public AnimalItem(String itemName, int happinessBoost, int healthBoost) {
		super(itemName);
		this.happinessBoost = happinessBoost;
		this.healthBoost = healthBoost;
	}

	/**
	 * Returns items happiness Boost.
	 * @return happinessBoost
	 */
	public int getHappinessBoost() {
		return happinessBoost;
	}

	/**
	 * Returns items health Boost.
	 * @return healthBoost
	 */
	public int getHealthBoost() {
		return healthBoost;
	}

}
