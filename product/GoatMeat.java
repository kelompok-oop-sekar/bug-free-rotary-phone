package product;

public class GoatMeat implements FarmProduct {
	public static final String NAME = "GoatMeat";
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
