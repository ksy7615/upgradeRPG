package upgradeRPG;

import java.util.ArrayList;

public class PlayerHealer extends UnitPlayer {

	public PlayerHealer() {
		super("힐러", 1, 300, 200, 10, 20, 0);
	}

	public void skill(UnitPlayer[] player) {
		System.out.println(String.format("[%s]의 스킬 [회복]\n", this.getName()));
		int recovery = 100;
		
		for (int i = 0; i<Guild.PARTY_SIZE; i++) {
			player[i].setHp(player[i].getHp() + recovery);
		}
		
		this.setMp(this.getMp() - 50);
		System.out.println(String.format("[%s]가 모두를 [%d]만큼 회복 시켰습니다!\n", this.getName(), recovery));
	}

}
