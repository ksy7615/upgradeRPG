package upgradeRPG;

import java.util.ArrayList;

public class Inventory {
	public static ArrayList<Item> itemList = new ArrayList<>();
	
	public void inputItem(Item item) {
		itemList.add(item);
	}
}
