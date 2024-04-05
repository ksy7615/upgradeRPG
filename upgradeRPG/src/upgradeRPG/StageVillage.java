package upgradeRPG;

public class StageVillage extends Stage {
	private UnitManager unitManager = UnitManager.getInstance();
	private Shop shop;

	@Override
	public boolean update() {
		System.out.println("╔══════════════════════╗");
		System.out.println("         VILLAGE        ");
		System.out.println("        [1] 길드         ");
		System.out.println("        [2] 상점         ");
		System.out.println("        [3] 인벤토리       ");
		System.out.println("        [4] 저장         ");
		System.out.println("        [5] 로드         ");
		System.out.println("        [0] 뒤로가기       ");
		System.out.println("╚══════════════════════╝");

		System.out.print("☞ ");
		int select = GameManager.scanner.nextInt();

		if (select == 1) {
			
		} else if (select == 2) {

		} else if (select == 3) {

		} else if (select == 4) {

		} else if (select == 5) {

		} else if (select == 0) {
			GameManager.nextStage = "";
		}

		return false;
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub

	}

}
