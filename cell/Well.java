package cell;

import general.Player;

public class Well extends Facility {
	private static final int COST = 500;

	public Well(int x, int y) {
		super(x, y);
	}

	public static void function(Player o) {
		if (o.getMoney() >= COST) {
			o.setWater(10);
		} else {
			System.out.println("Insufficient money");
		}
	}

	public char render() {
		return 'W';
	}
}
