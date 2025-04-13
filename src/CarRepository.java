import java.util.List;

public interface CarRepository {
    void addCar(Car car);
    List<Car> getAllCars();
    Car findByNumberPlate(String numberPlate);
}
