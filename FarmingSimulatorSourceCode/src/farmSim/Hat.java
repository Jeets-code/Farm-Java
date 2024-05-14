package farmSim;

/**
 * Implements Hat Item, extends the FarmerItem class, implements Purchasable interface.
 * 
 * @author James Harris, Manjeet Panwar
 * @version 6/05/2020
 * @see FarmerItem
 */
public class Hat extends FarmerItem implements Purchaseable {

	/**
	 * Purchase price of Hat. Static so accessible without instantiation for shop.
	 */
	static int purchasePrice = 100;

	
	/**
	 * Description of Hat. Static so accessible without instantiation for shop.
	 */
	static String description = "Increasese your daily action limit by 1\nStarts working"
	        + " on new day\nCost: 100";
	
	
	/**
	 * Creates Hat object by calling constructor of FarmerItem with, 
	 * Hat attributes.
	 */
	
	public Hat() {
		super("Hat", 0, 1);
	}

}
