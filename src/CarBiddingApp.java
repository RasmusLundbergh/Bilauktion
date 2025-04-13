public class CarBiddingApp {
    public static void main(String[] args) {

        CarRepository carRepo = new InMemoryCarRepository();
        BidRepository bidRepo = new InMemoryBidRepository();

        CarService carService = new CarService(carRepo);
        BidService bidService = new BidService(bidRepo, carRepo);

        CarAuctionController controller = new CarAuctionController(carService, bidService);
        controller.start();
    }
}

