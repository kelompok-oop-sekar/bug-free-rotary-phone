package cell;

import java.util.*;

import general.Player;
import product.Product;

public class Truck extends Facility {
	public Truck(int x, int y) {
		super(x, y);
	}

	public static void function(Player o) {
		List<Product> bag = o.getBag();
	}

	public char render() {
		return 'T';
	}
}
