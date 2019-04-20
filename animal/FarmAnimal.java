package animal;

import general.Renderable;

public abstract class FarmAnimal extends Renderable {
	public FarmAnimal(int x, int y) {
		super(x, y);
	}

	public abstract void move(char[][] grid);
}
