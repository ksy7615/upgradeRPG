package upgradeRPG;

import java.util.ArrayList;

public class PlayerHealer extends UnitPlayer {

	public PlayerHealer() {
		super("힐러", 1, 300, 200, 10, 20, 0);
	}

	public void skill(ArrayList<UnitPlayer> player) {
		System.out.println(String.format("[%s]의 스킬 [회복]\n", this.getName()));
		int recovery = 100;
		
		// 파티원 모두 회복 시켜주기 >> 이렇게 돌리면 다 .. 회복 들어가나 *돌려보고 수정하기
		for (int i = 0; i<Guild.PARTY_SIZE; i++) {
			player.get(i).setHp(player.get(i).getHp() + recovery);
		}
		
		this.setMp(this.getMp() - 50);
		System.out.println(String.format("[%s]가 모두를 [%d]만큼 회복 시켰습니다!\n", this.getName(), recovery));
	}

}
