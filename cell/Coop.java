package cell;

public class Coop extends Land {
	// Untuk beternak hewan penghasil telur.
	public Coop(int x, int y) {
		super(x, y);
	}

	public char render() {
		if (hasGrass()) {
			return '#';
		} else {
			return 'o';
		}
	}
}
