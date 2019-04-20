package product;

public class BuffaloMilk implements FarmProduct {
	
	private static final int PRICE = 500;
	@Override
	public int getPrice() {
		return PRICE;
	}
	private static final String NAME = "BuffaloMilk";
	@Override
	public String getName() {
		return NAME;
	}
}
