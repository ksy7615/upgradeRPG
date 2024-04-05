package upgradeRPG;

public class PlayerHealer extends UnitPlayer {

	public PlayerHealer() {
		super("힐러", 1, 300, 200, 10, 20, 0);
	}
	
	public void skill(UnitPlayer player) {
		System.out.println(String.format("[%s]의 스킬 [회복]\n", this.getName()));
		int pray = 100;

		player.setHp(player.getHp() + pray);
		this.setMp(this.getMp() - 50);

		System.out.println(String.format("[%s]가 모두를 [%d]만큼 회복 시켰습니다!\n", this.getName(), pray));
	}

}
