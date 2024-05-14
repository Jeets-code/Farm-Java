package farmSim;

/**
 * Implements Fertilizer Item, extends the CropItem class, implements Purchasable interface.
 * 
 * @author James Harris, Manjeet Panwar
 * @version 6/05/2020
 * @see CropItem
 */
public class Fertilizer extends CropItem implements Purchaseable {
	
	/**
	 * Purchase price of Fertilizer. Static so accessible without instantiation for shop.
	 */
	static int purchasePrice = 20;

	
	/**
	 * description of Fertilizer. Static so accessible without instantiation for shop.
	 */
	static String description = "Instantly increases crop growth by 40%\nCost: 20";
	
	
	/**
	 * Creates Fertilizer object by calling constructor of CropItem with, 
	 * LuxuryFood attributes.
	 */
	public Fertilizer() {
		super("Fertilizer", 40, 0);
		
	}

}
