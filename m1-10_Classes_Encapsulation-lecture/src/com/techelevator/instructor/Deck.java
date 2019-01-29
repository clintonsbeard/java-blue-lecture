package com.techelevator.instructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

public class Deck {

	private final static String[] SUITS = {"c", "s", "d", "h"};
	private final static String[] RANKS = {"A","2","3","4","5","6","7","8","9","T","J","Q","K"};
	
	private List<Card> listOfCards = new ArrayList<Card>();
	
	public Deck() {
		for (String suit : SUITS) {
			for (String rank : RANKS) {
				Card currentCard = new Card(suit, rank);
				listOfCards.add(currentCard);
			}
		}
	}
	
	public Card deal() {
		if (size() != 0) {
			return listOfCards.remove(0);
		} else {
			return null;
		}
	}
	
	public void shuffle() {
		Collections.shuffle(listOfCards);
	}
	
	// Delegate method
	public int size() {
		return listOfCards.size();
	}
	
	private void flip() {
		for (Card card : listOfCards) {
			card.flip();
		}
	}
	
	@Override
	public String toString() {
		this.flip();
		String flippedCards =  "Deck [listOfCards=" + listOfCards + "]";
		this.flip();
		return flippedCards;
	}
}
