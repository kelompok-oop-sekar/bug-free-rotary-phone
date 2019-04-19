import java.util.*;
class Mixer extends Facility {
        public Mixer(int x, int y) {
                super(x, y);
        }
        static void function(Player o) {
                if (o.getBag().size() < 2) {
                        System.out.println("Insufficient resources");
                        return;
                }
                else {
                        List<Product> bag = o.getBag();
                }
        }
        public char render() {
                return 'M';
        }
}
