package farmSim;


import java.util.ArrayList;
import java.util.Hashtable;

/**
 * Game handler for command-line implementation of Farming simulator application.
 * Out-dated: does not use purchasable interface for shop
 * 
 * Methods not java-doc as class is obsolete
 * 
 * @author James Harris, Manjeet Panwar
 * @version 1/05/2020
 * @see GuiGameEnviroment
 */
public class CommandLineGameEnviroment {
	private Farm farm;
	private int currentDay;
	private int actionsLeft;
	private int numOfDays;
	private Hashtable<String, Integer> priceDictionary;
	
	/**
	 * Constructor for CommandLine Application.
	 */
	public CommandLineGameEnviroment(){
		//Setup Game based on user inputs
		numOfDays = readInt("Enter the number of days you would like the game to last: ", 10, 5);
		String farmerName = readFarmerName("Enter your Farmers Name: ");
		String farmName = readFarmerName("Enter your Farm Name: ");
		String farmType = getFarmType();
		
		//Create Farm
		this.farm = new Farm(farmName, new Farmer(farmerName), farmType);
		
		this.currentDay = 1;
		this.actionsLeft = 2;
		
		//Setup Price Dictionary
		this.priceDictionary = new Hashtable<String, Integer>();
		//Animals
		this.priceDictionary.put("CowPrice", 100);
		this.priceDictionary.put("SheepPrice", 100);
		this.priceDictionary.put("ChickenPrice", 100);
		//Crops
		this.priceDictionary.put("WheatPrice", 100);
		this.priceDictionary.put("CornPrice", 100);
		this.priceDictionary.put("CarrotPrice", 100);
		this.priceDictionary.put("PotatoPrice", 100);
		this.priceDictionary.put("LettucePrice", 100);
		this.priceDictionary.put("BeetrootPrice", 100);
		//Items
		this.priceDictionary.put("FertiliserPrice", 100);
		this.priceDictionary.put("PestacidePrice", 100);
		this.priceDictionary.put("CommonFoodPrice", 100);
		this.priceDictionary.put("LuxuryFoodPrice", 100);
		this.priceDictionary.put("ProteinBarPrice", 100);
		this.priceDictionary.put("HatPrice", 100);
		
		//Give the user the water item.
		farm.addItem(new CropItem("Water", 15, 0));
	}
	
	
	public void gameLoop(){
		while(this.currentDay <= this.numOfDays){
			userOption();			
		}
	}
	
	
	//Ask user for an action to take, check if action is valid, and if so execute method related, otherwise ask for new action
	public void userOption(){
		boolean validOption = false;
		while (!validOption){
			System.out.println("Daily Actions Remaining: " + this.actionsLeft);
			System.out.println("Please Enter the Number corresponding to the action you would like to perform:\n1 - Next Day\n2 - Display Balance\n3 - Visit Shop\n4 - View Farm Status"
					+ "\n5 - Tend Crops\n6 - Play All Animals\n7 - Feed Animals\n8 - Harvest Crops\n9 - Use Farmer Action Boost\n10 - Tend to Farm\n");
			int userInput = readInt("Enter your action choice: ", 10, 1);
			//Parse user input
			if(userInput == 1){ // Next Day
				goNextDay();
				validOption = true;
			}
			else if(userInput == 2){ // View Money
				System.out.println("Balance: " + farm.getMoney());
				validOption = true;
			}
			else if(userInput == 3){ // Visit Shop
				shopLoop();
			}
			else if(userInput == 4){//Farm Status
				farm.printFarmStatus();
			}
			else if(userInput == 5){//Tend to Crops
				tendCrops();
			}
			else if(userInput == 6){//Play with all animals
				playWithAnimals();
			}
			else if(userInput == 7){//Feed Animals
				feedAnimals();
			}
			else if(userInput == 8){//Harvest Crops
				harvestCrops();
			}
			else if(userInput == 9){//Use farmer action Item
				useActionItem();
			}
			else if(userInput == 10){//Tend to Farm
				tendToFarm();
			}
		}
	}
	
	
	
