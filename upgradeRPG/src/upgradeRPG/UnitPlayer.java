package upgradeRPG;

public abstract class UnitPlayer extends Unit {

	public UnitPlayer(String name, int level, int hp, int mp, int power, int defence, int exp) {
		super(name, level, hp, mp, power, defence, exp);
	}
	
	public abstract void defaultAttack(UnitMonster monster);
	
	public abstract void skill(UnitMonster monster);

}
