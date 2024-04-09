package upgradeRPG;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class FileData {
	File file = null;
	FileWriter fileWriter = null;
	FileReader fileReader = null;
	BufferedReader bufferedReader = null;

	String path = "gameData.txt";

	public void save() throws IOException {
		// (1) 플레이어 유닛 기본 세팅 저장
		UnitManager unitManager = UnitManager.getInstance();

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
		System.out.println(gameData);
		
		fileWriter.write(gameData, 0, gameData.length());
		fileWriter.close();
	}

}
