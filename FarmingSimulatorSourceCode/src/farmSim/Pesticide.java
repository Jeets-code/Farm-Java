package farmSim;

/**
 * Implements Pesticide Item, extends the CropItem class, implements Purchasable interface.
 * 
 * @author James Harris, Manjeet Panwar
 * @version 6/05/2020
 * @see CropItem
 */
public class Pesticide extends CropItem implements Purchaseable {
	
	/**
	 * Purchase price of Pesticide. Static so accessible without instantiation for shop.
	 */
	static int purchasePrice = 30;

	
	/**
	 * description of Pesticide. Static so accessible without instantiation for shop.
	 */
	static String description = "Increases daily growth rate of a crop by 30%\nCost: 30";	
	
	/**
	 * Creates Pesticide object by calling constructor of CropItem with,
	 * Pesticide attributes.
	 */
	public Pesticide() {
		super("Pesticide", 0, 30);
		
	}

}