package farmSim;

import java.util.ArrayList;

/**
 * Farm object holds information about the state of the farm.
 * @author James Harris, Manjeet Panwar
 * @version 8/05/2020
 */
public class Farm {

	/**
	 * Farms name.
	 */
	private String farmName;
	
	/**
	 * Farmer object belonging to the farm.
	 */
	private Farmer userFarmer;
	
	/**
	 * Type of the farm.
	 */
	private String farmType;
	
	/**
	 * List of animals on the farm.
	 */
	private ArrayList<Animal> animalArrayList;
	
	/**
	 * List of crops on the farm.
	 */
	private ArrayList<Crop> cropArrayList;
	
	/**
	 * List of items owned.
	 */
	private ArrayList<Item> itemArrayList;
	
	/**
	 * The amount of money the user has.
	 */
	private int money;
	
	/**
	 * Multiplier for crop growth.
	 */
	private float cropGrowthMultiplier;
	
	/**
	 * Multiplier for how much happiness an animal loses at the end of a day.
	 */
	private float animalHappinessMultiplier;
	
	/**
	 * Multiplier for how much health an animal loses at the end of a day.
	 */
	private float animalHealthMultiplier;
	
	/**
	 * The maximum number of crops the farm can have.
	 */
	private int maximumCrops;
	
	/**
	 * The maximum number of animals the farm can have.
	 */
	private int maximumAnimals;
	
	/**
	 * The number of crops the user has harvested.
	 */
	private int cropsHavested;
	
	

	/**
	 * Initializes Farm.
	 * Sets some basic variables,
	 * Initializes arrayLists
	 * Sets farms attributes based on farm type
	 * 
	 * @param farmName The name of the farm
	 * @param userFarmer The Farmer of the farm
	 * @param farmType The type of the farm
	 */
	public Farm(String farmName, Farmer userFarmer, String farmType) {
		
		this.maximumCrops = 3;
		this.maximumAnimals = 4;
		this.cropsHavested = 0;
		
		this.farmName = farmName;
		this.userFarmer = userFarmer;
		this.farmType = farmType;
		this.cropArrayList = new ArrayList<Crop>();
		this.animalArrayList = new ArrayList<Animal>();
		this.itemArrayList = new ArrayList<Item>();
		
		//Setup Farm based on farm type
		if (farmType.equals("Starting Cash")){
			this.money = 400;
			this.cropGrowthMultiplier = (float)0.8;
			this.animalHappinessMultiplier = 10;
			this.animalHealthMultiplier = 10;	
		    }
		
		else if (farmType.equals("Fast Crops")){
			this.money = 200;
			this.cropGrowthMultiplier = 2;
			this.animalHappinessMultiplier = 10;
			this.animalHealthMultiplier = 10;
		    }
		
		else if (farmType.equals("Better Animals")){
			this.money = 200;
			this.cropGrowthMultiplier = 1;
			this.animalHappinessMultiplier = 5;
			this.animalHealthMultiplier = 5;
		    }
		
		else{ // HardMode
			this.money = 200;
			this.cropGrowthMultiplier = (float)0.8;
			this.animalHappinessMultiplier = 15;
			this.animalHealthMultiplier = 15;
		    }			
	}

	/**
	 * Returns AnimalArraylist.
	 * @return AnimalArraylist
	 */
	public ArrayList<Animal> getAnimalArrayList() {
		return animalArrayList;
	}
	
	/**
	 * Adds a new animal to the animalArrayList.
	 * Does not check if adding new animal will go past maximum animals
	 * @param animal the animal object to add
	 */
	public void addNewAnimal(Animal animal){
		this.animalArrayList.add(animal);
	}
	
	
	/**
	 * Determines whether the farm has space for more animals. 
	 * @return True if space for more animals, false otherwise
	 */
	public boolean isAnimalArrayFull(){
		if(this.animalArrayList.size() > maximumAnimals-1){
			return true;
		    }
		
		else{
			return false;
		    }
	}

	/**
	 * Returns cropArrayList.
	 * @return cropArrayList
	 */
	public ArrayList<Crop> getCropArrayList() {
		return cropArrayList;
	}


	
	
	/**
	 * Determine whether the farm has space for more Crops. 
	 * @return True if space for more Crops, false otherwise
	 */
	public boolean isCropArrayFull(){
		if(this.cropArrayList.size() > maximumCrops-1){
			return true;
		    }
		
		else{
			return false;
		    }
	}
	
