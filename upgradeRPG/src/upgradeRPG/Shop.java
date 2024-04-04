package upgradeRPG;

import java.util.ArrayList;
import java.util.Scanner;

public class Shop {
	private Scanner scanner = new Scanner(System.in);
	private ArrayList<Item> list = new ArrayList<>();
	private boolean isRun = true;

	public Shop() {
		list.add(new Item(Item.WEAPON, "단검", 5, 1000));
		list.add(new Item(Item.WEAPON, "소드", 10, 3000));
		list.add(new Item(Item.WEAPON, "스피어", 15, 5000));

		list.add(new Item(Item.ARMOR, "투구", 7, 2000));
		list.add(new Item(Item.ARMOR, "갑옷", 20, 10000));
		list.add(new Item(Item.ARMOR, "망토", 5, 1500));

		list.add(new Item(Item.RING, "합금링", 8, 3500));
		list.add(new Item(Item.RING, "실버링", 20, 10000));
		list.add(new Item(Item.RING, "골드링", 35, 30000));
	}

	private void printMenu() {
		System.out.println("======= 상점 =======");
		System.out.println("[1] 무기");
		System.out.println("[2] 갑옷");
		System.out.println("[3] 반지");
		System.out.println("[0] 뒤로가기");
		System.out.println("==================");
	}

	private void printWeapon() {
		System.out.println("======= 무기 =======");
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).kind == Item.WEAPON) {
				System.out.println(String.format("%d번) [%s] [공격력 +%d↑] [가격:%d]", i + 1, list.get(i).name,
						list.get(i).effect, list.get(i).price));
			}
		}
		System.out.println("==================");
	}

	private void buyWeapon(int select) {
		if (select == 1 || select == 2 || select == 3) {
			UnitPlayer.inven.inputItem(list.get(select - 1));
			UnitPlayer.money -= list.get(select - 1).price;
			System.out.println(list.get(select - 1).name + "을(를) 구입했습니다.");
		} else
			return;
	}

	private void runMenu(int select) {
		if (select == Item.WEAPON) {
			printWeapon();
			buyWeapon(inputNumber("선택"));
		}
//		else if (select == Item.ARMOR)
//			buyArmor();
//		else if (select == Item.RING)
//			buyRing();
		else if (select == 0)
			isRun = false;
	}

	public void runShop() {
		while (isRun) {
			printMenu();
			runMenu(inputNumber("선택"));
		}
	}

	private int inputNumber(String message) {
		int number = -1;

		try {
			System.out.print(message + " : ");
			String input = scanner.next();
			number = Integer.parseInt(input);
		} catch (Exception e) {
			System.err.println("숫자만 입력하세요.");
		}
		return number;
	}

}
