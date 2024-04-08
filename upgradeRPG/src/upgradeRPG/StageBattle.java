package upgradeRPG;

import java.util.ArrayList;
import java.util.Random;

public class StageBattle extends Stage {
	private Random random = new Random();
	private ArrayList<UnitPlayer> playerList = new ArrayList<>();
	private ArrayList<UnitMonster> monsterList = new ArrayList<>();
	private UnitManager unitManager = UnitManager.getInstance();

	public StageBattle() {
		unitManager.setMonster(5);
		playerList = unitManager.playerList;
		monsterList = unitManager.monsterList;
	}

	private void printState() {
		System.out.println("==== PLAYER ====");
		for (int i = 0; i < playerList.size(); i++) {
			System.out.println(String.format("Player 직업 '%s'", playerList.get(i).getName()));
			System.out.println(String.format("❤️ HP [%d/%d]", playerList.get(i).getHp(), playerList.get(i).getMaxHp()));
			System.out.println(String.format("💧 MP [%d/%d]", playerList.get(i).getMp(), playerList.get(i).getMaxHp()));
			if (i < playerList.size() - 1)
				System.out.println("〰〰〰〰〰〰〰〰〰〰〰〰");
		}
		System.out.println("==== MONSTER ====");
		for (int i = 0; i < monsterList.size(); i++) {
			System.out.println(String.format("Monster '%s'", monsterList.get(i).getName()));
			System.out
					.println(String.format("❤️ HP [%d/%d]", monsterList.get(i).getHp(), monsterList.get(i).getMaxHp()));
		}
	}

	@Override
	public boolean update() {
		return false;
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub

	}

}
