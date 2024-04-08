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

	public Item weapon;
	public Item armor;
	public Item ring;

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

	public void playerStat() {
		System.out.println(String.format("[Lv.%d] 직업 '%s'", this.getLevel(), this.getName()));

		if (ring != null)
			System.out.println(
					String.format("  ❤️ HP : [%d/%d]", this.getHp() + ring.effect, this.getMaxHp() + ring.effect));
		else
			System.out.println(String.format("  ❤️ HP : [%d/%d]", this.getHp(), this.getMaxHp()));

		System.out.println(String.format("  💧 MP : [%d/%d]", this.getMp(), this.getMaxMp()));

		if (weapon != null)
			System.out.println(String.format("  💪 Power : %d", this.getPower() + weapon.effect));
		else
			System.out.println(String.format("  💪 Power : %d", this.getPower()));

		if (armor != null)
			System.out.println(String.format("  🛡️ Defence : %d", this.getDefence() + armor.effect));
		else
			System.out.println(String.format("  🛡️ Defence : %d", this.getDefence()));

		System.out.println(String.format("  👥 Party : %s", this.isParty() ? "O" : "X"));
	}

	public void playerItem() {
		System.out.println(String.format("  ⚔ 무기 : %s", this.weapon == null ? "없음" : this.weapon.name));
		System.out.println(String.format("  🪖 방어구 : %s", this.armor == null ? "없음" : this.armor.name));
		System.out.println(String.format("  💍 반지 : %s", this.ring == null ? "없음" : this.ring.name));
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
