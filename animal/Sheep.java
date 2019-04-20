package animal;

public class Sheep extends MilkProducingFarmAnimal {
	public Sheep(int x, int y) {
		super(x, y);
	}

	public char render() {
		if (isHungry()) {
			return 's';
		} else {
			return 'S';
		}
	}

	public static String voice() {
		return "Mbiik.. Mbiik..";
	}
}
