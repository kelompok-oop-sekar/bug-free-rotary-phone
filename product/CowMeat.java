package product;

public class CowMeat implements FarmProduct {
	public static final String NAME = "CowMeat";
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
