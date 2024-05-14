package farmSim;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


/**
 * Logic handler for GUI Farming Simulator application.
 * @author James Harris, Manjeet Panwar
 * @version 10/05/2020
 */

public class GuiGameEnviroment {

    /**
     * Game state of game. Holds all information about current state
     */
    private GameState gameState;
	
    /**
	 * Sets the current gameState to the one passed in.
	 * @param gameState the gameState use
	 */
	public void setGameState(GameState gameState) {
		this.gameState = gameState;
	}

	/**
	 * Returns true if current day is less than maximum number of days, else returns false.
	 * @return If game should continue, boolean
	 */
	public boolean checkCanGoNextDay() {
		if(gameState.getCurrentDay() >= gameState.getnumOfDaysGameLasts()){
			return false;
		}
		else{
			return true;
		}
	}

	
	/**
	 * Processes all end of day happenings. 
	 * Gives player money based on animals
	 * Changes animals health and happiness based on multipliers
	 * Grows crops by daily growth rate
	 * Sets actions remaining to farmers daily actions
	 */
	public void processEndOfDay(){
		for(Animal animal: gameState.getFarm().getAnimalArrayList()){
			gameState.getFarm().addMoney((int)animal.getIncome());
			animal.changeHappiness((int)gameState.getFarm().getAnimalHappinessMultiplier());
			animal.changeHealth((int)gameState.getFarm().getAnimalHealthMultiplier());
		}
		for(Crop crop: gameState.getFarm().getCropArrayList()){
			crop.changeCurrentGrowth((int)(crop.getDailyGrowthRate()));
		}
		gameState.setActionsLeft(gameState.getFarm().getUserFarmer().getDailyActions());;
		gameState.incrementCurrentDay();
	}
	
	
	/**
	 * Checks is a given name is legal by matching it against a regular expression.
	 * Legal name must only contain alphabet characters and be between 3 and 15 characters inclusive.
	 * @param name The name to check
	 * @return True if name valid. False otherwise.
	 */
	public boolean checkLegalName(String name){
		if(name.matches("^[A-Za-z]{3,15}$")){
			return true;
		}
		else{
			return false;
		}
	}
	
	/**
	 * Checks if a given number of days is legal. Legal if an integer between 5 and 10 inclusive
	 * @param numOfDays the number of days to check
	 * @return true if legal, false otherwise
	 */
	public boolean checkLegalNumberOfDays(String numOfDays){
		int numDays = 0;
		try{
			numDays = Integer.parseInt(numOfDays);
			if((numDays >= 5) && (numDays <= 10)){
				return true;
			}else{
				return false;
			}
		}catch(Exception e){
			return false;
		}
	}
	
	
	/**
	 * Returns a list of items owned by player.
	 * @return List of items owned by player
	 */
	public String getItemList(){
		String itemListString = "";
		for(Item item: gameState.getFarm().getItemArrayList()){
			itemListString += item.getItemName() + "\n";
		}
		return itemListString;
	}
	
	
	/**
	 * Returns a list of crops owned by player as string.
	 * @return List of crops owned by player
	 */
	public String getCropsList(){
		String cropListString = "";
		for(Crop crop: gameState.getFarm().getCropArrayList()){
			cropListString += crop.getCropType() + "\n";
		}
		return cropListString;
	}
	

	/**
	 * Returns a list of animals owned by player as string.
	 * @return List of crops owned by player
	 */
	public String getAnimalsList(){
		String animalListString = "";
		for(Animal animal: gameState.getFarm().getAnimalArrayList()){
			animalListString += animal.getAnimalType() + "\n";
		}
		return animalListString;
	}
	
	
	
	
	
	
	
