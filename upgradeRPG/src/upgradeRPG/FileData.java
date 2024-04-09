package upgradeRPG;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class FileData {

	public static void save() throws IOException {
		// (1) 플레이어 유닛 기본 세팅 저장
		UnitManager unitManager = UnitManager.getInstance();

		FileWriter fileWriter = null;
		String path = "gameData.txt";
		fileWriter = new FileWriter(path);
		ArrayList<UnitPlayer> temp = unitManager.player.guild.guildList;

		String gameData = "";

		gameData += UnitPlayer.money + "\r\n" + temp.size() + "\r\n";

		// 길드원 저장
		for (int i = 0; i < temp.size(); i++) {
			gameData += temp.get(i).getName();
			gameData += "/";
			gameData += temp.get(i).getLevel();
			gameData += "/";
			gameData += temp.get(i).getMaxHp();
			gameData += "/";
			gameData += temp.get(i).getMaxMp();
			gameData += "/";
			gameData += temp.get(i).getPower();
			gameData += "/";
			gameData += temp.get(i).getDefence();
			gameData += "/";
			gameData += temp.get(i).getExp();
			gameData += "/";
			gameData += temp.get(i).isParty();
			gameData += "\r\n";

			// 장착하고 있는 아이템 저장
			if (temp.get(i).weapon == null) {
				gameData += temp.get(i).weapon;
			} else {
				Item item = temp.get(i).weapon;
				String weaponData = "";
				weaponData += item.kind;
				weaponData += ",";
				weaponData += item.name;
				weaponData += ",";
				weaponData += item.effect;
				weaponData += ",";
				weaponData += item.price;
				gameData += weaponData;
			}
			gameData += "/";
			if (temp.get(i).armor == null) {
				gameData += temp.get(i).armor;
			} else {
				Item item = temp.get(i).armor;
				String armorData = "";
				armorData += item.kind;
				armorData += ",";
				armorData += item.name;
				armorData += ",";
				armorData += item.effect;
				armorData += ",";
				armorData += item.price;
				gameData += armorData;
			}
			gameData += "/";
			if (temp.get(i).ring == null) {
				gameData += temp.get(i).ring;
			} else {
				Item item = temp.get(i).ring;
				String ringData = "";
				ringData += item.kind;
				ringData += ",";
				ringData += item.name;
				ringData += ",";
				ringData += item.effect;
				ringData += ",";
				ringData += item.price;
				gameData += ringData;
			}
			gameData += "\r\n";
		}
		// 아이템 개수 저장
		gameData += UnitPlayer.getItemSize();
		gameData += "\r\n";

		// 아이템 저장
		for (int i = 0; i < UnitPlayer.getItemSize(); i++) {
			Item item = UnitPlayer.inven.itemList.get(i);
			gameData += item.kind;
			gameData += ",";
			gameData += item.name;
			gameData += ",";
			gameData += item.effect;
			gameData += ",";
			gameData += item.price;
			gameData += "\r\n";
		}
		fileWriter.write(gameData, 0, gameData.length());
		fileWriter.close();
	}

	public static void loadData() throws IOException {
		File file = null;
		FileReader fileReader = null;
		BufferedReader bufferedReader = null;
		String path = "gameData.txt";

		file = new File(path);
		if (file.exists()) {
			fileReader = new FileReader(file);
			bufferedReader = new BufferedReader(fileReader);

			// 돈
			String money = bufferedReader.readLine();
			UnitPlayer.money = Integer.parseInt(money);
			System.out.println(UnitPlayer.money);

			// 길드원 수
			String guildSize = bufferedReader.readLine();
			int size = Integer.parseInt(guildSize);
			UnitPlayer.guild.guildList.clear();
			System.out.println(size);

			// 길드원 가져오기
			for (int i = 0; i < size; i++) {
				String unitData = bufferedReader.readLine();
				String[] unitArray = unitData.split("/");
				String name = unitArray[0];
				int level = Integer.parseInt(unitArray[1]);
				int maxHp = Integer.parseInt(unitArray[2]);
				int maxMp = Integer.parseInt(unitArray[3]);
				int power = Integer.parseInt(unitArray[4]);
				int defence = Integer.parseInt(unitArray[5]);
				int exp = Integer.parseInt(unitArray[6]);
				boolean isParty = unitArray[7].equals("true");

				UnitPlayer player = new UnitPlayer(name, level, maxHp, maxMp, power, defence, exp, isParty);
				UnitPlayer.guild.guildList.add(player);

				// 아이템 가져오기
				String itemData = bufferedReader.readLine();
				String[] itemArray = itemData.split("/");

				// >>> 무기
				if (itemArray[0].equals("null")) {
					UnitPlayer.guild.guildList.get(i).weapon = null;
				} else {
					String[] weapon = itemArray[0].split(",");
					int itemKind = Integer.parseInt(weapon[0]);
					String itemName = weapon[1];
					int itemEffect = Integer.parseInt(weapon[2]);
					int itemPrice = Integer.parseInt(weapon[3]);

					Item item = new Item(itemKind, itemName, itemEffect, itemPrice);
					UnitPlayer.guild.guildList.get(i).weapon = item;
				}

				// >>> 갑옷
				if (itemArray[1].equals("null")) {
					UnitPlayer.guild.guildList.get(i).armor = null;
				} else {
					String[] armor = itemArray[1].split(",");
					int itemKind = Integer.parseInt(armor[0]);
					String itemName = armor[1];
					int itemEffect = Integer.parseInt(armor[2]);
					int itemPrice = Integer.parseInt(armor[3]);

					Item item = new Item(itemKind, itemName, itemEffect, itemPrice);
					UnitPlayer.guild.guildList.get(i).armor = item;
				}

				// >>> 반지
				if (itemArray[2].equals("null")) {
					UnitPlayer.guild.guildList.get(i).ring = null;
				} else {
					String[] ring = itemArray[2].split(",");
					int itemKind = Integer.parseInt(ring[0]);
					String itemName = ring[1];
					int itemEffect = Integer.parseInt(ring[2]);
					int itemPrice = Integer.parseInt(ring[3]);

					Item item = new Item(itemKind, itemName, itemEffect, itemPrice);
					UnitPlayer.guild.guildList.get(i).ring = item;
				}
			}
			// >>> 인벤토리
			String invenSize = bufferedReader.readLine();
			System.out.println(invenSize);
			int inventorySize = Integer.parseInt(invenSize);

			UnitPlayer.inven.itemList.clear();

			for (int i = 0; i < inventorySize; i++) {
				String invenData = bufferedReader.readLine();
				String[] invenArray = invenData.split("/");
				int itemKind = Integer.parseInt(invenArray[0]);
				String itemName = invenArray[1];
				int itemEffect = Integer.parseInt(invenArray[2]);
				int itemPrice = Integer.parseInt(invenArray[3]);

				Item item = new Item(itemKind, itemName, itemEffect, itemPrice);
				UnitPlayer.inven.itemList.add(item);
			}
		} else {
			System.err.println("불러올 파일이 존재하지 않습니다.");
			return;
		}
	}

}
