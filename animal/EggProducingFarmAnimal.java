package animal;

import java.util.List;
import java.util.Random;

import cell.Land;
import general.Player;

public abstract class EggProducingFarmAnimal extends FarmAnimal {
	public EggProducingFarmAnimal(int x, int y) {
		super(x, y);
	}

	@Override
	public void move(char[][] grid, List<Land> lands, List<FarmAnimal> animals, Player player) {
		if (isHungry()) {
			eat(grid, lands);
		}
		Random r = new Random();
		int direction = r.nextInt(4);
		int x = getX();
		int y = getY();
		switch (direction) {
		case 0:
			if (y > 0) {
				if (!isOccupied(x, y - 1, animals, player)) {
					switch (grid[x][y - 1]) {
					case 'o':
					case '#':
						this.subY();
						subStamina();
						break;
					default:
						break;
					}
				}
			}
			break;
		case 1:
			if (y < 7) {
				if (!isOccupied(x, y + 1, animals, player)) {
					switch (grid[x][y + 1]) {
					case 'o':
					case '#':
						this.addY();
						subStamina();
						break;
					default:
						break;
					}
				}
			}
			break;
		case 2:
			if (x > 0) {
				if (!isOccupied(x - 1, y, animals, player)) {
					switch (grid[x - 1][y]) {
					case 'o':
					case '#':
						this.subX();
						subStamina();
						break;
					default:
						break;
					}
				}
			}
			break;
		case 3:
			if (x < 7) {
				if (!isOccupied(x + 1, y, animals, player)) {
					switch (grid[x + 1][y]) {
					case 'o':
					case '#':
						this.addX();
						subStamina();
						break;
					default:
						break;
					}
				}
			}
			break;
		default:
			break;
		}
	}
}
