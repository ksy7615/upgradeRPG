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

	private boolean changeStage() {
		if (curStage.equals(nextStage)) {
			return true;
		}

		curStage = nextStage;
		Stage stage = stageList.get(curStage);
		stage.init();

		boolean isRun = true;
		while (true) {
			isRun = stage.update();
			if (!isRun)
				break;
		}

		if (nextStage.equals("")) {
			return false;
		} else {
			return true;
		}
	}

	public void run() {
		System.out.println("╔══════════════════════╗");
		System.out.println("║⚔️✨🛡️ 𝓡𝓟𝓖 𝓖𝓐𝓜𝓔  🛡️✨⚔️║");
		System.out.println("╚══════════════════════╝");
		boolean run = true;
	    GameManager.getInstance();
	    
	    while (true) {
	      run = GameManager.instance.changeStage();
	      if (run == false) {
	        break;
	      }
	    }
	    System.out.println(" 게임 종료 🔚");
	}
}
