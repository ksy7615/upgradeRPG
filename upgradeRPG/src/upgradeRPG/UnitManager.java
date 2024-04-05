package upgradeRPG;

import java.util.ArrayList;

public class UnitManager {
	private ArrayList<UnitPlayer> playerList = new ArrayList<>();
	private ArrayList<UnitMonster> monsterList = new ArrayList<>();
	private String path = "upgradeRPG.";
	private String[] monsters = { "MonsterBat", "MonsterGoblin", "MonsterOrc", "MonsterSlime", "MonsterWolf" };

	private UnitManager() {

	}

	private static UnitManager instance = new UnitManager();

	public UnitManager getInstance() {
		return instance;
	}

}
