package farmSim;

/**
 * Implements CommonFood Item, extends the AnimalItem class, implements Purchasable interface.
 * 
 * @author James Harris, Manjeet Panwar
 * @version 6/05/2020
 * @see AnimalItem
 */
public class CommonFood extends AnimalItem implements Purchaseable {


	/**
	 * Purchase price of CommonFood. Static so accessible without instantiation for shop.
	 */
	static int purchasePrice = 25;

	
	/**
	 * description of CommonFood. Static so accessible without instantiation for shop.
	 */
	static String description = "A basic food choice for animals.\n"
	        + "Increases happiness by 20%\n"
	        + "Increases health by 10%\n"
	        + "Cost: 25";
	
	
	/**
	 * Creates CommonFood object by calling constructor of AnimalItem with, 
	 * CommonFood attributes.
	 */
	public CommonFood() {
		super("CommonFood", 20, 10);
	}

}