	//Moves onto next day
	public void goNextDay(){
		this.currentDay += 1;
		if(currentDay > numOfDays){
			System.out.println("Game End");
			endOfGameScore();
		}
		else{
			//Give user animal money bonus, chagne animal health and hapiness base on multiplier
			for(Animal animal: farm.getAnimalArrayList()){
				farm.addMoney((int)animal.getIncome());
				animal.changeHappiness((int)farm.getAnimalHappinessMultiplier());
				animal.changeHealth((int)farm.getAnimalHealthMultiplier());
			}
			for(Crop crop: farm.getCropArrayList()){
				crop.changeCurrentGrowth((int)(crop.getDailyGrowthRate()));
			}

			this.actionsLeft = farm.getUserFarmer().getDailyActions();
			System.out.println("It is day: " + this.currentDay);
		}
	}
	
	
	//Scoring
	public void endOfGameScore(){
		System.out.println("Thanks for playing " + farm.getUserFarmer().getFarmerName() + " of " + farm.getFarmName() + " farm.");
		//Base score calculated from total money earned throughout game
		int score = 0;
		score += farm.getUserFarmer().getmoneyScore();
		System.out.println("Your base score is: " + score);
		
		//Animal Multiplier Calculated from total happiness and healthiness of animals
		float animalMultiplier = 0;
		for(Animal animal: farm.getAnimalArrayList()){
			animalMultiplier += animal.getHappiness() + animal.getHealth();
		}
		System.out.println("Your animal quality of life multiplier is: " + animalMultiplier);
		
		//Crop multiplier calculated from total growth of crops throughout game
		float cropMultiplier = 0;
		cropMultiplier += farm.getCropsHavested()*100;
		for(Crop crop: farm.getCropArrayList()){
			cropMultiplier += crop.getCurrentGrowth();
		}
		System.out.println("Your crop growth multiplier is: " + cropMultiplier);
		
		int totalScore = (int)(cropMultiplier * animalMultiplier * score);
		
		System.out.println("Your final Score: " + totalScore);
	}
	
	
	
	
	//Tend to the farm
	public void tendToFarm(){
		System.out.println("You cleaned up the farm.\nYou can now grow one extra crop. You animals are also happier.");
		farm.increaseMaxCrops(1);
		farm.changeAnimalHappinessMultiplier(-5);
		farm.changeAnimalHealthMultiplier(-5);
		actionUsed();
	}
	
		
	
	//Loops over shop options until users enters 0 to exit. Calls commands dependent on option chosen
	public void shopLoop(){
		boolean stillShopping = true;
		while(stillShopping){	
			System.out.println("Please Enter the Number corresponding to the item you would like to purcahse:\n0 - Leave Shop\n1 - Cow\n2 - Sheep\n3 - Chicken\n4 - Wheat\n5 - Corn\n"
					+ "6 - Carrot\n7 - Potato\n8 - Lettuce\n9 - Beetroot\n10 - Fertiliser\n11 - Pestacide\n12 - CommonFood\n13 - LuxuryFood\n14 - ProteinBar\n15 - Hat\n16 - Check Farm Status");
			int userInput = readInt("Enter your action choice: ", 16, 0);
			//Parse user input
			
			if(userInput == 0){ //Leave Shop
				stillShopping = false;
				System.out.println("Returning to farm\n");
			}
			
			else if(userInput == 1){ //Cow
				purchaseAnimal("Cow");
			}
			
			else if(userInput == 2){//Sheep
				purchaseAnimal("Sheep");
			}
			
			else if(userInput == 3){//Chicken
				purchaseAnimal("Chicken");
			}
			
			else if(userInput == 4){//Wheat
				purchaseCrop("Wheat");
			}
			else if(userInput == 5){//Corn
				purchaseCrop("Corn");
			}
			else if(userInput == 6){//Carrot
				purchaseCrop("Carrot");
			}
			else if(userInput == 7){//Potato
				purchaseCrop("Potato");
			}
			else if(userInput == 8){//Lettuce
				purchaseCrop("Lettuce");
			}
			else if(userInput == 9){//Beetroot
				purchaseCrop("Beetroot");
			}
			else if(userInput == 10){//Fertiliser
				purchaseItem("Fertiliser");
			}
			else if(userInput == 11){//Pestacide
				purchaseItem("Pestacide");
			}
			else if(userInput == 12){//CommonFood
				purchaseItem("CommonFood");
			}
			else if(userInput == 13){//LuxuryFood
				purchaseItem("LuxuryFood");
			}
			else if(userInput == 14){//ProteinBar
				purchaseItem("ProteinBar");
			}
			else if(userInput == 15){//Hat
				purchaseItem("Hat");
			}
			else{// Print users Status
				printFarmInventory();
			}
		}	
	}
	
	
	
