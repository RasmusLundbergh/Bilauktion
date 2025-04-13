import java.util.Comparator;

public class BidCarComparator implements Comparator<Bid> {
    public int compare(Bid a, Bid b) {
        int brandCompare = a.getCar().getBrand().compareToIgnoreCase(b.getCar().getBrand());
        if (brandCompare != 0) return brandCompare;
        return a.getCar().getModel().compareToIgnoreCase(b.getCar().getModel());
    }
}
