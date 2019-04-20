package animal;

import java.util.Random;

public abstract class EggProducingFarmAnimal extends FarmAnimal {
	public EggProducingFarmAnimal(int x, int y) {
		super(x, y);
	}

	@Override
	public void move(char[][] grid) {
		Random r = new Random();
		int direction = r.nextInt(4);
		int x = getX();
		int y = getY();
		switch (direction) {
		case 0:
			if (y > 0) {
				switch (grid[x][y - 1]) {
				case 'o':
				case '#':
					this.subY();
					break;
				default:
					break;
				}
			}
			break;
		case 1:
			if (y < 7) {
				switch (grid[x][y + 1]) {
				case 'o':
				case '#':
					this.addY();
					break;
				default:
					break;
				}
			}
			break;
		case 2:
			if (x > 0) {
				switch (grid[x - 1][y]) {
				case 'o':
				case '#':
					this.subX();
					break;
				default:
					break;
				}
			}
			break;
		case 3:
			if (x < 7) {
				switch (grid[x + 1][y]) {
				case 'o':
				case '#':
					this.addX();
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
}
