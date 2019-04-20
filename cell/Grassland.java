package cell;

public class Grassland extends Land {
	public Grassland(int x, int y) {
		super(x, y);
	}

	public char render() {
		if (hasGrass()) {
			return '*';
		} else {
			return '-';
		}
	}
}
