package product;

public class XxnormalChicken implements SideProduct {
	private static final int PRICE = 1500;

	@Override
	public int getPrice() {
		return PRICE;
	}
	private static final String NAME = "XxnormalChicken";
	@Override
	public String getName() {
		return NAME;
	}
}
