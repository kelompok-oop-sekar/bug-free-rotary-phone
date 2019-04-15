class Well extends Facility {
	void function(Player o) {
		int cost = 500;
		if (o.getMoney() >= 500) {
			o.setWater(10);
		}
		else {
			System.out.println("Insufficient money");
		}
	}
}
