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
		System.out.println("[1] 장비 착용");
		System.out.println("[2] 아이템 판매");
		System.out.println("[0] 뒤로가기");
		System.out.println("=====================");
	}

	private void wearEquipment() {

	}

	private void printItemList() {
		System.out.println("======= 아이템창 =======");
		for (int i = 0; i < itemList.size(); i++) {
			if (itemList.get(i).kind == Item.WEAPON) {
				System.out.println(String.format("%d번) [%s] [공격력 +%d↑] [가격:%d]", i + 1, itemList.get(i).name,
						itemList.get(i).effect, itemList.get(i).price));
			}
			
			if (itemList.get(i).kind == Item.ARMOR) {
				System.out.println(String.format("%d번) [%s] [방어력 +%d↑] [가격:%d]", i + 1, itemList.get(i).name,
						itemList.get(i).effect, itemList.get(i).price));
			}
			
			if(itemList.get(i).kind == Item.RING) {
				System.out.println(String.format("%d번) [%s] [체력 +%d↑] [가격:%d]", i + 1, itemList.get(i).name,
						itemList.get(i).effect, itemList.get(i).price));
			}
		}
		System.out.println("=====================");
	}

	public void runInventoryMenu(int select) {
		if (select == 1)
			wearEquipment();
//		else if(select == 2)
//			sellItem();
//		else if(select == 3)
		isRun = false;
	}

	private int inputNumber(String message) {
		System.out.println(message + " : ");
		return GameManager.scanner.nextInt();
	}

	public void runInventory() {
		while (isRun) {
			printInventoryMenu();
			int select = inputNumber("선택");
			runInventoryMenu(select);
		}
	}

}
