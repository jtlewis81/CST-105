
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

public class DiscardPile {

	// The discard pile is an array list of cards
	private ArrayList<Card> cards = new ArrayList<>();

	// Default constructor starts a discard pile with first card from the Game Deck
	public DiscardPile() {
		Card[] deck = Game.deck.getDeck();
		Card[] temp = new Card[108];
		int d = 0;
		int t = 0;

		// Use a boolean to keep drawing until a non-Wild Draw 4 comes up
		boolean started = false;
		while (d < deck.length) {

			// Cannot start a game with a Wild Draw 4, tell the user if that is what was
			// drawn first
			if (started == false && deck[d].getFaceValue() == "Wild Draw 4") {
				System.out.println("Whoops! Cannot start with a Wild Draw 4. Drawing again...");
			}
			if (started == false && deck[d].getFaceValue() != "Wild Draw 4") {
				this.cards.add(deck[d]);
				started = true;
				d++;
			} else {
				temp[t] = deck[d];
				t++;
				d++;
			}
		}

		// Place the rest of the cards back in the deck
		Game.deck.setDeck(temp);
	}

	// add card to discard pile (setter)
	public void addToDiscardPile(Card card) {
		this.cards.add(0, card);
	}

	// get last card from pile
	public Card getLastPlayed() {
		return this.cards.get(0);
	}

	// read last card played
	public void readLastPlayed() {
		this.cards.get(0).readCard();
	}

	// remove a card from discard pile - in the event first card is Wild Draw 4
	public void remove(Card card) {
		this.cards.remove(card);
	}

	// get an individual card from discard pile
	public Card getCard(int card) {
		return this.cards.get(card);
	}

	// cards getter
	public ArrayList<Card> getCards() {
		return cards;
	}

	// cards setter
	public void setCards(ArrayList<Card> cards) {
		this.cards = cards;
	}

	// clears the discard pile - used for the draw pile reset
	public void clear() {
		this.cards.clear();
	}

}
