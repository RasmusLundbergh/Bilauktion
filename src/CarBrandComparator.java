import java.util.Comparator;

public class CarBrandComparator implements Comparator<Car> {
    public int compare(Car a, Car b) {
        return a.getBrand().compareToIgnoreCase(b.getBrand());
    }
}

