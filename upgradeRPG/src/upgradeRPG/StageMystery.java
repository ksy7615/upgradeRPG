package upgradeRPG;

import java.util.Random;

public class StageMystery extends Stage {
	private Random random = new Random();

	@Override
	public boolean update() {
		System.out.println("꺼림칙한 분위기와는 달리 아무 일도 일어나지 않는다...");
		System.out.println("방 안에는 큰 보물상자만이 존재한다.");
		System.out.println("열어볼까? [1] 예 [2] 아니오");
		System.out.println("👉 ");
		int select = GameManager.scanner.nextInt();

		if (select == 1) {
			int r = random.nextInt(2);

			if (r == 0) {
				GameManager.nextStage = "BIGREWARD";
				return false;
			} else {
				GameManager.nextStage = "MIMIC";
				return false;
			}
		} else if (select == 2) {
			System.out.println("로비로 돌아갑니다.");
			GameManager.nextStage = "LOBBY";
			return false;
		}
		return false;
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub

	}

}
