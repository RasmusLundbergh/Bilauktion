public class Car implements Comparable<Car> {
    private String brand;
    private String model;
    private int year;
    private double basePrice;
    private String numberPlate;

    public Car(String brand, String model, int year, double basePrice,String numberPlate) {
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.basePrice = basePrice;
        this.numberPlate = numberPlate;
    }

    public String getBrand() { return brand; }
    public String getModel() { return model; }
    public int getYear() { return year; }
    public double getBasePrice() { return basePrice; }
    public String getNumberPlate() { return numberPlate; }

    @Override
    public int compareTo(Car other) {
        return Integer.compare(other.year, this.year); // Nyeste først
    }

    @Override
    public String toString() {
        return numberPlate + " - " + brand + " " + model + " (" + year + ") - " + basePrice + " kr";
    }
}
