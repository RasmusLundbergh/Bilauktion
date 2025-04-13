public class Bid {
    private String bidderName;
    private double amount;
    private Car car;

    public Bid(String bidderName, double amount, Car car) {
        this.bidderName = bidderName;
        this.amount = amount;
        this.car = car;
    }

    public String getBidderName() { return bidderName; }
    public double getAmount() { return amount; }
    public Car getCar() { return car; }

    @Override
    public String toString() {
        return bidderName + " - " + amount + " kr - " + car.getNumberPlate();
    }
}

