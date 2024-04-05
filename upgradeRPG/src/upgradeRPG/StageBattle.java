package upgradeRPG;

import java.util.ArrayList;
import java.util.Random;

public class StageBattle extends Stage {
	private Random random = new Random();
	private ArrayList<UnitPlayer> playerList = new ArrayList<>();
	private ArrayList<UnitMonster> monsterList = new ArrayList<>();
	private UnitManager unitManager = UnitManager.getInstance();

	@Override
	public boolean update() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
		
	}

}
