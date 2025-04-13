public class CarBiddingApp {
    public static void main(String[] args) {
        // Opret repositories
        CarRepository carRepo = new InMemoryCarRepository();
        BidRepository bidRepo = new InMemoryBidRepository();

        // Opret services
        CarService carService = new CarService(carRepo);
        BidService bidService = new BidService(bidRepo, carRepo);

        // Opret controller og start programmet
        CarAuctionController controller = new CarAuctionController(carService, bidService);
        controller.start();
    }
}

