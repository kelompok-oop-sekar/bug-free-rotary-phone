package animal;

public class Chicken extends FarmAnimal implements MeatProducingFarmAnimal, EggProducingFarmAnimal {
	public Chicken(int x, int y) {
		super(x, y);
	}

	public char render() {
		return 'H';
	}

	public static String voice() {
		return "Petok.. Petok..";
	}
}
