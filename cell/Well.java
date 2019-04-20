package cell;

import general.Player;

public class Well extends Facility {
	private static final int COST = 250;

	public Well(int x, int y) {
		super(x, y);
	}

	public static void function(Player o) {
		if (o.getMoney() >= COST) {
			o.setWater(10);
			o.subMoney(COST);
		} else {
			System.out.println("Insufficient money");
			try {
				o.wait(1500);
			} catch (InterruptedException e) {
				System.out.println("I/O Error: " + e);
			}
		}
	}

	public char render() {
		return 'W';
	}
}
