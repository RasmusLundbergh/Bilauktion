import java.util.Comparator;

public class BidAmountComparator implements Comparator<Bid> {
    public int compare(Bid a, Bid b) {
        return Double.compare(b.getAmount(), a.getAmount());
    }
}
