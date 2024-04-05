package upgradeRPG;

public class UnitMonster extends Unit {

	public UnitMonster(String name, int hp, int power) {
		super(name, hp, power);
	}

	@Override
	public void defaultAttack(Unit player) {
		// 플레이어용이라 공백
	}

	@Override
	public void skill(Unit unit) {
		// 스킬 각자 다르게 부여
	}

	@Override
	public void defaultAttack(UnitPlayer player) {
		System.out.println(String.format("[%s]의 공격\n", this.getName()));

		int hit = this.getPower() - player.getDefence() / 5;

		if (hit <= 0) {
			hit = 0;
			System.out.println("MISS");
			return;
		}
		
		player.setHp(player.getHp() - hit);

		if (player.getHp() <= 0) {
			player.setHp(0);
		}
	}

}
