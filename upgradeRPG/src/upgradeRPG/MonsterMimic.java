package upgradeRPG;

public class MonsterMimic extends UnitMonster {

	public MonsterMimic() {
		super("미믹", 650, 50);
	}

	// 확률로 오버로딩 생성자 호출하고 템 + 돈 + 경험치 드랍하기
	public MonsterMimic(String name) {
		super(name, 1, 0);
	}

	@Override
	public void defaultAttack(UnitPlayer player) {
		// TODO Auto-generated method stub

	}

	@Override
	public void skill(UnitPlayer player) {
		// TODO Auto-generated method stub

	}

}
