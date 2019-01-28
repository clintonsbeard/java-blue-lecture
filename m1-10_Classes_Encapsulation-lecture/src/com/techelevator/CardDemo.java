package com.techelevator;

public class CardDemo {

	public static void main(String[] args) {
		
		Card aceOfSpades = new Card("s", "A");
		System.out.println(aceOfSpades);
		
		aceOfSpades.flip();
		System.out.println(aceOfSpades);
		
		Deck deckOfCards = new Deck();
		System.out.println(deckOfCards);
		
		Card nextCard = deckOfCards.deal();
		nextCard.flip();
		System.out.println(nextCard);
		nextCard = deckOfCards.deal();
		nextCard.flip();
		System.out.println(nextCard);
		nextCard = deckOfCards.deal();
		nextCard.flip();
		System.out.println(nextCard);
		
		deckOfCards.shuffle();
		System.out.println(deckOfCards);
	}

}