	/**
	 * Adds a new crop to the farm.
	 * Also adjusts new crops growth rate by cropGrowthMutiplier
	 * @param crop The crop object to add
	 */
	public void addNewCrop(Crop crop){
		crop.setDailyGrowthRate((int)(crop.getDailyGrowthRate() 
		        * this.cropGrowthMultiplier));
		this.cropArrayList.add(crop);
	}
	
	/**
	 * Removes crop object from farm.
	 * Also increases crops harvested
	 * @param crop The crop object to remove
	 */
	public void removeCrop(Crop crop){
		this.cropsHavested += 1;
		this.cropArrayList.remove(crop);
	}
	
	/**
	 * Returns a list of the animalType on the farm in arrayList order.
	 * @return String of animal on farm
	 */
	public String animalArrayToString(){
		String str = "";
		for(Animal animal: this.animalArrayList){
			str += animal.getAnimalType() + " ";
		}
		return str;
	}
	
	/**
	 * Returns a list of the cropType on the farm in arrayList order.
	 * @return String of crops on farm
	 */
	public String cropArrayToString(){
		String str = "";
		for(Crop crop: this.cropArrayList){
			str += crop.getCropType() + " ";
		}
		return str;
	}
	
	/**
	 * Returns the money the farm has.
	 * @return Money
	 */
	public int getMoney() {
		return money;
	}

	/**
	 * Sets the amount of money the farm has.
	 * @param money The amount to set money to
	 */
	public void setMoney(int money) {
		this.money = money;
	}
	
	/**
	 * Decreases farms money by amount.
	 * @param amount the amount to decrease money by
	 */
	public void deductMoney(int amount){
		this.money -= amount;
	}
	
	/**
	 * Increases farms money by amount.
	 * Also adjusts Farmers moneyScore by amount
	 * @param amount the amount to increase money by
	 */
	public void addMoney(int amount){
		this.userFarmer.changeMoneyScore(amount);
		this.money += amount;
	}

	/**
	 * Returns the crop growth multiplier.
	 * @return cropGrowthMultiplier
	 */
	public float getCropGrowthMultiplier() {
		return cropGrowthMultiplier;
	}

	/**
	 * Returns the animalHappinessMultiplier.
	 * @return animalHappinessMultiplier
	 */
	public float getAnimalHappinessMultiplier() {
		return animalHappinessMultiplier;
	}

	/**
	 * Increases animalHappinessMultiplier by amount.
	 * @param amount The amount to increase animalHappinessMultiplier by
	 */
	public void changeAnimalHappinessMultiplier(float amount) {
		this.animalHappinessMultiplier += amount;
	}

	/**
	 * Returns the animalHealthMultiplier.
	 * @return animalHealthMultiplier
	 */
	public float getAnimalHealthMultiplier() {
		return animalHealthMultiplier;
	}

	/**
	 * Increases animalHealthMultiplier by amount.
	 * @param amount The amount to increase animalHealthMultiplier by
	 */
	public void changeAnimalHealthMultiplier(float amount) {
		this.animalHealthMultiplier += amount;
	}

	/**
	 * Returns the farms name.
	 * @return farmName
	 */
	public String getFarmName() {
		return farmName;
	}

	/**
	 * Returns userFarmer, the farms Farmer object.
	 * @return userFarmer
	 */
	public Farmer getUserFarmer() {
		return userFarmer;
	}

	/**
	 * Returns farm type.
	 * @return farmType
	 */
	public String getFarmType() {
		return farmType;
	}

	/**
	 * Returns the arrayList of farms Item objects.
	 * @return itemArrayList
	 */
	public ArrayList<Item> getItemArrayList() {
		return itemArrayList;
	}
	
	/**
	 * Adds item to itemArrayList.
	 * @param item The item object to add to itemArrayList
	 */
	public void addItem(Item item){
		this.itemArrayList.add(item);
	}
	
	/**
	 * Returns a list of the items owned in arrayList order.
	 * @return String of items owned
	 */
	public String itemsArrayToString(){
		String str = "";
		for(Item item: this.itemArrayList){
			str += item.getItemName() + " ";
		}
		return str;
	}
	
