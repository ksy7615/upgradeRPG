package upgradeRPG;

public class StageVillage extends Stage {
	private UnitManager unitManager = UnitManager.getInstance();
	private Shop shop;

	@Override
	public boolean update() {
		while (true) {
			System.out.println("╔══════════════════════╗");
			System.out.println("         VILLAGE        ");
			System.out.println("        [1] 길드         ");
			System.out.println("        [2] 상점         ");
			System.out.println("        [3] 인벤토리       ");
			System.out.println("        [4] 저장         ");
			System.out.println("        [5] 로드         ");
			System.out.println("        [0] 뒤로가기       ");
			System.out.println("╚══════════════════════╝");

			System.out.print("👉 ");
			int select = GameManager.scanner.nextInt();

			if (select == 1) {
				unitManager.player.guild.setGuild();
				unitManager.player.guild.runGuild();
			} else if (select == 2) {
				shop = new Shop();
				shop.runShop();
			} else if (select == 3) {
				unitManager.player.inven.runInventory();
			} else if (select == 4) {
				try {
					FileData.save();
				} catch (Exception e) {
				}
			} else if (select == 5) {
				try {
					FileData.loadData();
				} catch (Exception e) {
				}
			} else if (select == 0) {
				GameManager.nextStage = "LOBBY";
				break;
			}
		}
		GameManager.scanner.close();
		return false;
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub

	}

}
