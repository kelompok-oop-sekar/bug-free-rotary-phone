abstract class Facility extends Cell {
        public Facility(int x, int y) {
                super(x, y);
        }
        public boolean isGrowable() {
                return false;
        }
}
