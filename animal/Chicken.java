package animal;

public class Chicken extends EggProducingFarmAnimal {
	public Chicken(int x, int y) {
		super(x, y);
	}

	public char render() {
		if (isHungry()) {
			return 'h';
		} else {
			return 'H';
		}
	}

	public static String voice() {
		return "Petok.. Petok..";
	}
}
