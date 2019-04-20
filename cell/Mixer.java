package cell;

import java.util.*;

import general.Player;
import product.Product;

public class Mixer extends Facility {
	public Mixer(int x, int y) {
		super(x, y);
	}

	public static void function(Player o) {
		if (o.getBag().size() < 2) {
			System.out.println("Insufficient resources");
			return;
		} else {
			List<Product> bag = o.getBag();
		}
	}

	public char render() {
		return 'M';
	}
}
