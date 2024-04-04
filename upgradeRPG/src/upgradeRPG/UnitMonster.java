package upgradeRPG;

public abstract class UnitMonster extends Unit {

	public UnitMonster(String name, int hp, int power) {
		super(name, hp, power);
	}
	
	public abstract void defaultAttack(UnitPlayer player);
	
	public abstract void skill(UnitPlayer player);

}
