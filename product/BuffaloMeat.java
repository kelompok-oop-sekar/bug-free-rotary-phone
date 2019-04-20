package product;

public class BuffaloMeat implements FarmProduct {
	public static final String NAME = "BuffaloMeat";
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
