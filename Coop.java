class Coop extends Land {
	char render() {
		if (hasGrass()) {
			return '#';
		}
		else {
			return 'o';
		}
	}
}
