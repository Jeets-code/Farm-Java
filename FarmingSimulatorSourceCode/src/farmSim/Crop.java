package farmSim;

/**
 * This class is the superclass for Crop objects.
 * 
 * @author James Harris, Manjeet Panwar
 * @version 6/05/2020
 */
public class Crop {
	
	/**
	 * The type of crop.
	 */
	private String cropType;
	
	/**
	 * The sale price of the crop.
	 */
	private int salePrice;
	
	/**
	 * The current growth of the crop.
	 */
	private int currentGrowth;
	
	/**
	 * The daily growth rate of the crop.
	 */
	private int dailyGrowthRate;
	
	/**
	 * The crops harvestability.
	 */
	private Boolean isHarvestable;
	
	
	/**
	 * The number of days until crop is fully grown at current growth rate.
	 */
	private int daysTillGrown;
	
	
	/**
	 * Constructor for Crop.
	 * Initialized with currentGrowth zero and isHarvestable false
	 * Other variables passed ins
	 * 
	 * @param cropType the type of the crop
	 * @param salePrice the sale price of the crop
	 * @param dailyGrowthRate the daily growth rate of the crop
	 */
	public Crop(String cropType, int salePrice,
			int dailyGrowthRate) {
		
		this.cropType = cropType;
		this.salePrice = salePrice;
		this.dailyGrowthRate = dailyGrowthRate;
		this.isHarvestable = false;
		this.currentGrowth = 0;
		this.daysTillGrown = 100;
	}
	
	
	
	/**
	 * Save file Constructor for Crop.
	 * 
	 * @param cropType the type of the crop
	 * @param salePrice the sale price of the crop
	 * @param currentGrowth the current growth of the crop
	 * @param dailyGrowthRate the daily growth rate of the crop
	 */
	public Crop(String cropType,  int salePrice,
			int currentGrowth, int dailyGrowthRate) {
		
		this.cropType = cropType;
		this.salePrice = salePrice;
		this.dailyGrowthRate = dailyGrowthRate;
		this.isHarvestable = false;
		this.currentGrowth = currentGrowth;
		this.daysTillGrown = 100;
	}
	

	/**
	 * Returns current growth.
	 * @return currentGrowth
	 */
	public int getCurrentGrowth() {
		return currentGrowth;
	}

	/**
	 * Returns daily Growth Rate.
	 * @return dailyGrowthRate
	 */
	public int getDailyGrowthRate() {
		return dailyGrowthRate;
	}

	/**
	 * Set daily growth rate.
	 * @param dailyGrowthRate the new daily growth rate
	 */
	public void setDailyGrowthRate(int dailyGrowthRate) {
		this.dailyGrowthRate = dailyGrowthRate;
	}

	/**
	 * Returns if crop is harvestable.
	 * @return if crop is harvestable as boolean
	 */
	public Boolean getIsHarvestable() {
		return isHarvestable;
	}

	/**
	 * Returns crops type.
	 * @return cropType
	 */
	public String getCropType() {
		return cropType;
	}

	/**
	 * Returns crops sale price.
	 * @return salePrice
	 */
	public int getSalePrice() {
		return salePrice;
	}
	
	/**
	 * Changes crops current growth and daily growth rate. Then checkReadyToHarvest
	 * @param instantGrowthAmount the amount to increase current growth
	 * @param permGrowth the amount to increase daily growth rate
	 * @see checkReadyToHarvest
	 */
	public void tendCrop(int instantGrowthAmount, int permGrowth){
		this.currentGrowth += instantGrowthAmount;
		this.dailyGrowthRate += permGrowth;
		this.checkReadyToHarvest();
	}
	
	/**
	 * Checks if currentGrowth is greater than 100. If so set current growth to 100
	 * Checks if currentGrowth is equal to 100. If so change isHarvestable to true
	 */
	public void checkReadyToHarvest(){
		if(this.currentGrowth > 100){
			this.currentGrowth = 100;
		}
		if(this.currentGrowth == 100){
			this.isHarvestable = true;
		}
	}
	
	/**
	 * Changes current growth, then calls checkReadyToHarvest.
	 * @param amount the amount to increase current growth by
	 * @see checkReadyToHarvest
	 */
	public void changeCurrentGrowth(int amount){
		this.currentGrowth += amount;
		this.checkReadyToHarvest();
	}
	
	
	/**
	 * set daysTillGrown to the number of days until the crop is grown. Calculated here
	 */
	
	public void calcuateDaysTillGrown(){
		int days = 0;
		int growthRemaining = (100 - this.currentGrowth);
		int remainderGrowth = growthRemaining % this.dailyGrowthRate;
		if(remainderGrowth == 0){
			days = growthRemaining / this.dailyGrowthRate;
		}else{
			days = (growthRemaining / this.dailyGrowthRate) + 1;
		}
		this.daysTillGrown = days;
	}
	
	/**
	 * Returns a Textual Description of the crops Current state, including type,
	 * health, and happiness.
	 * @return Description of Animal
	 */
	public String getCropDescription(){
		calcuateDaysTillGrown();
		return this.cropType + "\nCurrent Growth: " + this.currentGrowth + 
		        "\nDaily Growth Rate: " + this.dailyGrowthRate + 
		        "\nDays Till Fully Grown: " + this.daysTillGrown + "\nIs harvestable:"
		        + " " + this.isHarvestable;
	}

}

