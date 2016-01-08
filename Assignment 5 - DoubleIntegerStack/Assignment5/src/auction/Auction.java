package auction;
import java.util.*;

public class Auction 
{
	public static void main(String[] args)
	{
		@SuppressWarnings("resource")
		Scanner keyboard = new Scanner(System.in);
		
		LinkedStack<Bidder> bids = new LinkedStack<Bidder>();
				
		// CONSTANTS that declare result of a bid
		final String RES1 = "New High Bidder";
		final String RES2 = "High Bid Inc.";
		final String RES3 = "No Change";
		
		// Keep track of max bid, current bid and the highest bidder
		int maxBid = 0;
		int currBid = 0;
		String highBidder = "";
		
		String selection = "";		//Holds the result of a bid
		
		String status = "";			//Holds the auctions overall status
		
		boolean cont = false;		
		
		
		// ------------- Welcome Message -------------
		System.out.println("* * *Welcome to the Auction!* * *");
		
		
		// ------------- Simulate the Auction -------------
		do
		{
			String name = "";
			int bid = 0;
			String result = "";
			
			System.out.println("\n-----------------------------------------");
			System.out.print("Please enter bidder's name: ");
			name = keyboard.nextLine();
			System.out.print("Enter a bid: ");
			bid = keyboard.nextInt();
			
			//If new bid is higher the current high bidder
			if(bid > maxBid)
			{			
				currBid = maxBid+1;
				highBidder = name;
				
				Bidder bidder = new Bidder(name,currBid);
				bids.push(bidder);
				
				result = RES1;
				maxBid = bid;			
			}
			// If bid is less than max bid, but higher than current bid
			else if(bid > currBid)
			{	
				currBid = bid;
				Bidder bidder = new Bidder(highBidder,currBid);
				bids.push(bidder);
				result = RES2;
			}
			// New bid is less than max bid and current bid
			else
				result = RES3;
			
			//Print the status
			System.out.println("\nNew Bid\t\tResult\t\t\tHigh Bidder\tHigh Bid\t" + 
								"Maximum Bid");
			status += bid + " " + name + "\t\t" + result + "\t\t" + highBidder + 
							"\t\t" + currBid + "\t\t" + maxBid + "\n";
			System.out.println(status);
			
			// Place another bid?
			System.out.print("Enter a new bidder(y/n)? ");
			selection = keyboard.next();
						
			cont = false;
			if(selection.equalsIgnoreCase("Y"))
				cont = true;
			
			selection = keyboard.nextLine();
				
		}while(cont);
		
		
		// --------------- Display Results ---------------
		System.out.println("\n***The Auction is Over. Here are the results." +
							"The winner is on top.");
		System.out.println("\nBidder\tBid");
		System.out.println(bids);
		
		
		// ---------------- Termination ------------------
		System.out.println("Thank you for using auction.");
		
	}
}
