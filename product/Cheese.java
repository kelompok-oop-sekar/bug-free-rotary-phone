package product;

public class Cheese implements SideProduct {
	private static final int PRICE = 1500;
	@Override
	public int getPrice() {
		return PRICE;
	}
	private static final String NAME = "Cheese";
	@Override
	public String getName() {
		return NAME;
	}
}