	/**
	 * Purchase an animal by deducting cost from farm,
	 * Then adding animal to farm based on type.
	 * This method does not check whether purchasing an animal is legal
	 * @param animalType the type of animal to purchase
	 * @param cost the cost of the animal to purchase
	 */
	public void purchaseAnimal(String animalType, int cost){
		gameState.getFarm().deductMoney(cost);
		if(animalType == "Cow"){
			gameState.getFarm().addNewAnimal(new Cow());
		}
		else if(animalType == "Sheep"){
			gameState.getFarm().addNewAnimal(new Sheep());
		}
		else{//Chicken
			gameState.getFarm().addNewAnimal(new Chicken());
		}
	}
	
	
	/**
	 * Purchase a crop by deducting cost from farm,
	 * Then adding crop to farm based on type.
	 * This method does not check whether purchasing a crop is legal
	 * @param cropType the type of crop to purchase
	 * @param cost the cost of the crop to purchase
	 */
	public void purchaseCrop(String cropType, int cost){
		gameState.getFarm().deductMoney(cost);
		if(cropType == "Wheat"){
			gameState.getFarm().addNewCrop(new Wheat());
		}else if(cropType == "Corn"){
			gameState.getFarm().addNewCrop(new Corn());
		}else if(cropType == "Carrot"){
			gameState.getFarm().addNewCrop(new Carrot());
		}else if(cropType == "Potato"){
			gameState.getFarm().addNewCrop(new Potato());
		}else if(cropType == "Lettuce"){
			gameState.getFarm().addNewCrop(new Lettuce());
		}else{//Beetroot
			gameState.getFarm().addNewCrop(new Beetroot());
		}
	}

	
	/**
	 * Purchase a item by deducting cost from farm,
	 * Then adding item to farm based on type.
	 * This method does not check whether purchasing a item is legal
	 * @param itemType the type of item to purchase
	 * @param cost the cost of the item to purchase
	 */
	public void purchaseItem(String itemType, int cost){
		gameState.getFarm().deductMoney(cost);
		if(itemType == "Fertilizer"){
			gameState.getFarm().addItem(new Fertilizer());
		}else if(itemType == "Pesticide"){
			gameState.getFarm().addItem(new Pesticide());
		}else if(itemType == "CommonFood"){
			gameState.getFarm().addItem(new CommonFood());
		}else if(itemType == "LuxuryFood"){
			gameState.getFarm().addItem(new LuxuryFood());
		}else if(itemType == "ProteinBar"){
			gameState.getFarm().addItem(new ProteinBar());
		}else{//Hat
			gameState.getFarm().addItem(new Hat());
		}
	}
	
	
	
	/**
	 * Checks if user can afford price of purchase.
	 * @param price the price to be check
	 * @return True if user has money at-least equal to price, else false.
	 */
	public boolean checkAfforadable(int price){
		if(price <= gameState.getFarm().getMoney()){
			return true;
		}else{
			return false;
		}
	}
	
	
	/**
	 * Checks if farm has space for new animal.
	 * @return true if space for new animal, false otherwise
	 */
	public boolean checkSpaceForAnimals(){
		if(!gameState.getFarm().isAnimalArrayFull()){
			return true;
		}else{
			return false;
		}
	}
	
	/**
	 * Checks if farm has space for new crops.
	 * @return true if space for new crops, false otherwise
	 */
	public boolean checkSpaceForCrops(){
		if(!gameState.getFarm().isCropArrayFull()){
			return true;
		}else{
			return false;
		}
	}
	
	/**
	 * Checks if the user owns items of given types by
	 * calling getUseableItemsOfType with itemTypes and checking
	 * size of result.
	 * @param itemTypes the types of items to check for
	 * @return True if user owns items of types, false otherwise
	 */
	public boolean checkUserHasItems(String[] itemTypes){
		if(getUseableItemsOfType(itemTypes).size() > 0){
			return true;
		}
		return false;
	}
	
	
	/**
	 * Checks whether the user has animals on farm.
	 *  @return True if user owns animals, false otherwise
	 */
	public boolean checkUserHasAnimals(){
		if(gameState.getFarm().getAnimalArrayList().size() > 0){
			return true;
		}
		else{
			return false;
		}
	}
	
	/**
	 * Checks whether the user has crops on farm.
	 * @return True if user owns crops, false otherwise
	 */
	public boolean checkUserHasCrops(){
		if(gameState.getFarm().getCropArrayList().size() > 0){
			return true;
		}
		else{
			return false;
		}
	}
	
