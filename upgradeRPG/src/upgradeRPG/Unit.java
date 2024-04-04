package upgradeRPG;

public class Unit {
	private String name;
	private int level;
	
	private int maxHp;
	private int hp;
	private int maxMp;
	private int mp;
	
	private int power;
	private int defence;
	private int exp;
	
	private boolean party;
	
	// 플레이어용
	public Unit(String name, int level, int hp, int mp, int power, int defence, int exp) {
		this.name = name;
		this.level = level;
		this.maxHp = hp;
		this.hp = maxHp;
		this.power = power;
		this.defence = defence;
		this.exp = exp;
		this.party = false;
	}
	
	// 플레이어용 생성자 오버로딩
	public Unit(String name, int level, int hp, int mp, int power, int defence, int exp, boolean party) {
		this.name = name;
		this.level = level;
		this.maxHp = hp;
		this.hp = maxHp;
		this.power = power;
		this.defence = defence;
		this.exp = exp;
		this.party = party;
	}
	
	// 몬스터용
	public Unit(String name, int hp, int power) {
		this.name = name;
		this.maxHp = hp;
		this.hp = maxHp;
		this.power = power;
	}

	public String getName() {
		return this.name;
	}

	public int getLevel() {
		return this.level;
	}

	public int getMaxHp() {
		return this.maxHp;
	}

	public int getHp() {
		return this.hp;
	}

	public int getMaxMp() {
		return this.maxMp;
	}

	public int getMp() {
		return this.mp;
	}

	public int getPower() {
		return this.power;
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

	public void setMaxHp(int maxHp) {
		this.maxHp = maxHp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	public void setMaxMp(int maxMp) {
		this.maxMp = maxMp;
	}

	public void setMp(int mp) {
		this.mp = mp;
	}

	public void setPower(int power) {
		this.power = power;
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

}
