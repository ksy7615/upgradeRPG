package upgradeRPG;

import java.util.ArrayList;

public class Inventory {
	public static ArrayList<Item> itemList = new ArrayList<>();
	private boolean isRun = true;

	public void inputItem(Item item) {
		itemList.add(item);
	}

	public void printInventoryMenu() {
		System.out.println("======= 인벤토리 =======");
		System.out.println("[1] 장비착용");
		System.out.println("[2] 아이템 판매");
		System.out.println("[0] 뒤로가기");
		System.out.println("=====================");
	}
	
	private int inputNumber(String message) {
		System.out.println(message + " : ");
		return GameManager.scanner.nextInt();
	}
	
	public void runInventory() {
		while(isRun) {
			printInventoryMenu();
			int select = inputNumber("선택");
//			runInventoryMenu(select);
		}
	}

}
