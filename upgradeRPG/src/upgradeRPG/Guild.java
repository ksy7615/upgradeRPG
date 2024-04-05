package upgradeRPG;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Guild {
	private Scanner scanner = new Scanner(System.in);
	private Random random = new Random();
	public static final int PARTY_SIZE = 4;
	private ArrayList<UnitPlayer> guildList = new ArrayList<>();
	private UnitPlayer[] partyList;
	private boolean isRun = true;

	public void setGuild() {
		PlayerWarrior warrior = new PlayerWarrior();
		PlayerTanker tanker = new PlayerTanker();
		PlayerWizard wizard = new PlayerWizard();
		PlayerHealer healer = new PlayerHealer();

		guildList.add(warrior);
		guildList.add(tanker);
		guildList.add(wizard);
		guildList.add(healer);

		for (int i = 0; i < PARTY_SIZE; i++) {
			guildList.get(i).setParty();
		}

		partyList = new UnitPlayer[PARTY_SIZE];

		int index = 0;
		for (int i = 0; i < guildList.size(); i++) {
			if(guildList.get(i).isParty()) {
				partyList[index++] = guildList.get(i);
			}
		}
	}
	
	private void printGuildMenu() {
		System.out.println("╔══════════════════════╗");
		System.out.println("          Guild        ");
		System.out.println("       [1] 길드원 목록     ");
		System.out.println("       [2] 길드원 추가     ");
		System.out.println("       [3] 길드원 삭제     ");
		System.out.println("       [4] 파티원 교체     ");
		System.out.println("       [5] 정렬          ");
		System.out.println("       [0] 뒤로가기        ");
		System.out.println("╚══════════════════════╝");
	}
	
	private void printGuildList() {
		System.out.println("╔══════════길드원 목록══════════╗");
		for(int i=0; i<guildList.size(); i++) {
			System.out.println(String.format("  %d) 직업 : %s", i+1,guildList.get(i).getName()));
			System.out.println(String.format("  🎮 Lv : %d", guildList.get(i).getLevel()));
			System.out.println(String.format("  🌟 Exp : %d", guildList.get(i).getExp()));
			System.out.println(String.format("  ❤️ HP : [%d/%d]", guildList.get(i).getHp(), guildList.get(i).getMaxHp()));
			System.out.println(String.format("  💧 MP : [%d/%d]", guildList.get(i).getMp(), guildList.get(i).getMaxMp()));
			System.out.println(String.format("  💪 Power : %d", guildList.get(i).getPower()));
			System.out.println(String.format("  🛡️ Defence : %d", guildList.get(i).getDefence()));
			if(i < guildList.size() - 1)
				System.out.println(" 〰〰〰〰〰〰〰〰〰〰〰〰〰〰〰〰〰〰〰〰");
		}
		System.out.println("╚═══════════════════════════╝");
	}
	
	private void runGuildMenu(int select) {
		if(select == 1)
			printGuildList();
//		else if(select == 2)
//			AddGuildMember();
//		else if(select == 3)
//			deleteGuildMember();
//		else if(select == 4)
//			changePartyMember();
//		else if(select == 5)
//			sortGuildList();
		else if(select == 0)
			isRun = false;
	}
	
	public void runGuild() {
		while(isRun) {
			printGuildMenu();
			int select = inputNumber("☞");
			runGuildMenu(select);
		}
	}
	
	private int inputNumber(String message) {
		int number = -1;
		
		try {
			System.out.print(message + " ");
			String input = scanner.next();
			number = Integer.parseInt(input);
		} catch (Exception e) {
			System.err.println("숫자를 입력하세요.");
		}
		return number;
	}
}
