package product;

public class SheepMeat implements FarmProduct {
	public static final String NAME = "SheepMeat";
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
