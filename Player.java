import java.util.*;

class Player implements Renderable {
	private int water;
	private List<Product> bag;
	private int money;
	public int getMoney() {
		return money;
	}
	public void addMoney(int profit) {
		money += profit;
	}
	public void reduceMoney(int cost) {
		money -= cost;
	}
	public void setWater(int water) {
		this.water = water;
	}
	public List<Product> getBag() {
		return bag;
	}
	public char render() {
		return 'P';
	}
}
