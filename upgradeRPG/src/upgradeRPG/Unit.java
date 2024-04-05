package upgradeRPG;

public abstract class Unit {
	private String name;
	private int maxHp;
	private int hp;
	private int power;
	
	public Unit() {
		
	}
	
	// 몬스터 & 플레이어 공용 속성
	public Unit(String name, int hp, int power) {
		this.name = name;
		this.maxHp = hp;
		this.hp = maxHp;
		this.power = power;
	}

	public String getName() {
		return this.name;
	}

	public int getMaxHp() {
		return this.maxHp;
	}

	public int getHp() {
		return this.hp;
	}

	public int getPower() {
		return this.power;
	}

	public void setMaxHp(int maxHp) {
		this.maxHp = maxHp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	public void setPower(int power) {
		this.power = power;
	}
	
	public abstract void defaultAttack(Unit unit);
	
	public abstract void defaultAttack(UnitPlayer player);
	
	public abstract void skill(Unit unit);

}
