class Well extends Facility {
        public Well(int x, int y) {
                super(x, y);
        }
        static void function(Player o) {
                int cost = 500;
                if (o.getMoney() >= 500) {
                        o.setWater(10);
                }
                else {
                        System.out.println("Insufficient money");
                }
        }
        public char render() {
                return 'W';
        }
}
