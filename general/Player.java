package general;

import java.util.LinkedList;
import java.util.List;

import animal.Chicken;
import animal.Cow;
import animal.FarmAnimal;
import animal.Sheep;
import cell.Land;
import cell.Mixer;
import cell.Truck;
import cell.Well;
import product.BuffaloMeat;
import product.BuffaloMilk;
import product.ChickenEgg;
import product.ChickenMeat;
import product.CowMeat;
import product.CowMilk;
import product.DuckEgg;
import product.DuckMeat;
import product.GoatMeat;
import product.GoatMilk;
import product.Product;
import product.SheepMeat;
import product.SheepMilk;

public class Player extends Renderable {
	private int water;
	private List<Product> bag = new LinkedList<>();
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

	public void emptyBag() {
		bag = new LinkedList<>();
	}

	public void showBag() {
		System.out.println("Bag:");
		for (int i = 0; i < bag.size(); i++) {
			System.out.printf("[%d] %s\n", i, bag.get(i).getName());
		}
		wait(1500);
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

	private void interact(char symbol, FarmAnimal animal) {
		switch (symbol) {
		case 'W':
			Well.function(this);
			break;
		case 'T':
			Truck.function(this);
			break;
		case 'M':
			Mixer.function(this);
			break;
		case 'S':
			if (animal.isProductive()) {
				this.bag.add(new SheepMilk());
				animal.setProductive(false);
			}
			break;
		case 'C':
			if (animal.isProductive()) {
				this.bag.add(new CowMilk());
				animal.setProductive(false);
			}
			break;
		case 'B':
			if (animal.isProductive()) {
				this.bag.add(new BuffaloMilk());
				animal.setProductive(false);
			}
			break;
		case 'G':
			if (animal.isProductive()) {
				this.bag.add(new GoatMilk());
				animal.setProductive(false);
			}
			break;
		case 'H':
			if (animal.isProductive()) {
				this.bag.add(new ChickenEgg());
				animal.setProductive(false);
			}
			break;
		case 'D':
			if (animal.isProductive()) {
				this.bag.add(new DuckEgg());
				animal.setProductive(false);
			}
			break;
		default:
			break;
		}
	}

	public void interact(char[][] grid, String direction, List<FarmAnimal> animals) {
		int x = 0;
		int y = 0;
		switch (direction) {
		case "W":
		case "w":
			if (this.getY() > 0) {
				x = getX();
				y = getY() - 1;
				FarmAnimal victim = null;
				for (FarmAnimal animal : animals) {
					if (animal.getX() == x && animal.getY() == y) {
						victim = animal;
					}
				}
				interact(grid[this.getX()][this.getY() - 1], victim);
			}
			break;
		case "S":
		case "s":
			if (this.getY() < 7) {
				x = getX();
				y = getY() + 1;
				FarmAnimal victim = null;
				for (FarmAnimal animal : animals) {
					if (animal.getX() == x && animal.getY() == y) {
						victim = animal;
					}
				}
				interact(grid[this.getX()][this.getY() + 1], victim);
			}
			break;
		case "D":
		case "d":
			if (this.getX() < 7) {
				x = getX() + 1;
				y = getY();
				FarmAnimal victim = null;
				for (FarmAnimal animal : animals) {
					if (animal.getX() == x && animal.getY() == y) {
						victim = animal;
					}
				}
				interact(grid[this.getX() + 1][this.getY()], victim);
			}
			break;
		case "A":
		case "a":
			if (this.getX() > 0) {
				x = getX() - 1;
				y = getY();
				FarmAnimal victim = null;
				for (FarmAnimal animal : animals) {
					if (animal.getX() == x && animal.getY() == y) {
						victim = animal;
					}
				}
				interact(grid[this.getX() - 1][this.getY()], victim);
			}
			break;
		default:
			break;
		}
	}

	public void kill(char symbol) {
		switch (symbol) {
		case 'S':
			this.bag.add(new SheepMeat());
			break;
		case 'C':
			this.bag.add(new CowMeat());
			break;
		case 'B':
			this.bag.add(new BuffaloMeat());
			break;
		case 'G':
			this.bag.add(new GoatMeat());
			break;
		case 'H':
			this.bag.add(new ChickenMeat());
			break;
		case 'D':
			this.bag.add(new DuckMeat());
			break;
		default:
			break;
		}
	}

	public void kill(char[][] grid, String direction, List<FarmAnimal> animals) {
		int x = 0;
		int y = 0;
		switch (direction) {
		case "W":
		case "w":
			if (this.getY() > 0) {
				x = this.getX();
				y = this.getY() - 1;
				kill(grid[x][y]);
			}
			break;
		case "S":
		case "s":
			if (this.getY() < 7) {
				x = this.getX();
				y = this.getY() + 1;
				kill(grid[this.getX()][this.getY() + 1]);
			}
			break;
		case "D":
		case "d":
			if (this.getX() < 7) {
				x = this.getX() + 1;
				y = this.getY();
				kill(grid[this.getX() + 1][this.getY()]);
			}
			break;
		case "A":
		case "a":
			if (this.getX() > 0) {
				x = this.getX() - 1;
				y = this.getY();
				kill(grid[this.getX() - 1][this.getY()]);
			}
			break;
		default:
			return;
		}
		for (FarmAnimal animal : animals) {
			if (animal.getX() == x && animal.getY() == y) {
				animals.remove(animal);
			}
		}
	}

	public void grow(char[][] grid, List<Land> lands) {
		if (water > 0) {
			for (Land land : lands) {
				if (land.getX() == this.getX() && land.getY() == this.getY()) {
					land.growGrass();
				}
			}
			water--;
		}
	}
}
