import java.util.*;
class Truck extends Facility {
        public Truck(int x, int y) {
                super(x, y);
        }
        static void function(Player o) {
                List<Product> bag = o.getBag();
        }
        public char render() {
                return 'T';
        }
}

