package farmSim;

/**
 * This class is the superclass for farm Animals objects.
 *
 * @author James Harris, Manjeet Panwar
 * @version 6/05/2020
 */
public class Animal {

    /**
     * The type of the Animal.
     */
    private String animalType;

    /**
     * The base income of the Animal.
     */
    private int baseIncome;

    /**
     * The health of the animal.
     */
    private int health;

    /**
     * The happiness of the animal.
     */
    private int happiness;

    /**
     * A constant value for the happiness benefit of playing with an animal.
     */
    private final int PLAY_WITH_HAPINESS_BOOST;

    /**
     * Constructor for animal.
     *
     * @param animalType
     *            the type of the animal
     * @param baseIncome
     *            the base income of the animal
     */
    public Animal(String animalType, int baseIncome) {
        this.health = 70;
        this.happiness = 70;
        PLAY_WITH_HAPINESS_BOOST = 20;
        
        this.animalType = animalType;
        this.baseIncome = baseIncome;
        

    }

    /**
     * Save File constructor for Animal.
     *
     * @param animalType
     *            Animals Type
     * @param baseIncome
     *            Animals Base Income
     * @param happiness
     *            Animals Happiness from saveFile
     * @param health
     *            Animals Health from saveFile
     */
    public Animal(String animalType, int baseIncome, int happiness, int health) {
        this.animalType = animalType;
        this.baseIncome = baseIncome;
        this.health = health;
        this.happiness = happiness;
        PLAY_WITH_HAPINESS_BOOST = 15;

    }

    /**
     * Returns animals health.
     *
     * @return health
     */

    public int getHealth() {
        return this.health;
    }

    /**
     * Returns animals happiness.
     *
     * @return happiness
     */
    public int getHappiness() {
        return this.happiness;
    }

    /**
     * Decreases animals health by amount.
     *
     * @param amount
     *            the amount for health to change by
     */
    public void changeHealth(int amount) {
        this.health -= amount;
    }

    /**
     * Decreases animals happiness by amount.
     * 
     * @param amount
     *            the amount for happiness to change by
     */
    public void changeHappiness(int amount) {
        this.happiness -= amount;
    }

    /**
     * Returns animals type.
     * 
     * @return animalType
     */
    public String getAnimalType() {
        return this.animalType;
    }

    /**
     * Calculates and returns animals income.
     * 
     * @return animals income in float form
     */
    public float getIncome() {
        return (baseIncome * (((float) health / 100)) * ((float) happiness / 100));
    }

    /**
     * Adds the constant PLAYWITHHAPINESSBOOST to health.
     */
    public void playWithAnimal() {
        this.happiness += PLAY_WITH_HAPINESS_BOOST;
    }

    /**
     * Adds happiness and health to animal.
     * 
     * @param happiness
     *            happiness to be added
     * @param health
     *            health to be added
     */
    public void feedAnimal(int happiness, int health) {
        this.happiness += happiness;
        this.health += health;
    }

    /**
     * Returns base income.
     *
     * @return baseIncome
     */
    public int getBaseIncome() {
        return baseIncome;
    }

    /**
     * Returns a Textual Description of the animals Current state, including
     * type, health, and happiness.
     *
     * @return Description of Animal
     */
    public String getAnimalDescription() {
        return this.animalType + "\nHappiness: " + this.happiness
                + "\nHealth: " + this.getHealth();
    }

}
