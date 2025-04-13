import java.util.Comparator;

public class BidderNameComparator implements Comparator<Bid> {
    public int compare(Bid a, Bid b) {
        return a.getBidderName().compareToIgnoreCase(b.getBidderName());
    }
}
