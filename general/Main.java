package general;

import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import animal.Chicken;
import animal.Cow;
import animal.FarmAnimal;
import animal.Sheep;
import cell.Barn;
import cell.Coop;
import cell.Facility;
import cell.Grassland;
import cell.Land;
import cell.Mixer;
import cell.Truck;
import cell.Well;

class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		List<FarmAnimal> farmAnimals = new LinkedList<>();
		List<Facility> facilities = new LinkedList<>();
		List<Land> lands = new LinkedList<>();
		grid = new char[8][8];

		for (int j = 1; j < grid[0].length; j++) {
			for (int i = 0; i < 3; i++) {
				Grassland g = new Grassland(i, j);
				g.growGrass();
				lands.add(g);
			}
		}
		for (int j = 0; j < grid[0].length; j++) {
			for (int i = 3; i < 6; i++) {
				Barn b = new Barn(i, j);
				b.growGrass();
				lands.add(b);
			}
		}
		for (int j = 0; j < grid[0].length; j++) {
			for (int i = 6; i < grid.length; i++) {
				Coop c = new Coop(i, j);
				c.growGrass();
				lands.add(c);
			}
		}
		facilities.add(new Well(0, 0));
		facilities.add(new Truck(1, 0));
		facilities.add(new Mixer(2, 0));
		farmAnimals.add(new Chicken(6, 0));
		farmAnimals.add(new Cow(3, 0));
		farmAnimals.add(new Sheep(3, 1));
		player.addMoney(2500);
		player.setWater(10);

		while (farmAnimals.size() > 0) {
			for (Land l : lands) {
				grid[l.getX()][l.getY()] = l.render();
			}

			for (Facility f : facilities) {
				grid[f.getX()][f.getY()] = f.render();
			}

			for (FarmAnimal fa : farmAnimals) {
				grid[fa.getX()][fa.getY()] = fa.render();
			}

			grid[player.getX()][player.getY()] = player.render();
			showMap(grid);
			showCommand();
			String command = scanner.next();
			String direction;

			switch (command) {
			case "M":
			case "m":
				showMap(grid);
				showDirection();
				direction = scanner.next();
				player.move(grid, direction);
				break;
			case "T":
			case "t":
				showMap(grid);
				showDirection();
				direction = scanner.next();
				showMap(grid);
				player.talk(grid, direction);
				break;
			case "I":
			case "i":
				showMap(grid);
				showDirection();
				direction = scanner.next();
				player.interact(grid, direction, farmAnimals);
				break;
			case "B":
			case "b":
				showMap(grid);
				player.showBag();
				break;
			case "K":
			case "k":
				showMap(grid);
				showDirection();
				direction = scanner.next();
				player.kill(grid, direction, farmAnimals);
				break;
			case "G":
			case "g":
				player.grow(grid, lands);
				break;
			default:
				break;
			}
			moveAll(farmAnimals, lands, player);
			checkHealth(farmAnimals);
		}
		scanner.close();
	}

	private static Player player = new Player(1, 1);
	private static char[][] grid;
	private static final ProcessBuilder pb = new ProcessBuilder("clear");
	private static final List<String> information = List.of("+-----------------+", "| Information:    |",
			"|                 |", "| C: Cow          |", "| S: Sheep        |", "| H: Chicken      |",
			"|                 |", "| W: Well         |", "| T: Truck        |", "| M: Mixer        |",
			"|                 |", "| P: Player       |", "|                 |", "| -, *: Grassland |",
			"| x, @: Barn      |", "| o, #: Coop      |", "+-----------------+");

	private static void showMap(char[][] grid) {
		clear();
		Iterator<String> it = information.iterator();
		String gap = "   ";

		showStatus();
		System.out.print("+---+---+---+---+---+---+---+---+");
		System.out.print(gap);
		System.out.println(it.next());
		for (int j = 0; j < grid[0].length; j++) {
			for (int i = 0; i < grid.length; i++) {
				System.out.printf("| %c ", grid[i][j]);
			}
			System.out.print("|");
			System.out.print(gap);
			System.out.println(it.next());
			System.out.print("+---+---+---+---+---+---+---+---+");
			System.out.print(gap);
			System.out.println(it.next());
		}
	}

	private static void showCommand() {
		System.out.println("Command:\n[M]ove\n[T]alk\n[I]nteract\n[B]ag\n[K]ill\n[G]row");
	}

	private static void showDirection() {
		System.out.println("Direction:\n[w]Up\n[s]Down\n[d]Right\n[a]Left");
	}

	private static void showStatus() {
		System.out.printf("Money: %7d\n", player.getMoney());
		System.out.printf("Water: %7d\n", player.getWater());
	}

	private static void clear() {
		try {
			pb.inheritIO().start().waitFor();
		} catch (IOException ioe) {
			System.out.println("I/O Error: " + ioe);
		} catch (InterruptedException ie) {
			System.out.println("Interrupted: " + ie);
		}
	}
	private static void checkHealth(List<FarmAnimal> animals) {
		for (FarmAnimal animal : animals) {
			if (animal.isDead()) {
				animals.remove(animal);
			}
		}
	}
	private static void moveAll(List<FarmAnimal> animals, List<Land> lands, Player player) {
		for (FarmAnimal animal : animals) {
			animal.move(grid, lands, animals, player);
		}
	}
}
