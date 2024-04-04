package upgradeRPG;

public class PlayerWarrior extends UnitPlayer {

	public PlayerWarrior() {
		// 이름 레벨 체력 마나 공격력 방어력 경험치
		super("전사", 1, 500, 100, 30, 30, 0);
	}

	@Override
	public void defaultAttack(UnitMonster monster) {
		// TODO Auto-generated method stub

	}

	@Override
	public void skill(UnitMonster monster) {
		// TODO Auto-generated method stub

	}

}
