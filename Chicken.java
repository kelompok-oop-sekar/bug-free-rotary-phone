class Chicken extends FarmAnimal implements MeatProducingFarmAnimal, EggProducingFarmAnimal {
        public Chicken(int x, int y) {
                super(x, y);
        }
        public char render() {
                return 'H';
        }
        static String voice() {
                return "Petok.. Petok..";
        }
}
