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

	private void attackForPlayer(int index) {
		UnitPlayer player = playerList.get(index);

		if (player.getHp() == 0) {
			return;
		}

		System.out.println(String.format("[%s] [1]기본공격 [2]스킬", player.getName()));
		int select = GameManager.scanner.nextInt();

		if (select == 1) {
			while (true) {
				int idx = random.nextInt(monsterList.size());

				if (monsterList.get(idx).getHp() > 0) {
					player.defaultAttack(monsterList.get(idx));
					break;
				}
			}
		}

		else if (select == 2) {
			while (true) {
				int idx = random.nextInt(monsterList.size());

				if (monsterList.get(idx).getHp() > 0) {
					if (!player.getName().equals("힐러")) {
						player.skill(monsterList.get(idx));
						break;
						// 힐러는 스킬 대상이 다르므로
					} else {
						for (int i = 0; i < playerList.size(); i++) {
							player.skill(playerList.get(i));
							break;
						}
					}
				}
			}
		}
	}

	private void attackForMonster(int index) {
		UnitMonster monster = monsterList.get(index);

		if (monster.getHp() == 0) {
			return;
		}

		while (true) {
			int idx = random.nextInt(playerList.size());

			if (playerList.get(idx).getHp() > 0) {
				monster.defaultAttack(playerList.get(idx));
				break;
			}
		}
	}

	@Override
	public boolean update() {
		boolean isRun = true;
		boolean turn = true;
		int playerIndex = 0;
		int monsterIndex = 0;

		while (isRun) {
			if (turn) {
				printState();
				// 플레이어 수만큼 공격 가능
				if (playerIndex < playerList.size()) {
					attackForPlayer(playerIndex);
					playerIndex += 1;
				} else {
					turn = !turn;
					playerIndex = 0;
				}
			} else if (!turn) {
				// 몬스터 수만큼 공격 가능
				if (monsterIndex < monsterList.size()) {
					attackForMonster(monsterIndex);
					monsterIndex += 1;
				} else {
					turn = !turn;
					monsterIndex = 0;
				}
			}
		}
//		GameManager.nextStage = "LOBBY";
		return false;
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub

	}

}
