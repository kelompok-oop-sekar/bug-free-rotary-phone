abstract class Renderable {
        private int x;
        public int getX() {
                return x;
        }
        public void addX() {
                x++;
        }
        public void subX() {
                x--;
        }

        private int y;
        public int getY() {
                return y;
        }
        public void addY() {
                y++;
        }
        public void subY() {
                y--;
        }

        // Constructor
        public Renderable (int x, int y) {
                this.x = x;
                this.y = y;
        }

        abstract char render();
}
