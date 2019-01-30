package com.techelevator;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AuctionDemoFinal {

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		
		//Auction auction = new Auction("Record");
		Auction auction = new BuyoutAuction("Record", 10);
		//Auction auction = new ReserveAuction("Taco", 3);
		
//		if (auction instanceof BuyoutAuction) {
//			System.out.println("Auction is a Buyout Auction");
//		}
//		
//		if (auction instanceof Auction) {
//			System.out.println("Auction is a Auction");
//		}
		
//		List<Auction> myAuctions = new ArrayList<Auction>();
//		myAuctions.add(new Auction("Record"));
//		myAuctions.add(new BuyoutAuction("Book", 10));
//		myAuctions.add(new ReserveAuction("Taco", 3));

		//for (Auction auction : myAuctions) {
		while (true) {
			System.out.println("Buy my " + auction.getItemForSale());
		
			System.out.print("Enter your name >>>");
			String bidder = in.nextLine();
			
			System.out.print("Place a bid >>>");
			String amount = in.nextLine();
			
			int bid = Integer.parseInt(amount);
			
			boolean isWinning = auction.placeBid(new Bid(bidder, bid));
			
			System.out.println(auction.getHighBid().getBidder() + 
					" is winning with a bid of " + auction.getHighBid().getBidAmount() 
					);
			
		}
		
		
	}

}
