package animal;

import java.util.List;

import cell.Land;
import general.Renderable;

public abstract class FarmAnimal extends Renderable {
	public static final int FULL = 10;
	public static final int HUNGRY = 5;
	public static final int DIE = 0;
	private int stamina = 10;
	private boolean productive = true;

	public FarmAnimal(int x, int y) {
		super(x, y);
	}

	public int getStamina() {
		return stamina;
	}

	public void setStamina(int stamina) {
		this.stamina = stamina;
	}

	public void subStamina() {
		stamina--;
	}

	public abstract void move(char[][] grid, List<Land> lands);

	public boolean isDead() {
		return (stamina == DIE);
	}

	public boolean isHungry() {
		return (stamina <= HUNGRY);
	}
	public boolean isProductive() {
		return productive;
	}
	public void setProductive(boolean productive) {
		this.productive = productive;
	}

	public void eat(char[][] grid, List<Land> lands) {
		for (Land land : lands) {
			if (land.getX() == this.getX() && land.getY() == this.getY()) {
				if (land.hasGrass()) {
					land.removeGrass();
					setStamina(FULL);
					setProductive(true);
				}
			}
		}
	}
}
