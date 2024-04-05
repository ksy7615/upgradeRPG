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
	
	public void runGuild() {
		while(true) {
//			printGuildMenu();
			int select = inputNumber("☞");
//			runGuildMenu(select);
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
