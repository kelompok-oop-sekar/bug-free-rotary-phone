package product;

public class CowMilk implements FarmProduct {
	private static final int PRICE = 500;
	public int getPrice() {
		return PRICE;
	}
	private static final String NAME = "CowMilk";
	@Override
	public String getName() {
		return NAME;
	}
}
