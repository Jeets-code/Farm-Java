package farmSim;


/**
 * Implements Chicken Animal, extends the Animal class, implements Purchaseable interface.
 * 
 * @author James Harris, Manjeet Panwar
 * @version 6/05/2020
 * @see Animal
 */
public class Chicken extends Animal implements Purchaseable{

	/**
	 * Purchase price of Chicken. Static so accessible without instantiation for shop.
	 */
	static int purchasePrice = 30;

	
	/**
	 * description of Chicken. Static so accessible without instantiation for shop.
	 */
	static String description = "A feathery farm animal\nCost:"
            + " 30\nHappiness: 70\nHealth: 70\nBase Income 15";
	
	/**
	 * Creates Chicken object by calling constructor of Animal with,
	 * Chicken attributes.
	 */
	public Chicken() {
		super("Chicken", 15);
		
	}
	
	/**
	 * Creates Chicken object using input parameters for when loading from savefile.
	 * 
	 * @param happiness Animals Happiness From Savefile
	 * @param health Animals Health From Savefile
	 */
	public Chicken(int happiness, int health) {
		super("Chicken", 15, happiness, health);
	}

}
