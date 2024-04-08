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
		UnitPlayer.guild.printGuildList();

		int index = inputNumber("아이템을 장착할 길드원 👉 ") - 1;
		while (true) {
			UnitPlayer.guild.printPlayerStat(index);
			UnitPlayer.guild.printPlayerItem(index);

			printItemList();
			System.out.println("0번) 뒤로가기");
			int itemIndex = inputNumber("장착할 아이템 👉 ") - 1;

			if (itemIndex == 0) {
				break;
			}

			if (itemList.get(itemIndex).kind == Item.WEAPON) {
				// 이미 장착하고 있는 게 있으면
				if (UnitPlayer.guild.getGuildPlayer(index).weapon != null) {
					// 해당 아이템은 아이템 창에 넣고
					inputItem(UnitPlayer.guild.getGuildPlayer(index).weapon);
				}
				// 새로운 아이템 부여
				UnitPlayer.guild.getGuildPlayer(index).weapon = itemList.get(itemIndex);
			}
			
			if (itemList.get(itemIndex).kind == Item.ARMOR) {
				if (UnitPlayer.guild.getGuildPlayer(index).armor != null) {
					inputItem(UnitPlayer.guild.getGuildPlayer(index).armor);
				}
				UnitPlayer.guild.getGuildPlayer(index).armor = itemList.get(itemIndex);
			}
			
			if (itemList.get(itemIndex).kind == Item.RING) {
				if (UnitPlayer.guild.getGuildPlayer(index).ring != null) {
					inputItem(UnitPlayer.guild.getGuildPlayer(index).ring);
				}
				UnitPlayer.guild.getGuildPlayer(index).ring = itemList.get(itemIndex);
			}
			
			// 입은 아이템은 아이템창에서 빼줌
			itemList.remove(itemIndex);
		}
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

			if (itemList.get(i).kind == Item.RING) {
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
