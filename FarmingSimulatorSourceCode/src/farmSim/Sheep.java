package farmSim;


/**
 * Implements Sheep Animal, extends the Animal class, implements Purchaseable interface.
 * 
 * @author James Harris, Manjeet Panwar
 * @version 6/05/2020
 * @see Animal
 */
public class Sheep extends Animal implements Purchaseable{

	/**
	 * Purchase price of Sheep. Static so accessible without instantiation for shop
	 */
	static int purchasePrice = 40;

	
	/**
	 * description of Sheep. Static so accessible without instantiation for shop
	 */
	static String description = "A wooly farm animal\nCost:"
            + " 40\nHappiness: 70\nHealth: 70\nBase Income 20";
	
	
	/**
	 * Creates Sheep object by calling constructor of Animal with, 
	 * Sheep attributes.
	 */
	public Sheep() {
		super("Sheep", 20);	
	}
	
	
	/**
	 * Creates Sheep object using input parameters for when loading from savefile.
	 * 
	 * @param happiness Animals Happiness From Savefile
	 * @param health Animals Health From Savefile
	 */
	public Sheep(int happiness, int health) {
		super("Sheep", 20, happiness, health);
	}

}
