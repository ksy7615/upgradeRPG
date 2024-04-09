package upgradeRPG;

import java.util.ArrayList;
import java.util.Random;

public class StageMimic extends Stage {
	private Random random = new Random();
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

	private void attackForPlayer(int index) {
		UnitPlayer players = player.get(index);

		if (players.getHp() == 0) {
			return;
		}
		System.out.println(String.format("[%s] [1]기본공격 [2]스킬", players.getName()));
		System.out.println("👉 ");
		int select = GameManager.scanner.nextInt();

		if (select == 1) {
			while (true) {

				if (mimic.getHp() > 0) {
					players.defaultAttack(mimic);
					break;
				}
			}
		}

		else if (select == 2) {
			while (true) {
				if (mimic.getHp() > 0) {
					if (!players.getName().equals("힐러")) {
						players.skill(mimic);
						break;
						// 힐러는 스킬 대상이 다르므로
					} else {
						for (int i = 0; i < player.size(); i++) {
							players.skill(player.get(i));
							break;
						}
					}
				}
			}
		}
	}
	
	private void attackForMonster() {
		if (mimic.getHp() <= 0) {
			return;
		}

		while (true) {
			int idx = random.nextInt(player.size());

			if (player.get(idx).getHp() > 0) {
				mimic.defaultAttack(player.get(idx));
				break;
			}
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
