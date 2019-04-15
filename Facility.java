abstract class Facility implements Cell {
	public boolean isGrowable() {
		return false;
	}
	abstract void function(Player o);
}
