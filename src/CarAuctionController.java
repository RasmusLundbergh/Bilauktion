import java.util.List;
import java.util.Scanner;


public class CarAuctionController {
    private final CarService carService;
    private final BidService bidService;
    private final Scanner scanner = new Scanner(System.in);

    public CarAuctionController(CarService carService, BidService bidService) {
        this.carService = carService;
        this.bidService = bidService;
    }

    public void start() {
        Car car1 = new Car("Toyota", "Corolla", 2018, 135000.0, "AB12345");
        Car car2 = new Car("Volkswagen", "Golf", 2020, 165000.0, "CD67890");
        Car car3 = new Car("Ford", "Focus", 2017, 125000.0, "EF24680");


        carService.addCar(car1);
        carService.addCar(car2);
        carService.addCar(car3);

        try {
            bidService.placeBid("Anna Jensen", 140000, "AB12345");
            bidService.placeBid("Bo Hansen", 170000, "CD67890");
            bidService.placeBid("Clara Madsen", 175000, "CD67890");
            bidService.placeBid("David Holm", 130000, "EF24680");
            bidService.placeBid("Eva Sørensen", 145000, "AB12345");
        } catch (InvalidBidException e) {
            System.out.println("Fejl ved oprettelse af bud: " + e.getMessage());
        }

        System.out.println("Bilauktion startet!");

        boolean running = true;
        while (running) {
            System.out.println("\nVælg en mulighed:");
            System.out.println("1. Vis alle biler");
            System.out.println("2. Afgiv bud");
            System.out.println("3. Vis bud på en bil");
            System.out.println("4. Afslut");

            String valg = scanner.nextLine();

            switch (valg) {
                case "1" -> visBiler();
                case "2" -> afgivBud();
                case "3" -> visBud();
                case "4" -> running = false;
                default -> System.out.println("Ugyldigt valg.");
            }
        }

        System.out.println("Farvel 👋");
    }

    private void visBiler() {
        List<Car> biler = carService.getAllCars();
        if (biler.isEmpty()) {
            System.out.println("Ingen biler tilgængelige.");
            return;
        }

        System.out.println("\n📋 Tilgængelige biler:");
        for (Car car : biler) {
            System.out.println(car);
        }
    }

    private void afgivBud() {
        try {
            System.out.print("Indtast dit navn: ");
            String navn = scanner.nextLine();

            System.out.print("Indtast nummerplade på bilen: ");
            String nrPlade = scanner.nextLine();

            System.out.print("Indtast dit bud i kr: ");
            double beløb = Double.parseDouble(scanner.nextLine());

            bidService.placeBid(navn, beløb, nrPlade);
            System.out.println("✅ Bud afgivet!");
        } catch (InvalidBidException e) {
            System.out.println("❌ Fejl: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("❌ Ugyldigt beløb.");
        }
    }

    private void visBud() {
        System.out.print("Indtast nummerplade på bilen: ");
        String nrPlade = scanner.nextLine();

        Car bil = carService.findByNumberPlate(nrPlade);
        if (bil == null) {
            System.out.println("❌ Bil ikke fundet.");
            return;
        }

        List<Bid> bud = bidService.getBidsForCar(bil);
        if (bud.isEmpty()) {
            System.out.println("Ingen bud på denne bil.");
            return;
        }

        System.out.println("🔨 Bud på " + bil.getBrand() + " " + bil.getModel() + ":");
        for (Bid b : bud) {
            System.out.println(b);
        }
    }
}

