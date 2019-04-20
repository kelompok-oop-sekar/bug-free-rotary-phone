package general;

import java.util.*;

import animal.Chicken;
import animal.Cow;
import animal.Sheep;
import cell.Well;
import product.BuffaloMilk;
import product.ChickenEgg;
import product.CowMilk;
import product.DuckEgg;
import product.GoatMilk;
import product.Product;
import product.SheepMilk;

public class Player extends Renderable {
	private int water;
	private List<Product> bag;
	private int money;

	public Player(int x, int y) {
		super(x, y);
	}

	public int getMoney() {
		return money;
	}

	public void addMoney(int profit) {
		money += profit;
	}

	public void subMoney(int cost) {
		money -= cost;
	}

	public int getWater() {
		return water;
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

	public void move(char[][] grid, String direction) {
		switch (direction) {
		case "W":
		case "w":
			if (this.getY() > 0) {
				switch (grid[this.getX()][this.getY() - 1]) {
				case '-':
				case 'x':
				case 'o':
				case '*':
				case '@':
				case '#':
					this.subY();
					break;
				default:
					break;
				}
			}
			break;
		case "S":
		case "s":
			if (this.getY() < 7) {
				switch (grid[this.getX()][this.getY() + 1]) {
				case '-':
				case 'x':
				case 'o':
				case '*':
				case '@':
				case '#':
					this.addY();
					break;
				default:
					break;
				}
			}
			break;
		case "D":
		case "d":
			if (this.getX() < 7) {
				switch (grid[this.getX() + 1][this.getY()]) {
				case '-':
				case 'x':
				case 'o':
				case '*':
				case '@':
				case '#':
					this.addX();
					break;
				default:
					break;
				}
			}
			break;
		case "A":
		case "a":
			if (this.getX() > 0) {
				switch (grid[this.getX() - 1][this.getY()]) {
				case '-':
				case 'x':
				case 'o':
				case '*':
				case '@':
				case '#':
					this.subX();
					break;
				default:
					break;
				}
			}
			break;
		default:
			break;
		}
	}

	private void wait(int t) {
		try {
			Thread.sleep(t);
		} catch (InterruptedException e) {
			System.out.println("Error: " + e);
		}
	}

	private void talk(char symbol) {
		switch (symbol) {
		case 'C':
		case 'c':
			System.out.println(Cow.voice());
			wait(1500);
			break;
		case 'H':
		case 'h':
			System.out.println(Chicken.voice());
			wait(1500);
			break;
		case 'S':
		case 's':
			System.out.println(Sheep.voice());
			wait(1500);
			break;
		default:
			break;
		}
	}

	public void talk(char[][] grid, String direction) {
		switch (direction) {
		case "W":
		case "w":
			if (this.getY() > 0) {
				talk(grid[this.getX()][this.getY() - 1]);
			}
			break;
		case "S":
		case "s":
			if (this.getY() < 7) {
				talk(grid[this.getX()][this.getY() + 1]);
			}
			break;
		case "D":
		case "d":
			if (this.getX() < 7) {
				talk(grid[this.getX() + 1][this.getY()]);
			}
			break;
		case "A":
		case "a":
			if (this.getX() > 0) {
				talk(grid[this.getX() - 1][this.getY()]);
			}
			break;
		default:
			break;
		}
	}

	public void interact(char symbol) {
		switch (symbol) {
		case 'W':
			Well.function(this);
			break;
		case 'T':
			// Truck.function(this);
			break;
		case 'M':
			// Mixer.function(this);
			break;
		case 'S':
			this.bag.add(new SheepMilk());
			break;
		case 'C':
			this.bag.add(new CowMilk());
			break;
		case 'B':
			this.bag.add(new BuffaloMilk());
			break;
		case 'G':
			this.bag.add(new GoatMilk());
			break;
		case 'H':
			this.bag.add(new ChickenEgg());
			break;
		case 'D':
			this.bag.add(new DuckEgg());
			break;
		default:
			break;
		}
	}

	public void interact(char[][] grid, String direction) {
		switch (direction) {
		case "W":
		case "w":
			if (this.getY() > 0) {
				interact(grid[this.getX()][this.getY() - 1]);
			}
			break;
		case "S":
		case "s":
			if (this.getY() < 7) {
				interact(grid[this.getX()][this.getY() + 1]);
			}
			break;
		case "D":
		case "d":
			if (this.getX() < 7) {
				interact(grid[this.getX() + 1][this.getY()]);
			}
			break;
		case "A":
		case "a":
			if (this.getX() > 0) {
				interact(grid[this.getX() - 1][this.getY()]);
			}
			break;
		default:
			break;
		}
	}
}
