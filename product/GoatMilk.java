package product;

public class GoatMilk implements FarmProduct {
	private static final int PRICE = 500;
	public int getPrice() {
		return PRICE;
	}
	private static final String NAME = "GoatMilk";
	@Override
	public String getName() {
		return NAME;
	}
}
