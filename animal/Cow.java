package animal;

public class Cow extends FarmAnimal implements MeatProducingFarmAnimal, MilkProducingFarmAnimal {
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
