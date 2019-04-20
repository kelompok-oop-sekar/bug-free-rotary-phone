package cell;

public abstract class Land extends Cell {
	private boolean grass;

	public Land(int x, int y) {
		super(x, y);
	}

	public void growGrass() {
		grass = true;
	}

	public boolean hasGrass() {
		return grass;
	}

	public boolean isGrowable() {
		return true;
	}
}
