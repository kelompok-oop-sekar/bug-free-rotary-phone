package product;

public class SheepMilk implements FarmProduct {
	private static final int PRICE = 500;
	@Override
	public int getPrice() {
		return PRICE;
	}
	private static final String NAME = "SheepMilk";
	@Override
	public String getName() {
		return NAME;
	}
}
