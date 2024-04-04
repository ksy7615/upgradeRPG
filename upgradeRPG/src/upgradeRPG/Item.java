package upgradeRPG;

public class Item {
	public static final int WEAPON = 1;
	public static final int ARMOR = 2;
	public static final int RING = 3;
	
	public int kind; // 종류
	public String name; // 템명
	public int effect; // 효과
	public int price; // 가격
	
	public Item(int kind, String name, int effect, int price) {
		this.kind = kind;
		this.name = name;
		this.effect = effect;
		this.price = price;
	}
}
