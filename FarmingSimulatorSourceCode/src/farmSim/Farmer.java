package farmSim;

/**
 * The class is the users Farmer object.
 * 
 * @author James Harris, Manjeet Panwar
 * @version 6/05/2020
 */
public class Farmer {
	/**
	 * Farmers name.
	 */
	private String farmerName;
	
	/**
	 * Farmers age.
	 */
	private int farmerAge;
	
	/**
	 * Farmers daily actions.
	 */
	private int dailyActions;
	
	/**
	 * Farmers money score, the total money the user had made throughout the game.
	 */
	private int moneyScore;

	
	/**
	 * Constructor for farmer object.
	 * 
	 * Farmers age set to 40
	 * Farmers daily actions set to 2
	 * 
	 * @param name the farmers name
	 */
	public Farmer(String name){
		this.farmerAge = 40;
		this.farmerName = name;
		this.dailyActions = 2;
	}
	
	/**
	 * Returns farmers name.
	 * @return farmerName
	 */
	public String getFarmerName() {
		return farmerName;
	}

	/**
	 * Returns farmers age.
	 * @return farmerAge
	 */
	public int getFarmerAge() {
		return farmerAge;
	}
	
	/**
	 * returns daily actions.
	 * @return dailyActions
	 */
	public int getDailyActions() {
		return dailyActions;
	}
	
	/**
	 * Increases dailyActions by amount.
	 * @param amount the amount to increase daily actions by
	 */
	public void increseDailyActions(int amount){
		this.dailyActions += amount;
	}

	/**
	 * returns moneyScore.
	 * @return moneyScore
	 */
	public int getmoneyScore() {
		return this.moneyScore;
	}

	/**
	 * Increases moneyScore by amount.
	 * @param amount the amount to increase moneyScore by
	 */
	public void changeMoneyScore(int amount) {
		this.moneyScore += amount;
	}

	/**
	 * Sets the value of farmer age to input param.
	 * @param farmerAge The value to set farmerAge to
	 */
	public void setFarmerAge(int farmerAge) {
		this.farmerAge = farmerAge;
	}

	/**
	 * Sets the value of dailyActions to input param.
	 * @param dailyActions The value to set dailyActions to
	 */
	public void setDailyActions(int dailyActions) {
		this.dailyActions = dailyActions;
	}

	/**
	 * Sets the value of moneyScore to input param.
	 * @param moneyScore The value to set moneyScore to
	 */
	public void setMoneyScore(int moneyScore) {
		this.moneyScore = moneyScore;
	}
	
}
