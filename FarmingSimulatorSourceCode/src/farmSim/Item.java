package farmSim;

/**
 * This class is the superclass for item objects.
 * 
 * @author James Harris, Manjeet Panwar
 * @version 6/05/2020
 */
public class Item {
	/**
	 * Items name.
	 */
	private String itemName;
	
	
	/**
	 * Constructor for item.
	 * @param itemName the name of the item
	 */
	public Item(String itemName) {
		this.itemName = itemName;
		
	}

	/**
	 * Returns items name.
	 * @return itemName
	 */
	public String getItemName() {
		return itemName;
	}

}