	//Use action item
	public void useActionItem(){
		ArrayList<Item> farmerActionItems = farm.getItemsOfType("FarmerItem");
		
		if(farmerActionItems.size() > 0){
			System.out.println("Select an Item to use: ");
			
			int j;
			for(j = 1; j < farmerActionItems.size()+1; j ++){
				System.out.println(j + " - " + farmerActionItems.get(j-1).getItemName());
			}
			
			int itemChoice = readInt("Enter the number corresponding crop you would like to harvest: ", farmerActionItems.size(), 1);	
			
			FarmerItem itemToUse = (FarmerItem)farmerActionItems.get(itemChoice-1);
			System.out.println(itemToUse.getItemName() + " Used");
			
			farm.getUserFarmer().increseDailyActions(itemToUse.getActionBoostPermentant());
			this.actionsLeft += itemToUse.getActionBoostTemporary();
			
			farm.removeItem(itemToUse);	
			
		}else{// No farmer action items
			System.out.println("You have no Farmer Action Items");
		}
	}
	
	

	//Harvest Crops
	public void harvestCrops(){
		if((farm.getCropArrayList().size() > 0) && (this.actionsLeft > 0)){
			ArrayList<Crop> havestableCrops = new ArrayList<Crop>();
			for(Crop crop: farm.getCropArrayList()){
				if(crop.getIsHarvestable()){
					havestableCrops.add(crop);
				}
			}
			if(havestableCrops.size() > 0){
				
				System.out.println("Select a crop to harvest: ");

				int j;
				for(j = 1; j < havestableCrops.size()+1; j ++){
					System.out.println(j + " - " + havestableCrops.get(j-1).getCropType());
				}
				
				int cropChoice = readInt("Enter the number corresponding crop you would like to harvest: ", havestableCrops.size(), 1);	
					
				Crop cropToHarvest = havestableCrops.get(cropChoice-1);
				System.out.println(cropToHarvest.getCropType() + " Harvested");
				
				
				sellCrop(cropToHarvest.getSalePrice());
				
				actionUsed();
				farm.removeCrop(cropToHarvest);	
				
			}else{//No harvestable crops
				System.out.println("No crops are havestable");
			}
			

		}else if(this.actionsLeft < 1){
			System.out.println("You are out of daily actions");
		}
		else{//No Animals Owned
			System.out.println("You do not own any Crops");
		}
	}
	
	
	
	public void sellCrop(int salePrice){
		farm.addMoney(salePrice);
	}
	
	
	
	//Feed Animals
	public void feedAnimals(){
		if((farm.getAnimalArrayList().size() > 0) && (this.actionsLeft > 0)){
			
			ArrayList<Item> arrayUseableItems = farm.getItemsOfType("AnimalItem");
			
			if(arrayUseableItems.size() > 0){
			
				System.out.println("Select an food: ");

				int j;
				for(j = 1; j < arrayUseableItems.size()+1; j ++){
					System.out.println(j + " - " + arrayUseableItems.get(j-1).getItemName());
				}
				
				int foodChoice = readInt("Enter the number corresponding food choice: ", arrayUseableItems.size(), 1);	
					
				AnimalItem itemToUse = (AnimalItem)arrayUseableItems.get(foodChoice-1);
				System.out.println(itemToUse.getItemName() + " Used");
				
				for(Animal animal: farm.getAnimalArrayList()){
					animal.feedAnimal(itemToUse.getHappinessBoost(), itemToUse.getHealthBoost());
				}
				
				actionUsed();
				farm.removeItem(itemToUse);	
			}else{//No Animal items
				System.out.println("You do not own any Animal Items");
			}
					
		}else if(this.actionsLeft < 1){
			System.out.println("You are out of daily actions");
		}
		else{//No Animals Owned
			System.out.println("You do not own any Animals");
		}
	}
	
	
	
