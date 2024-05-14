package farmSim;


/**
 * Implements Cow Animal, extends the Animal class, implements Purchaseable interface.
 * 
 * @author James Harris, Manjeet Panwar
 * @version 6/05/2020
 * @see Animal
 */
public class Cow extends Animal implements Purchaseable{
	
	/**
	 * Purchase price of cow. Static so accessible without instantiation for shop.
	 */
	static int purchasePrice = 50;

	
	/**
	 * description of cow. Static so accessible without instantiation for shop.
	 */
	static String description = "A simple farm animal\nCost:"
	        + " 50\nHappiness: 70\nHealth: 70\nBase Income 25";

	
	/**
	 * Creates Cow object by calling constructor of Animal with,
	 * Cow attributes.
	 */
	public Cow() {
		super("Cow", 25);
	}
	
	
	/**
	 * Creates cow object using input parameters for when loading from savefile.
	 * 
	 * @param happiness Animals Happiness From Savefile
	 * @param health Animals Health From Savefile
	 */
	public Cow(int happiness, int health) {
		super("Cow", 25, happiness, health);
	}


}
