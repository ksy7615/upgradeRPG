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

}
