package upgradeRPG;

import java.util.ArrayList;
import java.util.Scanner;

public class Shop {
	private Scanner scanner = new Scanner(System.in);
	private ArrayList<Item> list = new ArrayList<>();

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

	public void printMenu() {
		System.out.println("======= 상점 =======");
		System.out.println("[1] 무기");
		System.out.println("[2] 갑옷");
		System.out.println("[3] 반지");
		System.out.println("[0] 뒤로가기");
		System.out.println("======= 상점 =======");
	}
	
	private int inputNumber(String message) {
		int number = scanner.nextInt();
		
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