	/**
	 * Checks whether any crops are harvestable by looping over
	 * all crops on farm and calling isHarvestable on them.
	 * @return True if any crop harvestable, false otherwise
	 */
	public boolean checkIfHarvestableCrops(){
		ArrayList<Crop> havestableCrops = new ArrayList<Crop>();
		for(Crop crop: gameState.getFarm().getCropArrayList()){
			if(crop.getIsHarvestable()){
				havestableCrops.add(crop);
			}
		}
		if(havestableCrops.size() > 0){
			return true;
		}
		else{
			return false;
		}
	}
	
	/**
	 * Checks if farm is tendable by checking value of
	 * gameStates HasTendedFarm.
	 * 
	 * @return True if farm tendable, false otherwise
	 */
	public boolean checkIfFarmTendable(){
		if(gameState.isHasTendedFarm()){
			return false;
		}
		else{
			return true;
		}
	}
	
	
	/**
	 * Decreases the actions left today by 1.
	 * Calls gameStates change actions left with value -1
	 */
	public void actionUsed(){
		gameState.changeActionsLeft(-1);
	}
	
	
	/**
	 * Loops over all animals on farm and calls playWithAnimal on them
	 * Then calls action used.
	 */
	public void playWithAnimals(){
		for(Animal animal: gameState.getFarm().getAnimalArrayList()){
			animal.playWithAnimal();
		}
		actionUsed();
	}
	
	
	/**
	 * Returns all items of given type by calling gameStates getItemsOfType
	 * With itemTypes.
	 * @param itemTypes the type of items to get
	 * @return item ArrayList of all items of given types
	 */
	public ArrayList<Item> getUseableItemsOfType(String[] itemTypes){
		ArrayList<Item> arrayUseableItems = gameState.getFarm().getItemsOfType(itemTypes);
		return arrayUseableItems;
	}
	
	
	/**
	 * Returns ArrayList of all crops on farm.
	 * @return ArrayList of crops on farm
	 */
	public ArrayList<Crop> getCrops(){
		ArrayList<Crop> arrayOfCrops = gameState.getFarm().getCropArrayList();
		return arrayOfCrops;
	}
	
	
	/**
	 * Feeds all animals a type of food.
	 * Gets the first item from a list of all items of the type itemToFeed
	 * Loops over all items calling feed animal on them with parameters of itemToFeed
	 * Then calls action used and calls gameState removeItem with item object to remove
	 * @param itemToFeed the itemType to feed the animals
	 */
	public void feedAnimals(String itemToFeed){
		AnimalItem itemToUse = (AnimalItem)(getUseableItemsOfType(new String[]{itemToFeed}).get(0));
		
		for(Animal animal: gameState.getFarm().getAnimalArrayList()){
			animal.feedAnimal(itemToUse.getHappinessBoost(), itemToUse.getHealthBoost());
		}
		
		actionUsed();
		gameState.getFarm().removeItem(itemToUse);
	}
	
	
	/**
	 * Uses item of type itemToUse.
	 * Gets the first item from a list of all items of the type itemToUse
	 * Increases Farmers daily actions by amount by the items permenant action boost
	 * Increases current action remaining by the items temporary action boost
	 * @param itemToUse the itemType to use
	 */
	public void useFarmerItem(String itemToUse){
		FarmerItem farmerItemToUse = (FarmerItem)(getUseableItemsOfType(new String[]{itemToUse}).get(0));
			
		gameState.getFarm().getUserFarmer().increseDailyActions(farmerItemToUse.getActionBoostPermentant());
		gameState.changeActionsLeft(farmerItemToUse.getActionBoostTemporary());
		gameState.getFarm().removeItem(farmerItemToUse);
	}
	
	
	/**
	 * Harvest all harvetsable crops.
	 * Creates an arraylist of all crops ready for harvest
	 * Then loops over the arraylist calling gameStates
	 * addMoney with crops sale price and removeCrop with the
	 * crop object
	 * Then calls actionUsed
	 */
	public void harvestCrops(){
		ArrayList<Crop> havestableCrops = new ArrayList<Crop>();
		for(Crop crop: gameState.getFarm().getCropArrayList()){
			if(crop.getIsHarvestable()){
				havestableCrops.add(crop);
			}
		}
		
		for(Crop crop: havestableCrops){
			gameState.getFarm().addMoney(crop.getSalePrice());
			gameState.getFarm().removeCrop(crop);	
		}
			
		actionUsed();
	}
	
	
	
