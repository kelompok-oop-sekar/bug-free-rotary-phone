class Grassland extends Land {
	// Untuk beternak hewan penghasil susu.
	char render() {
		if (hasGrass()) {
			return '*';
		}
		else {
			return '-';
		}
	}
}
