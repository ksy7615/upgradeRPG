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
	
	public UnitPlayer() {
		
	}
	
	public UnitPlayer(String name, int level, int hp, int mp, int power, int defence, int exp) {
		super(name, hp, power);
		
		this.level = level;
		this.defence = defence;
		this.exp = exp;
		this.party = false;
	}
	
	public UnitPlayer(String name, int level, int hp, int mp, int power, int defence, int exp, boolean party) {
		super(name, hp, power);
		
		this.level = level;
		this.defence = defence;
		this.exp = exp;
		this.party = party;
	}

	public void init() {
		money = 1000;
		guild.setGuild();
	}
	


}
