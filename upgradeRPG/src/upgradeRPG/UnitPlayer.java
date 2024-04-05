package upgradeRPG;

public abstract class UnitPlayer extends Unit {
	private int level;
	private int maxMp;
	private int mp;
	private int defence;
	private int exp;

	private boolean party;

	public static int money;
	public static Inventory inven = new Inventory();
	public static Guild guild = new Guild();

	public void init() {
		money = 1000;
		guild.setGuild();
	}

	public UnitPlayer() {
		
	}

	public UnitPlayer(String name, int level, int hp, int mp, int power, int defence, int exp) {
		super(name, level, hp, mp, power, defence, exp);
	}

	public UnitPlayer(String name, int level, int hp, int mp, int power, int defence, int exp, boolean party) {
		super(name, level, hp, mp, power, defence, exp, false);
	}

}
