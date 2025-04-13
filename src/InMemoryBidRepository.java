import java.util.*;

public class InMemoryBidRepository implements BidRepository {
    private List<Bid> bids = new ArrayList<>();

    @Override
    public void addBid(Bid bid) {
        bids.add(bid);
    }

    @Override
    public List<Bid> getAllBids() {
        return new ArrayList<>(bids);
    }

    @Override
    public List<Bid> getBidsForCar(Car car) {
        List<Bid> result = new ArrayList<>();
        for (Bid bid : bids) {
            if (bid.getCar().getNumberPlate().equals(car.getNumberPlate())) {
                result.add(bid);
            }
        }
        return result;
    }
}
