package upgradeRPG;

import java.util.ArrayList;
import java.util.Random;

public class UnitManager {
	private Random random = new Random();
	public static ArrayList<UnitPlayer> playerList = new ArrayList<>();
	public static ArrayList<UnitMonster> monsterList = new ArrayList<>();
	private String path = "upgradeRPG.";
	private String[] monsters = { "MonsterBat", "MonsterGoblin", "MonsterOrc", "MonsterSlime", "MonsterWolf" };
	private UnitPlayer player = new UnitPlayer();
	
	private UnitManager() {
		
	}

	private static UnitManager instance = new UnitManager();

	public static UnitManager getInstance() {
		return instance;
	}
	
	public void playerInit() {
		player.init();
	}
	
	public void setMonster(int size) {
		for (int i = 0; i < size; i++) {
			int num = random.nextInt(monsters.length);
			try {
				Class<?> clazz = Class.forName(path + monsters[num]);
				Object obj = clazz.getDeclaredConstructor().newInstance();

				UnitMonster temp = (UnitMonster) obj;
				monsterList.add(temp);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
