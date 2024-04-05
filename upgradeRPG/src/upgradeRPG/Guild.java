package upgradeRPG;

import java.util.ArrayList;
import java.util.Random;

public class Guild {
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
}
