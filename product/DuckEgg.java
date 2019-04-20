package product;

public class DuckEgg implements FarmProduct {
	private static final int PRICE = 500;
	public int getPrice() {
		return PRICE;
	}
	private static final String NAME = "DuckEgg";
	@Override
	public String getName() {
		return NAME;
	}
}
