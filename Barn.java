class Barn extends Land {
	// Untuk beternak hewan penghasil daging.
	char render() {
		if (hasGrass()) {
			return '@';
		}
		else {
			return 'x';
		}
	}
}
