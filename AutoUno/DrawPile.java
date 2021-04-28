
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

public class DrawPile {

	// The discard pile is an ArrayList of cards
	private ArrayList<Card> cards = new ArrayList<>();

	// Default constructor converts remainder of game deck to draw pile
	public DrawPile() {
		Card[] deck = Game.deck.getDeck();
		int d = 0;
		while (deck[d] != null) {
			cards.add(deck[d]);
			d++;
		}

		// Once the DrawPile has been created the original deck has been fully
		// distributed between hands, a discard pile, and a draw pile. It is therefore
		// now empty and cannot be used.
		Game.deck = new Deck(0);
	}

	// gets "top" or "last played" card, which is always set to index 0 for ease of
	// access
	public Card getCard() {
		return this.cards.get(0);
	}

	// remove top card
	public void removeCard() {
		this.cards.remove(0);
	}

	// cards getter
	public ArrayList<Card> getCards() {
		return cards;
	}

	// cards setter
	public void setCards(ArrayList<Card> cards) {
		this.cards = cards;
	}

	// reaturns the qty of cards in the draw pile - used to determine when to reset
	// the pile from the discard pile
	public int getQty() {
		return this.cards.size();
	}

	// reset draw pile from discard pile - DOES NOT WORK
	public void reset() {
		Card d = Game.discardPile.getLastPlayed();
		Game.discardPile.remove(d);
		for (int c = 0; c < Game.discardPile.getCards().size(); c++) {
			int index = (int) Math.random() * 50;
			this.cards.add(index, Game.discardPile.getCard(c));
		}
		Game.discardPile.clear();
		Game.discardPile.addToDiscardPile(d);

		System.out.println("");
		System.out.println("The Draw Pile has been reset.");
		System.out.println();
	}

}
