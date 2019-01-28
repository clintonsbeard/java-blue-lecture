package com.techelevator;

public class Card {

	private String suit;
	private String rank;
	private boolean faceUp = false;
	
	public Card(String suit, String rank) {
		this.suit = suit;
		this.rank = rank;
	}
	public String getSuit() {
		return this.suit;
	}
	public String getRank() {
		return this.rank;
	}
	public boolean isFaceUp() {
		return this.faceUp;
	}
	public boolean flip() {
		faceUp = !faceUp;
		return faceUp;
	}
	
	@Override
	public String toString() {
		if (faceUp) {
			return rank + suit;
		}
		else {
			return "##";
		}
	}
	
}