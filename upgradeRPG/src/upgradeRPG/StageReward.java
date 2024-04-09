package upgradeRPG;

import java.util.Random;

public class StageReward extends Stage {
	private UnitPlayer player = new UnitPlayer();
	private Random random = new Random();

	@Override
	public boolean update() {
		int ranMoney = random.nextInt(4000)+1000;
		
		System.out.println(String.format("🪙 %d원을 획득했습니다.", ranMoney));
		player.money += ranMoney;
		
		GameManager.nextStage = "LOBBY";
		return false;
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
		
	}

}
