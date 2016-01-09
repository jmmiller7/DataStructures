package auction;

public class Bidder {
	String name;
	int highBid;

	public Bidder(String name, int highBid) {
		this.name = name;
		this.highBid = highBid;
	}

	public String toString() {
		return name + "\t\t" + highBid + "\n";
	}
}
