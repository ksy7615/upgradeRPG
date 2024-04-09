package upgradeRPG;

import java.util.Random;

public class StageBigReward extends Stage {
	private Random random = new Random();
	private UnitPlayer player = new UnitPlayer();
	
	@Override
	public boolean update() {
		System.out.println("‼‼‼‼ 엄청난 금은보화였다 ‼‼‼‼");
		int ranMoney = random.nextInt(90000)+10000;
		
		System.out.println(String.format("💵 %d원을 획득했습니다.", ranMoney));
		player.money += ranMoney;
		
		GameManager.nextStage = "LOBBY";
		return false;
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
		
	}

}
