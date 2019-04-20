package cell;

import java.util.*;

import general.Player;
import product.Product;
import product.Cheese;
import product.FarmProduct;
import product.Omelette;
import product.SideProduct;
import product.XxnormalChicken;

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
			List<FarmProduct> raw = new LinkedList<>();
			for (Product product : bag) {
				if (product instanceof FarmProduct) {
					raw.add((FarmProduct) product);
				}
			}
			for (int i = 0; i < raw.size(); i++) {
				System.out.printf("[%d] %s\n", i, raw.get(i).getName());
			}
			System.out.println("Choose ingridients");
			Scanner scanner = new Scanner(System.in);
			int[] choice = new int[2];
			for (int i = 0; i < 2; i++) {
				choice[i] = scanner.nextInt();
			}
			FarmProduct use1 = raw.get(choice[0]);
			FarmProduct use2 = raw.get(choice[1]);
			SideProduct sp = mix(use1.getName(), use2.getName());
			if (sp != null) {
				bag.remove(use1);
				bag.remove(use2);
				bag.add(sp);
			}
		}
	}
	private static SideProduct mix(String s1, String s2) {
		if (s1.equals("CowMilk") && s2.equals("CowMilk")) {
			return new Cheese();
		}
		else if (s1.equals("ChickenEgg") && s2.equals("ChickenEgg")) {
			return new Omelette();
		}
		else if (s1.equals("ChickenMeat") && s2.equals("ChickenEgg")) {
			return new XxnormalChicken();
		}
		else {
			return null;
		}
	}

	public char render() {
		return 'M';
	}
}
