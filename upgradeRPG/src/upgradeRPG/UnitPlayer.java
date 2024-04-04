package upgradeRPG;

public abstract class UnitPlayer extends Unit {
	public static int money;
	public static Inventory inven = new Inventory();
	public static Guild guild = new Guild();

	public UnitPlayer(String name, int level, int hp, int mp, int power, int defence, int exp) {
		super(name, level, hp, mp, power, defence, exp);
	}
	
	public UnitPlayer(String name, int level, int hp, int mp, int power, int defence, int exp, boolean party) {
		super(name, level, hp, mp, power, defence, exp, false);
	}
	
	public abstract void defaultAttack(UnitMonster monster);
	
	public abstract void skill(UnitMonster monster);

}
