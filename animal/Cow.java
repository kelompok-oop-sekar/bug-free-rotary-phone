package animal;

public class Cow extends MilkProducingFarmAnimal {
	public Cow(int x, int y) {
		super(x, y);
	}

	public char render() {
		if (isHungry()) {
			return 'c';
		} else {
			return 'C';
		}
	}

	public static String voice() {
		return "Mooo.. Mooo..";
	}
}