	/**
	 * Display the farms status. Including Money, a List of the users owned items,
	 * and for each crop/animal, its information
	 * Used by GameEnviroment for CommandLineInterface.
	 */
	public void printFarmStatus(){
		System.out.println("You have $" + this.getMoney());
		System.out.println("The items you own are: " + this.itemsArrayToString());
		System.out.println("The status of your animals is as follows: ");
		for(Animal animal: this.getAnimalArrayList()){
			System.out.println("Animal Type: " + animal.getAnimalType());
			System.out.println("Animal Happiness: " + animal.getHappiness() + "%");
			System.out.println("Animal Health: " + animal.getHealth() + "%\n");
		}
		System.out.println("The status of your crops is as follows: ");
		for(Crop crop: this.getCropArrayList()){
			System.out.println("Crop Type: " + crop.getCropType());
			System.out.println("Current Crop Growth: " + crop.getCurrentGrowth() + "%");
			System.out.println("Daily Growth Rate: " + crop.getDailyGrowthRate() + "%");
			System.out.println("Ready for Harvest: " + crop.getIsHarvestable() + "\n");
		}
	}	
	
	
	/**
	 * Returns all the items from farms ItemArrayList that match the passed in type
	 * Used by GameEniroment for CommandLineApplication. Better Version below
	 * @param type The type of item to return
	 * @return ArrayList of items that match type
	 */
	public ArrayList<Item> getItemsOfType(String type){
		ArrayList<Item> itemsOfType = new ArrayList<Item>();
		for(Item item: this.itemArrayList){
			if(item.toString().contains(type)){		
				itemsOfType.add(item);
			}
		}
		return itemsOfType;
	}
	
	
	/**
	 * Returns all the items from farms ItemArrayList that match the passed in types.
	 * @param types The list of types to be matched
	 * @return ArrayList of items that match the given types
	 */
	public ArrayList<Item> getItemsOfType(String[] types){
		ArrayList<Item> itemsOfType = new ArrayList<Item>();
		for(Item item: this.itemArrayList){
			for(String itemType: types){
				if(item.toString().contains(itemType)){		
					itemsOfType.add(item);
				}
			}
		}
		return itemsOfType;
	}
	
	
	/**
	 * Removes Item object from itemArrayList.
	 * @param item the Item object to be removed
	 */
	public void removeItem(Item item){
		this.itemArrayList.remove(item);
	}
	
	/**
	 * Returns cropsHavested.
	 * @return cropsHavested
	 */
	public int getCropsHavested() {
		return cropsHavested;
	}
	
	/**
	 * Increases the maximum number of crops.
	 * @param amount the amount to increases maximum crops by
	 */
	public void increaseMaxCrops(int amount){
		this.maximumCrops += amount;
	}

	/**
	 * Returns the maximum number of crops allowed on the farm.
	 * @return maximumCrops
	 */
	public int getMaximumCrops() {
		return maximumCrops;
	}

	/**
	 * Returns the maximum number of animals allowed on the farm.
	 * @return maximumAnimals
	 */
	public int getMaximumAnimals() {
		return maximumAnimals;
	}

	/**
	 * Sets the value of cropGrowthMultiplier to passed in value.
	 * @param cropGrowthMultiplier The value to set cropGrowthMultiplier to
	 */
	public void setCropGrowthMultiplier(float cropGrowthMultiplier) {
		this.cropGrowthMultiplier = cropGrowthMultiplier;
	}

	/**
	 * Sets the value of animalHappinessMultiplier to passed in value.
	 * @param animalHappinessMultiplier The value to set animalHappinessMultiplier to
	 */
	public void setAnimalHappinessMultiplier(float animalHappinessMultiplier) {
		this.animalHappinessMultiplier = animalHappinessMultiplier;
	}

	/**
	 * Sets the value of animalHealthMultiplier to passed in value.
	 * @param animalHealthMultiplier The value to set animalHealthMultiplier to
	 */
	public void setAnimalHealthMultiplier(float animalHealthMultiplier) {
		this.animalHealthMultiplier = animalHealthMultiplier;
	}

	/**
	 * Sets the maximum number of crops allowed on the farm.
	 * @param maximumCrops The number to set maximumCrops to
	 */
	public void setMaximumCrops(int maximumCrops) {
		this.maximumCrops = maximumCrops;
	}

	/**
	 * Sets the maximum number of animals allowed on the farm.
	 * @param maximumAnimals The number to set maximumAnimals to
	 */
	public void setMaximumAnimals(int maximumAnimals) {
		this.maximumAnimals = maximumAnimals;
	}

	/**
	 * Sets the crops harvested to passed in value.
	 * @param cropsHavested The value to set cropsHavested to
	 */
	public void setCropsHavested(int cropsHavested) {
		this.cropsHavested = cropsHavested;
	}
	
}
