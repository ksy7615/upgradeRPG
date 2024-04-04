package upgradeRPG;

import java.util.ArrayList;
import java.util.Random;

public class Guild {
	private Random random = new Random();
	private static final int PARTY_SIZE = 4;
	private ArrayList<UnitPlayer> guildList = new ArrayList<>();
	private UnitPlayer[] partyList;
}
