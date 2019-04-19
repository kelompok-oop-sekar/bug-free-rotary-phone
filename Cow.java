class Cow extends FarmAnimal implements MeatProducingFarmAnimal, MilkProducingFarmAnimal {
        public Cow(int x, int y) {
                super(x, y);
        }
        public char render() {
                return 'C';
        }
        static String voice() {
                return "Mooo.. Mooo..";
        }
}
