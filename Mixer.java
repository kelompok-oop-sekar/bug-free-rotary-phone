import java.util.*;

class Mixer extends Facility {
	void function(Player o) {
		if (o.getBag().size() < 2) {
			System.out.println("Insufficient resources");
			return;
		}
		else {
			List<Product> bag = o.getBag();
		}
	}
}
