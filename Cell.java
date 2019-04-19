abstract class Cell extends Renderable {
        public Cell(int x, int y) {
                super(x, y);
        }
        abstract boolean isGrowable();
}
