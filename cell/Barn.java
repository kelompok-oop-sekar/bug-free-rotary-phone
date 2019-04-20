package cell;

public class Barn extends Land {
	public Barn(int x, int y) {
		super(x, y);
	}

	public char render() {
		if (hasGrass()) {
			return '@';
		} else {
			return 'x';
		}
	}
}
