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
	}
	
}
