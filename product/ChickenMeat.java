package product;

public class ChickenMeat implements FarmProduct {
	public static final String NAME = "ChickenMeat";
	public static final int PRICE = 500;
	@Override
	public String getName() {
		return NAME;
	}
	@Override
	public int getPrice() {
		return PRICE;
	}
}
