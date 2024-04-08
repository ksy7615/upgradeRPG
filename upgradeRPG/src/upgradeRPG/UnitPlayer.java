package upgradeRPG;

public class UnitPlayer extends Unit {
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

		this.maxMp = mp;
		this.mp = maxMp;
		this.level = level;
		this.defence = defence;
		this.exp = exp;
		this.party = false;
	}

	public UnitPlayer(String name, int level, int hp, int mp, int power, int defence, int exp, boolean party) {
		super(name, hp, power);

		this.maxMp = mp;
		this.mp = maxMp;
		this.level = level;
		this.defence = defence;
		this.exp = exp;
		this.party = party;
	}

	public int getLevel() {
		return this.level;
	}

	public int getMaxMp() {
		return this.maxMp;
	}

	public int getMp() {
		return this.mp;
	}

	public int getDefence() {
		return this.defence;
	}

	public int getExp() {
		return this.exp;
	}

	public boolean isParty() {
		return this.party;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public void setMaxMp(int maxMp) {
		this.maxMp = maxMp;
	}

	public void setMp(int mp) {
		this.mp = mp;
	}

	public void setDefence(int defence) {
		this.defence = defence;
	}

	public void setExp(int exp) {
		this.exp = exp;
	}

	public void setParty() {
		this.party = !party;
	}

	public void init() {
		money = 1000;
		guild.setGuild();
	}
	
	public void guildMenu() {
		guild.printGuildMenu();
	}

	@Override
	public void defaultAttack(Unit monster) {
		System.out.println(String.format("[%s]의 기본 공격\n", this.getName()));
		
		monster.setHp(monster.getHp() - this.getPower());

		if (monster.getHp() <= 0) {
			monster.setHp(0);
		}
	}

	@Override
	public void skill(Unit unit) {
		// 스킬 각자 다르게 부여
	}

	@Override
	public void defaultAttack(UnitPlayer player) {
		// 몬스터용이라 공백
	}

}