	//Play with animals
	public void playWithAnimals(){
		if((farm.getAnimalArrayList().size() > 0) && (this.actionsLeft > 0)){
			for(Animal animal: farm.getAnimalArrayList()){
				animal.playWithAnimal();
			}
			actionUsed();
		}
		else if(this.actionsLeft < 1){
			System.out.println("You are out of daily actions");
		}
		else{//No Animals Owned
			System.out.println("You do not own any Animals");
		}
	}
	
	
	
	
	//Allows player to tend to their crops
	public void tendCrops(){
		if((farm.getCropArrayList().size() > 0) && (this.actionsLeft > 0)){
			System.out.println("Select a crop you would like to tend:");
			int i;
			for(i = 1; i < farm.getCropArrayList().size()+1; i ++){
				System.out.println(i + " - " + farm.getCropArrayList().get(i-1).getCropType());
			}
			int userChoice = readInt("Enter the number corresponding to the crop you would like to tend:", farm.getCropArrayList().size(), 1);
			
			Crop cropToTend = farm.getCropArrayList().get(userChoice-1);
			System.out.println("Select an item to use to tend");

			ArrayList<Item> arrayUseableItems = farm.getItemsOfType("CropItem");
				
			int j;
			for(j = 1; j < arrayUseableItems.size()+1; j ++){
				System.out.println(j + " - " + arrayUseableItems.get(j-1).getItemName());
			}
			
			int tendingItemChoice = readInt("Enter the number corresponding to the Item: ", arrayUseableItems.size(), 1);
			
			CropItem itemToUse = (CropItem)arrayUseableItems.get(tendingItemChoice-1);
			System.out.println(itemToUse.getItemName() + " Used");
			cropToTend.tendCrop(itemToUse.getGrowthBoostTemporary(), itemToUse.getGrowthBoostPermentant());
			actionUsed();

			if(itemToUse.getItemName() != "Water"){
					farm.removeItem(itemToUse);
			}
			
		}
		else if(this.actionsLeft < 1){
			System.out.println("You are out of daily actions");
		}
		else{//No Crops Owned
		
			System.out.println("You do not own any Crops");
		}
	}
	
	
	
	
	
	//Decrements actions by one
	public void actionUsed(){
		this.actionsLeft -= 1;
	}

	
	
	
	//Displays the Users Balance, and What the user owns
	public void printFarmInventory(){
		System.out.println("You have $" + farm.getMoney());
		System.out.println("The crops on your farm are: " + farm.cropArrayToString());
		System.out.println("The animals on your farm are: " + farm.animalArrayToString());
		System.out.println("The items you own are: " + farm.itemsArrayToString());
	}
	
	
	
	//Take animal type, if user has both money and space for new animal, create new animal object and add it to
	//Farms animal array. Else give error.
	public void purchaseAnimal(String animalType){
		String dictionaryKey = animalType + "Price";
		if((this.priceDictionary.get(dictionaryKey) <= (farm.getMoney())) && (!farm.isAnimalArrayFull())){ 
			farm.deductMoney(this.priceDictionary.get(dictionaryKey));
			if(animalType == "Cow"){
				farm.addNewAnimal(new Cow());
			}
			else if(animalType == "Sheep"){
				farm.addNewAnimal(new Sheep());
			}
			else{//Chicken
				farm.addNewAnimal(new Chicken());
			}
			System.out.println(animalType +" purchased\n");
		}else{
			System.out.println(animalType + " could not be purchased, either insufficent funds or farm is full\n");
		}
	}
	
	
	
	
	//Take an item type, if user has money for new item, create new item object, add it to item array. Else give error
	public void purchaseItem(String itemType){
		String dictionaryKey = itemType + "Price";
		if(this.priceDictionary.get(dictionaryKey) <= (farm.getMoney())){
			farm.deductMoney(this.priceDictionary.get(dictionaryKey));
			if(itemType == "Fertiliser"){
				farm.addItem(new CropItem("Fertiliser", 20, 0));
			}else if(itemType == "Pestacide"){
				farm.addItem(new CropItem("Pestacide", 0, 10));
			}else if(itemType == "CommonFood"){
				farm.addItem(new AnimalItem("CommonFood", 10, 0));
			}else if(itemType == "LuxuryFood"){
				farm.addItem(new AnimalItem("LuxuryFood", 30, 30));
			}else if(itemType == "ProteinBar"){
				farm.addItem(new FarmerItem("ProteinBar", 1, 0));
			}else{//Hat
				farm.addItem(new FarmerItem("Hat", 0, 1));
			}
			System.out.println(itemType +" purchased\n");
		}
		else{
			System.out.println(itemType + " could not be purchased, insufficent funds\n");
		}
	}
	
	
	
	
	//Take a cropType, if user has both money and space for new crop, create new crop object and add it to
	//Farms crop array. Else give error.
	public void purchaseCrop(String cropType){
		String dictionaryKey = cropType + "Price";
		if((this.priceDictionary.get(dictionaryKey) <= (farm.getMoney())) && (!farm.isCropArrayFull())){ 
			farm.deductMoney(this.priceDictionary.get(dictionaryKey));
			if(cropType == "Wheat"){
				farm.addNewCrop(new Wheat());
			}else if(cropType == "Corn"){
				farm.addNewCrop(new Corn());
			}else if(cropType == "Carrot"){
				farm.addNewCrop(new Carrot());
			}else if(cropType == "Potato"){
				farm.addNewCrop(new Potato());
			}else if(cropType == "Lettuce"){
				farm.addNewCrop(new Lettuce());
			}else{//Beetroot
				farm.addNewCrop(new Beetroot());
			}
			
			System.out.println(cropType +" purchased\n");
		}
		else{
			System.out.println(cropType + " could not be purchased, either insufficent funds or farm is full\n");
		}
	}
	
	
	
	
	// Get farm type
	public static String getFarmType(){
		int userInputInt = readInt("Choose a farm type by entering the corresponding int:\n1 - Fast Crops\n2 - Better Animals\n3 - Big Cash\n4 - HardMode", 4, 1);
		String farmType = "";
		if(userInputInt == 1){
			farmType = "Fast Crops";
		} else if(userInputInt == 2){
			farmType = "Better Animals";
		} else if(userInputInt == 3){
			farmType = "Big Cash";
		}else
			farmType = "Hard Mode";
		return farmType;
	}
	
	
	
	
	
