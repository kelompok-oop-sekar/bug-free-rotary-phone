package animal;

public class Cow extends MilkProducingFarmAnimal {
	public Cow(int x, int y) {
		super(x, y);
	}

	public char render() {
		return 'C';
	}

	public static String voice() {
		return "Mooo.. Mooo..";
	}
}
