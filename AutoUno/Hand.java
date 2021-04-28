
/*
 * Jamie Lewis
 * 
 * CST-105
 * 
 * Milestone Project - UNO Card Game
 * 
 * Instructor: Amr Elchouemi
 * 
 * 
 * This program is a product of my own work.
 * 
 */

import java.util.ArrayList;

public class Hand {

	// The hand is an array list of cards
	private ArrayList<Card> cards = new ArrayList<>();

	// Default constructor deals new hands of 7 cards to players from the Game Deck
	public Hand() {
		Card[] deck = Game.deck.getDeck();
		Card[] temp = new Card[108];
		int d = 0;
		int i = 0;
		int t = 0;
		while (d < deck.length) {
			if (i < 7) {
				this.cards.add(deck[d]);
				i++;
			} else {
				temp[t] = deck[d];
				t++;
			}
			d++;
		}
		Game.deck.setDeck(temp);
	}

	// get all cards in hand
	public ArrayList<Card> getCards() {
		return cards;
	}

	// get an individual card from hand
	public Card getCard(int card) {
		return this.cards.get(card);
	}

	// remove card from hand on play
	public void playCard(int card) {
		Card c = this.cards.get(card);
		this.cards.remove(card);
		Game.discardPile.addToDiscardPile(c);
		Game.validCard = c;
	}

	// add a card to hand
	public void addCard(Card card) {
		this.cards.add(card);
	}

	// get number of cards in hand - useful for looping through hand
	public int size() {
		return cards.size();
	}

}
