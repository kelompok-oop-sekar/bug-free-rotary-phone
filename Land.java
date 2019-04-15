class Land implements Cell {
	private boolean grass;
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
