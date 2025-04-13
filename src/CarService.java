import java.util.List;

public class CarService {
    private final CarRepository carRepository;

    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public void addCar(Car car) {
        carRepository.addCar(car);
    }

    public List<Car> getAllCars() {
        return carRepository.getAllCars();
    }

    public Car findByNumberPlate(String numberPlate) {
        return carRepository.findByNumberPlate(numberPlate);
    }
}
