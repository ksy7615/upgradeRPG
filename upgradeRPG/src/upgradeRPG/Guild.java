package upgradeRPG;

import java.util.ArrayList;
import java.util.Scanner;

public class Guild {
	private Scanner scanner = new Scanner(System.in);
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
			if (guildList.get(i).isParty()) {
				partyList[index++] = guildList.get(i);
			}
		}
	}

	public void printGuildMenu() {
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
		for (int i = 0; i < guildList.size(); i++) {
			System.out.println(String.format("  %d) 직업 : %s", i + 1, guildList.get(i).getName()));
			System.out.println(String.format("  🎮 Lv : %d", guildList.get(i).getLevel()));
			System.out.println(String.format("  🌟 Exp : %d", guildList.get(i).getExp()));
			System.out
					.println(String.format("  ❤️ HP : [%d/%d]", guildList.get(i).getHp(), guildList.get(i).getMaxHp()));
			System.out
					.println(String.format("  💧 MP : [%d/%d]", guildList.get(i).getMp(), guildList.get(i).getMaxMp()));
			System.out.println(String.format("  💪 Power : %d", guildList.get(i).getPower()));
			System.out.println(String.format("  🛡️ Defence : %d", guildList.get(i).getDefence()));
			if (i < guildList.size() - 1)
				System.out.println(" 〰〰〰〰〰〰〰〰〰〰〰〰〰〰〰〰〰〰〰〰");
		}
		System.out.println("╚═══════════════════════════╝");
	}

	private void addGuildMember() {
		ArrayList<UnitPlayer> list = new ArrayList<>();

		PlayerWarrior warrior = new PlayerWarrior();
		PlayerTanker tanker = new PlayerTanker();
		PlayerWizard wizard = new PlayerWizard();
		PlayerHealer healer = new PlayerHealer();

		list.add(warrior);
		list.add(tanker);
		list.add(wizard);
		list.add(healer);

		System.out.println("  👤  \u001B[92m길드에 새로운 플레이어를 영입하고자 해요 !\u001B[0m");
		System.out.println("  👤  \u001B[92m어떤 직업의 플레이어를 새로 영입할까요 ?\u001B[0m");

		for (int i = 0; i < list.size(); i++) {
			System.out.println(String.format("%d) %s [❤️ %d / 💧 %d / 💪 %d / 🛡️ %d]", i + 1, list.get(i).getName(),
					list.get(i).getMaxHp(), list.get(i).getMaxMp(), list.get(i).getPower(), list.get(i).getDefence()));
		}
		System.out.print("👉 ");
		int index = GameManager.scanner.nextInt() - 1;
		UnitPlayer player = list.get(index);

		guildList.add(player);
		System.out.println("  👤  '" + player.getName() + "' \u001B[92m영입에 성공했습니다 !\u001B[0m");
	}

	private UnitPlayer getGuildPlayer(int index) {
		return guildList.get(index);
	}

	private void deleteGuildMember() {
		printGuildList();
		System.out.print("추방할 길드원 👉 ");
		int index = GameManager.scanner.nextInt() - 1;

		UnitPlayer target = getGuildPlayer(index);

		if (target.isParty()) {
			System.err.println("파티 중인 길드원은 추방할 수 없습니다.");
			return;
		}

		guildList.remove(target);
		System.out.println(String.format("%s 길드원을 추방시켰습니다.", target.getName()));
	}

	private void printPartyMember() {
		System.out.println("╔══════════파티원 목록══════════╗");
		for (int i = 0; i < PARTY_SIZE; i++) {
			System.out.println(String.format("  %d) 직업 : %s", i + 1, partyList[i].getName()));
			System.out.println(String.format("  🎮 Lv : %d", partyList[i].getLevel()));
			System.out.println(String.format("  🌟 Exp : %d", partyList[i].getExp()));
			System.out.println(String.format("  ❤️ HP : [%d/%d]", partyList[i].getHp(), partyList[i].getMaxHp()));
			System.out.println(String.format("  💧 MP : [%d/%d]", partyList[i].getMp(), partyList[i].getMaxMp()));
			System.out.println(String.format("  💪 Power : %d", partyList[i].getPower()));
			System.out.println(String.format("  🛡️ Defence : %d", partyList[i].getDefence()));
			if (i < partyList.length - 1)
				System.out.println(" 〰〰〰〰〰〰〰〰〰〰〰〰〰〰〰〰〰〰〰〰");
		}
		System.out.println("╚═══════════════════════════╝");
	}

	private void changePartyMember() {
		printPartyMember();

		System.out.println("교체할 파티원 👉 ");
		int targetIndex = GameManager.scanner.nextInt() - 1;

		UnitPlayer target = partyList[targetIndex];
		target.setParty();

		printGuildList();
		System.out.println("파티에 참여시킬 길드원 👉 ");
		int index = GameManager.scanner.nextInt() - 1;

		if (guildList.get(index).isParty()) {
			System.err.println("이미 파티에 참여중인 길드원입니다.");
			return;
		}

		guildList.get(index).setParty();

		// 파티 재설정
		int n = 0;
		for (int i = 0; i < guildList.size(); i++) {
			if (guildList.get(i).isParty()) {
				partyList[n] = guildList.get(i);
				n += 1;
			}
		}

		System.out.println(String.format("파티원이 %s(Lv.%d)에서 %s(Lv.%d)로 바뀌었습니다.", target.getName(), target.getLevel(),
				guildList.get(index).getName(), guildList.get(index).getLevel()));
	}

	private void sortGuildList() {
		for (int i = 0; i < guildList.size(); i++) {
			UnitPlayer temp = guildList.get(i);

			int index = i;
			for (int j = i; j < guildList.size(); j++) {
				if (temp.getLevel() < guildList.get(j).getLevel()) {
					temp = guildList.get(j);
					index = j;
				}
			}
			UnitPlayer player = guildList.get(index);
			guildList.set(index, guildList.get(i));
			guildList.set(i, player);
		}
		printGuildList();
	}

	private void runGuildMenu(int select) {
		if (select == 1)
			printGuildList();
		else if (select == 2)
			addGuildMember();
		else if (select == 3)
			deleteGuildMember();
		else if (select == 4)
			changePartyMember();
		else if(select == 5)
			sortGuildList();
		else if (select == 0)
			isRun = false;
	}

	public void runGuild() {
		while (isRun) {
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
