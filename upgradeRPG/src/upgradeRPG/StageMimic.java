package upgradeRPG;

import java.util.ArrayList;

public class StageMimic extends Stage {
	private MonsterMimic mimic = new MonsterMimic();
	private ArrayList<UnitPlayer> player = StageBattle.playerList;

	private int deadPlayer;

	public StageMimic() {
		deadPlayer = player.size();
	}

	private void printState() {
		System.out.println("==== PLAYER ====");
		for (int i = 0; i < player.size(); i++) {
			System.out.println(String.format("Player 직업 '%s'", player.get(i).getName()));
			System.out.println(String.format("❤️ HP [%d/%d]", player.get(i).getHp(), player.get(i).getMaxHp()));
			System.out.println(String.format("💧 MP [%d/%d]", player.get(i).getMp(), player.get(i).getMaxHp()));
			if (i < player.size() - 1)
				System.out.println("〰〰〰〰〰〰〰〰〰〰〰〰");
		}
		System.out.println("==== MONSTER ====");
		System.out.println(String.format("Monster '%s'", mimic.getName()));
		System.out.println(String.format("❤️ HP [%d/%d]", mimic.getHp(), mimic.getMaxHp()));
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
