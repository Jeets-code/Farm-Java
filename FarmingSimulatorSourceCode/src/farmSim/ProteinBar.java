package farmSim;

/**
 * Implements ProteinBar Item, extends the FarmerItem class, implements Purchasable interface.
 * 
 * @author James Harris, Manjeet Panwar
 * @version 6/05/2020
 * @see FarmerItem
 */
public class ProteinBar extends FarmerItem implements Purchaseable {

	
	/**
	 * Purchase price of ProteinBar. Static so accessible without instantiation for shop.
	 */
	static int purchasePrice = 40;

	
	/**
	 * description of ProteinBar. Static so accessible without instantiation for shop.
	 */
	static String description = "Gives you one extra action for the day when consumed\n"
	        + "Cost: 40";
	
	
	/**
	 * Creates ProteinBar object by calling constructor of FarmerItem with,
	 * ProteinBar attributes.
	 */
	
	public ProteinBar() {
		super("ProteinBar", 1, 0);
	}

}
