package upgradeRPG;

import java.util.ArrayList;
import java.util.Random;

public class UnitManager {
	private Random random = new Random();
	public static ArrayList<UnitPlayer> playerList = new ArrayList<>();
	public static ArrayList<UnitMonster> monsterList = new ArrayList<>();
	private String path = "upgradeRPG.";
	private String[] monsters = { "MonsterBat", "MonsterGoblin", "MonsterOrc", "MonsterSlime", "MonsterWolf" };

	private UnitManager() {

	}

	private static UnitManager instance = new UnitManager();

	public UnitManager getInstance() {
		return instance;
	}
	
	

}
