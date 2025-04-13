import java.util.List;

public interface BidRepository {
    void addBid(Bid bid);
    List<Bid> getAllBids();
    List<Bid> getBidsForCar(Car car);
}