	/**
	 * Tends the farmland.
	 * Increase max crops by one, decreases animal health and happiness multipliers
	 * sets had tended farm to true. Calls action used.
	 */
	public void tendFarmLand(){
		gameState.getFarm().increaseMaxCrops(1);
		gameState.getFarm().changeAnimalHappinessMultiplier(-5);
		gameState.getFarm().changeAnimalHealthMultiplier(-5);
		gameState.setHasTendedFarm(true);
		actionUsed();
	}
	
	
	/**
	 * Tends to crop.
	 * Uses input parameter cropArrayPostition to find correct crop from crops list
	 * Gets Type of item toTendWith from gameState
	 * Gets first item from list of items of that type
	 * Calls tendCrop using items parameters
	 * Removes item from farm if item is not water
	 * 
	 * @param cropArrayPostition The position in the crop array of the item to tend
	 */
	public void tendCrop(int cropArrayPostition){
		Crop cropToTend = gameState.getFarm().getCropArrayList().get(cropArrayPostition);
		
		CropItem itemToTendWith = (CropItem)getUseableItemsOfType(new String[] {gameState.getItemToTendWith()}).get(0);
		
		cropToTend.tendCrop(itemToTendWith.getGrowthBoostTemporary(), itemToTendWith.getGrowthBoostPermentant());
		
		if(itemToTendWith.getItemName() != "Water"){
			gameState.getFarm().removeItem(itemToTendWith);
		}
		actionUsed();
	}
	
	
	/**
	 * Calculates users score.
	 * Returns score as custom string including base score and multipliers
	 * @return A custom score string displaying the users score
	 */
	public String getScore(){
		
		int moneyScore = 0;
		moneyScore += gameState.getFarm().getUserFarmer().getmoneyScore();
		
		//Animal Multiplier Calculated from total happiness and healthiness of animals
		float animalMultiplier = 0;
		for(Animal animal: gameState.getFarm().getAnimalArrayList()){
			animalMultiplier += animal.getHappiness() + animal.getHealth();
		}
		
		//Crop multiplier calculated from total growth of crops throughout game
		float cropMultiplier = 0;
		cropMultiplier += gameState.getFarm().getCropsHavested()*100;
		for(Crop crop: gameState.getFarm().getCropArrayList()){
			cropMultiplier += crop.getCurrentGrowth();
		}
		
		int totalScore = (int)(cropMultiplier * animalMultiplier * moneyScore);
		
		return ("Score:\nMoney Earned: " + moneyScore + "\nAnimal Happiness Multiplier: " 
		+ animalMultiplier + "\nCrop Growth Multiplier: " + cropMultiplier + "\nFinal Score: " + totalScore);
		
	}
	
	/**
	 * Returns a Thank you message based on gameState.
	 * @return Thank-you Message
	 */
	public String getUserThanks(){
		return ("Thanks for playing " + gameState.getFarm().getUserFarmer().getFarmerName() +
		        " of " + gameState.getFarm().getFarmName() + " farm. You played on a " 
		        + gameState.getFarm().getFarmType() + " type farm.");
	}
	
