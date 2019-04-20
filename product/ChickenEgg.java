package product;

public class ChickenEgg implements FarmProduct {
	private static final int PRICE = 500;
	public int getPrice() {
		return PRICE;
	}
	private static final String NAME = "ChickenEgg";
	@Override
	public String getName() {
		return NAME;
	}
}
