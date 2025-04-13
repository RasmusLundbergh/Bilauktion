import java.util.Comparator;

public class CarPriceComparator implements Comparator<Car> {
    public int compare(Car a, Car b) {
        return Double.compare(a.getBasePrice(), b.getBasePrice());
    }
}