	/**
	 * Deletes save file .
	 */
	public void deleteSaveFile(){
		File filetoDelete = new File("FarmingSimulatorGameSave.txt");
		filetoDelete.delete();
	}
	
	
	/**
	 * Creates new TempGameState based on input parsed from save-file.
	 * @return TempGameState
	 */
	public GameState loadFromSaveFile(){
		//Read File
		String saveFileData = "";
		try {
		      File myObj = new File("FarmingSimulatorGameSave.txt");
		      Scanner myReader = new Scanner(myObj);
		      while (myReader.hasNextLine()) {
		    	saveFileData += myReader.nextLine() + "\n";
		        
		      }
		      myReader.close();
		} 
		catch (FileNotFoundException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }
		String[] saveDataLines = saveFileData.split("\n");
		
		//Configure GameState
		GameState tempGameState = new GameState(Integer.parseInt(saveDataLines[2]),
		        saveDataLines[14], saveDataLines[5], saveDataLines[6]);
		tempGameState.setCurrentDay(Integer.parseInt(saveDataLines[0]));
		tempGameState.setActionsLeft(Integer.parseInt(saveDataLines[1]));
		tempGameState.setHasTendedFarm(Boolean.parseBoolean(saveDataLines[3]));
		tempGameState.setItemToTendWith(saveDataLines[4]);
		
		//Configure Farm, Skip Arrays
		tempGameState.getFarm().setMoney(Integer.parseInt(saveDataLines[7]));
		tempGameState.getFarm().setCropGrowthMultiplier(Float.parseFloat(saveDataLines[8]));
		tempGameState.getFarm().setAnimalHappinessMultiplier(Float.parseFloat(saveDataLines[9]));
		tempGameState.getFarm().setAnimalHealthMultiplier(Float.parseFloat(saveDataLines[10]));
		tempGameState.getFarm().setMaximumCrops(Integer.parseInt(saveDataLines[11]));
		tempGameState.getFarm().setMaximumAnimals(Integer.parseInt(saveDataLines[12]));
		tempGameState.getFarm().setCropsHavested(Integer.parseInt(saveDataLines[13]));
		
		//Configure Farmer
		tempGameState.getFarm().getUserFarmer().setDailyActions(Integer.parseInt(saveDataLines[15]));
		tempGameState.getFarm().getUserFarmer().setFarmerAge(Integer.parseInt(saveDataLines[16]));
		tempGameState.getFarm().getUserFarmer().setMoneyScore(Integer.parseInt(saveDataLines[17]));
		
		
		
		int currentLineIndex = 18;
		String currentLine = saveDataLines[currentLineIndex];
		//Parse Animals
		while(!currentLine.equals("Animals End")){
			String animalDefinition = saveDataLines[currentLineIndex];
			String[] animalDefinitionSplit = animalDefinition.split(",");
			if(animalDefinitionSplit[0].equals("Cow")){
				tempGameState.getFarm().addNewAnimal(new Cow(Integer.parseInt(animalDefinitionSplit[1]),
				        Integer.parseInt(animalDefinitionSplit[2])));
			}
			else if(animalDefinitionSplit[0].equals("Chicken")){
				tempGameState.getFarm().addNewAnimal(new Chicken(Integer.parseInt(animalDefinitionSplit[1]),
				        Integer.parseInt(animalDefinitionSplit[2])));
			}
			else if(animalDefinitionSplit[0].equals("Sheep")){
				tempGameState.getFarm().addNewAnimal(new Sheep(Integer.parseInt(animalDefinitionSplit[1]),
				        Integer.parseInt(animalDefinitionSplit[2])));
			}
			currentLineIndex ++;
			currentLine = saveDataLines[currentLineIndex];
		}
		
		
		currentLineIndex ++;
		currentLine = saveDataLines[currentLineIndex];
		//Parse Crops
		while(!currentLine.equals("Crops End")){
			String cropDefinition = saveDataLines[currentLineIndex];
			String[] cropDefinitionSplit = cropDefinition.split(",");
			if(cropDefinitionSplit[0].equals("Carrot")){
				tempGameState.getFarm().addNewCrop(new Carrot(Integer.parseInt(cropDefinitionSplit[1]),
				        Integer.parseInt(cropDefinitionSplit[2])));
			}
			else if(cropDefinitionSplit[0].equals("Corn")){
				tempGameState.getFarm().addNewCrop(new Corn(Integer.parseInt(cropDefinitionSplit[1]),
				        Integer.parseInt(cropDefinitionSplit[2])));
			}
			else if(cropDefinitionSplit[0].equals("Lettuce")){
				tempGameState.getFarm().addNewCrop(new Lettuce(Integer.parseInt(cropDefinitionSplit[1]),
				        Integer.parseInt(cropDefinitionSplit[2])));
			}
			else if(cropDefinitionSplit[0].equals("Beetroot")){
				tempGameState.getFarm().addNewCrop(new Beetroot(Integer.parseInt(cropDefinitionSplit[1]),
				        Integer.parseInt(cropDefinitionSplit[2])));
			}
			else if(cropDefinitionSplit[0].equals("Potato")){
				tempGameState.getFarm().addNewCrop(new Potato(Integer.parseInt(cropDefinitionSplit[1]),
				        Integer.parseInt(cropDefinitionSplit[2])));
			}
			else if(cropDefinitionSplit[0].equals("Wheat")){
				tempGameState.getFarm().addNewCrop(new Wheat(Integer.parseInt(cropDefinitionSplit[1]),
				        Integer.parseInt(cropDefinitionSplit[2])));
			}	
			currentLineIndex ++;
			currentLine = saveDataLines[currentLineIndex];
		}
		
		currentLineIndex ++;
		currentLine = saveDataLines[currentLineIndex];
		//Parse Items
		while(!currentLine.equals("Items End")){
			String itemDefinition = saveDataLines[currentLineIndex];
			if(itemDefinition.equals("CommonFood")){
				tempGameState.getFarm().addItem(new CommonFood());
			}
			else if(itemDefinition.equals("LuxuryFood")){
				tempGameState.getFarm().addItem(new LuxuryFood());
			}
			else if(itemDefinition.equals("Pesticide")){
				tempGameState.getFarm().addItem(new Pesticide());
			}
			else if(itemDefinition.equals("Fertilizer")){
				tempGameState.getFarm().addItem(new Fertilizer());
			}
			else if(itemDefinition.equals("ProteinBar")){
				tempGameState.getFarm().addItem(new ProteinBar());
			}
			else if(itemDefinition.equals("Hat")){
				tempGameState.getFarm().addItem(new Hat());
			}
			currentLineIndex ++;
			currentLine = saveDataLines[currentLineIndex];
		}
		
		return tempGameState;
	}
	
	
	/**
	 * Returns whether or not a save-file Exists.
	 * @return True is save-file exists, otherwise false
	 */
	public boolean checkSaveFileExists(){
		if(!(new File("FarmingSimulatorGameSave.txt").exists())){
			return false;
		}
		else{
			return true;
		}
	}
	
	
	/**
	 * Creates save file based on current gameState.
	 * Save-file is a textual representation of all important gameState information
	 */
	public void createSaveFile(){
		try {
			FileWriter myWriter = new FileWriter("FarmingSimulatorGameSave.txt");
			
			String animalSaveString = "";
			for(Animal animal: gameState.getFarm().getAnimalArrayList()){
				animalSaveString += animal.getAnimalType() + "," + animal.getHappiness() + "," + animal.getHealth() + "\n";
			}
			animalSaveString += "Animals End\n";
			
			String cropSaveString = "";
			for(Crop crop: gameState.getFarm().getCropArrayList()){
				cropSaveString += crop.getCropType() + "," + crop.getCurrentGrowth() + "," + crop.getDailyGrowthRate() + "\n";
			}
			cropSaveString += "Crops End\n";
			
			String itemSaveString = "";
			for(Item item: gameState.getFarm().getItemArrayList()){
				itemSaveString += item.getItemName() + "\n";
			}
			itemSaveString += "Items End\n";
			
			
			String saveFileString = gameState.getCurrentDay() + "\n" + gameState.getActionsLeft() + "\n" + 
			gameState.getnumOfDaysGameLasts() + "\n" + gameState.isHasTendedFarm() + "\n" + gameState.getItemToTendWith() + "\n"
					+ gameState.getFarm().getFarmName() + "\n" + gameState.getFarm().getFarmType() + "\n" 
			+ gameState.getFarm().getMoney() + "\n" + gameState.getFarm().getCropGrowthMultiplier() + "\n"
					+ gameState.getFarm().getAnimalHappinessMultiplier() + "\n" + 
			gameState.getFarm().getAnimalHealthMultiplier() + "\n" + gameState.getFarm().getMaximumCrops()
			+ "\n" + gameState.getFarm().getMaximumAnimals() 
					+ "\n" + gameState.getFarm().getCropsHavested() + "\n" +
			gameState.getFarm().getUserFarmer().getFarmerName() + "\n" + 
					gameState.getFarm().getUserFarmer().getDailyActions() + "\n" 
					+ gameState.getFarm().getUserFarmer().getFarmerAge() + "\n" + 
					gameState.getFarm().getUserFarmer().getmoneyScore() + "\n" 
					+ animalSaveString + cropSaveString + itemSaveString;
			
			myWriter.write(saveFileString);
			myWriter.close();
		} catch (IOException e) {
			;
		}		
	}
	
}
