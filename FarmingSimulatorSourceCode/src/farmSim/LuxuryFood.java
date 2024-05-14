package farmSim;

/**
 * Implements LuxuryFood Item, extends the AnimalItem class, implements Purchasable interface.
 * 
 * @author James Harris, Manjeet Panwar
 * @version 6/05/2020
 * @see AnimalItem
 */
public class LuxuryFood extends AnimalItem implements Purchaseable {

	
	/**
	 * Purchase price of LuxuryFood. Static so accessible without instantiation for shop.
	 */
	static int purchasePrice = 50;

	
	/**
	 * description of LuxuryFood. Static so accessible without instantiation for shop.
	 */
	static String description = "A luxury food choice for animals.\n"
            + "Increases happiness by 30%\n"
            + "Increases health by 30%\n"
            + "Cost: 50";
	

	/**
	 * Creates LuxuryFood object by calling constructor of AnimalItem with, 
	 * LuxuryFood attributes.
	 */
	public LuxuryFood() {
		super("LuxuryFood", 30, 30);
	}

}
