import java.util.List;

public class BidService {
    private final BidRepository bidRepository;
    private final CarRepository carRepository;

    public BidService(BidRepository bidRepository, CarRepository carRepository) {
        this.bidRepository = bidRepository;
        this.carRepository = carRepository;
    }

    public void placeBid(String bidderName, double amount, String numberPlate)
            throws InvalidBidException {
        if (amount <= 0) {
            throw new InvalidBidException("Beløbet skal være positivt.");
        }

        Car car = carRepository.findByNumberPlate(numberPlate);
        if (car == null) {
            throw new InvalidBidException("Ingen bil med nummerpladen: " + numberPlate);
        }

        Bid bid = new Bid(bidderName, amount, car);
        bidRepository.addBid(bid);
    }

    public List<Bid> getAllBids() {
        return bidRepository.getAllBids();
    }

    public List<Bid> getBidsForCar(Car car) {
        return bidRepository.getBidsForCar(car);
    }
}
