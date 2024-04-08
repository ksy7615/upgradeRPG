package upgradeRPG;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class GameManager {
	public static Scanner scanner = new Scanner(System.in);
	private Map<String, Stage> stageList = new HashMap<String, Stage>();
	public static String nextStage = "";
	private String curStage = "";

	private GameManager() {
		stageList.put("LOBBY", new StageLobby());
		stageList.put("VILLAGE", new StageVillage());
		stageList.put("BATTLE", new StageBattle());
		stageList.put("REWARD", new StageReward());
		stageList.put("MYSTERY", new StageMystery());
		stageList.put("BIGREWARD", new StageBigReward());
		stageList.put("MIMIC", new StageMimic());

		nextStage = "LOBBY";
	}
	
	private static GameManager instance = new GameManager();
	
	public static GameManager getInstance() {
		return instance;
	}
}
