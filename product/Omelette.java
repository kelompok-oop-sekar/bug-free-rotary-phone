package product;

public class Omelette implements SideProduct {
	private static final int PRICE = 1500;

	@Override
	public int getPrice() {
		return PRICE;
	}
	private static final String NAME = "Omelette";
	@Override
	public String getName() {
		return NAME;
	}
}
