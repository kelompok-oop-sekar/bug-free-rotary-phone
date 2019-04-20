package product;

public class DuckMeat implements FarmProduct {
	public static final String NAME = "DuckMeat";
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
