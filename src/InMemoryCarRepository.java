import java.util.*;

public class InMemoryCarRepository implements CarRepository {
    private Map<String, Car> cars = new HashMap<>();

    @Override
    public void addCar(Car car) {
        cars.put(car.getNumberPlate(), car);
    }

    @Override
    public List<Car> getAllCars() {
        return new ArrayList<>(cars.values());
    }

    @Override
    public Car findByNumberPlate(String numberPlate) {
        return cars.get(numberPlate);
    }
}