	//Gets user to input name for their farmer, rejects and re-asks if:
	//not between 3-15 characters, or contains numbers and or special characters
	public static String readFarmerName(String prompt){
		 boolean rightEntry = false;
		 String userEntry = "";
		 userEntry = readString(prompt);
		 while (!rightEntry){ 
			 if(userEntry.matches("^[A-Za-z]{3,15}$")){
				 rightEntry = true;
			 }
			 else{
				 System.out.println("Not a valid name. Names just be between 3 and 13 charaters, and must not include numbers or special characters");
				 userEntry = readString(prompt);
			 }
		 }
		 return userEntry;
	}
	
	
	//Asks user for string input from keyboard
	public static String readString(String prompt) {
		System.out.println(prompt);
		@SuppressWarnings("resource")
        java.util.Scanner keyboard = new java.util.Scanner(System.in);
		String userEntry = keyboard.nextLine();
		return userEntry;
		}
	
	
	
	//asks user for entry of an integer value from the keyboard, on invalid input gives error and asks again
    public static int readInt(String prompt) {
    boolean rightEntry = false;
    int choice = 0;
    
    while (!rightEntry){
      System.out.println(prompt);
      try {
        @SuppressWarnings("resource")
        java.util.Scanner keyboard = new java.util.Scanner(System.in);
        choice = keyboard.nextInt();
        rightEntry = true;  
      }catch (java.util.InputMismatchException e) {
        System.out.println("Error caught - not an integer number"); //display "Error caught - not an integer number" as entry is not a number (double) value
      }
    }    
    return choice;
}
    
    //Asks user for integer input from keyboard, returns error if input not int, out out of bounds
    public static int readInt(String prompt, int max, int min) {
    	  boolean rightEntry = false;
    	  int dataEntry = 0;    
    	  while (!rightEntry){               
    	    System.out.println(prompt);      
    	    try { 
    	    
    	      @SuppressWarnings("resource")
            java.util.Scanner keyboard = new java.util.Scanner(System.in);
    	      dataEntry = keyboard.nextInt(); 
    	     
    	      if(dataEntry < min || dataEntry > max) {
    	        System.out.println("Not a valid choice - try again");
    	      } else {
    	        rightEntry = true; 
    	      }
    	      
    	    } catch (java.util.InputMismatchException e) {
    	      System.out.println("Unexpected input - please try again");
    	    }
    	  }
    	  
    	  return dataEntry;
    	}
    
    
    
    //Main Method
    public static void main(String[] args) {
        CommandLineGameEnviroment game = new CommandLineGameEnviroment();
    	game.gameLoop();
    	
    	
	}
}



