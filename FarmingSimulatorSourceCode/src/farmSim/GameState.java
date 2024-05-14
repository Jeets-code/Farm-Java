package farmSim;

/**
 * Game-state holds the information about the current state of the game.
 * 
 * @author James Harris, Manjeet Panwar
 * @version 2/05/2020
 */
public class GameState {
	/**
	 * Games Farm object.
	 */
	private Farm farm;
	
	/**
	 * The current day.
	 */
	private int currentDay;
	
	/**
	 * The number of actions remaining on current day.
	 */
	private int actionsLeft;
	
	/**
	 * The number of days the game will last for.
	 */
	private int numOfDaysGameLasts;
	
	/**
	 * Whether the user had tended the farm-land or not.
	 */
	private boolean hasTendedFarm;
	
	/**
	 * Holds the item the user intends to use to tend their crops,
	 * as they select a crop to tend.
	 */
	private String itemToTendWith;
	
	/**
	 * Initializes the gameState.
	 * Creates new farm, and new farmer, using passed in inputs
	 * Sets the games duration based on numOfDaysGameLasts
	 * Initializes current day to zero, and actions left to 2
	 * Gives the user the water item, which isn't removed on use
	 * 
	 * @param numOfDaysGameLasts Number of days for game to last
	 * @param farmerName The name of the farmer
	 * @param farmName The name of the farm
	 * @param farmType The type of the farm
	 */
	public GameState(int numOfDaysGameLasts, String farmerName, String farmName, String farmType){
		//Create Farm
		this.farm = new Farm(farmName, new Farmer(farmerName), farmType);
		this.numOfDaysGameLasts = numOfDaysGameLasts;
		//Set Values
		this.currentDay = 1;
		this.actionsLeft = 2;
		
		//Give the user the water item.
		farm.addItem(new Water());
	}

	/**
	 * Returns the Farm.
	 * @return Farm Object
	 */
	public Farm getFarm() {
		return farm;
	}

	/**
	 * Returns the current day.
	 * @return Current Day
	 */
	public int getCurrentDay() {
		return currentDay;
	}

	/**
	 * Returns actions left today.
	 * @return actionsLeft
	 */
	public int getActionsLeft() {
		return actionsLeft;
	}

	/**
	 * Returns number of days the game lasts.
	 * @return numOfDaysGameLasts
	 */
	public int getnumOfDaysGameLasts() {
		return numOfDaysGameLasts;
	}

	/**
	 * Increments the currentDay by one.
	 */
	public void incrementCurrentDay() {
		this.currentDay += 1;
	}

	/**
	 * Returns whether or not the user has tended the farm-land.
	 * @return hasTendedFarm
	 */
	public boolean isHasTendedFarm() {
		return hasTendedFarm;
	}

	/**
	 * Sets hasTendedFarm to passed in boolean value.
	 * @param hasTendedFarm value to set hasTendedFarm to
	 */
	public void setHasTendedFarm(boolean hasTendedFarm) {
		this.hasTendedFarm = hasTendedFarm;
	}
	
	/**
	 * Adds amount to actionsLeft.
	 * @param amount the amount to add to actions left
	 */
	public void changeActionsLeft(int amount){
		this.actionsLeft += amount;
	}

	/**
	 * Returns the item to tend with.
	 * @return itemToTendWith
	 */
	public String getItemToTendWith() {
		return itemToTendWith;
	}

	/**
	 * Sets the item to tend with.
	 * @param itemToTendWith The item to tend with
	 */
	public void setItemToTendWith(String itemToTendWith) {
		this.itemToTendWith = itemToTendWith;
	}

	/**
	 * Sets the actions left.
	 * @param actionsLeft the number of actions to set to
	 */
	public void setActionsLeft(int actionsLeft) {
		this.actionsLeft = actionsLeft;
	}


	/**
	 * Sets the current day.
	 * @param currentDay the day for currentDay to be set to
	 */
	public void setCurrentDay(int currentDay) {
		this.currentDay = currentDay;
	}

	/**
	 * Sets numOfDaysGameLasts.
	 * @param numOfDaysGameLasts the number of days for the game to last
	 */
	public void setnumOfDaysGameLasts(int numOfDaysGameLasts) {
		this.numOfDaysGameLasts = numOfDaysGameLasts;
	}
	
	
	
}
