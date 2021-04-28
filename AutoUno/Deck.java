
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

public class Deck {

	// Define variables for the deck to be built with
	private final int cards = 108;
	private Card[] deck = new Card[cards];
	private String[] colors = { "Blue", "Red", "Green", "Yellow" };
	private String[] faceValues = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "Skip", "Reverse", "Draw 2" };
	private String[] wildCards = { "Wild", "Wild Draw 4" };

	// Constructor builds new deck
	public Deck() {
		int d = 0;
		for (int c = 0; c < colors.length; c++) {
			for (int f = 0; f < faceValues.length; f++) {
				if (d < cards && f == 0) {
					String color = colors[c];
					String faceValue = faceValues[f];
					int p = 0;
					deck[d] = new Card(d, color, faceValue, p);
					d++;
				} else if (d < cards && f <= 9) {
					String color = colors[c];
					String faceValue = faceValues[f];
					int p = f;
					deck[d] = new Card(d, color, faceValue, p);
					d++;
					color = colors[c];
					faceValue = faceValues[f];
					deck[d] = new Card(d, color, faceValue, p);
					d++;
				} else if (d < cards && f > 9) {
					String color = colors[c];
					String faceValue = faceValues[f];
					int p = 20;
					deck[d] = new Card(d, color, faceValue, p);
					d++;
					color = colors[c];
					faceValue = faceValues[f];
					deck[d] = new Card(d, color, faceValue, p);
					d++;
				} else {

				}
			}
		}
		for (int w = 0; w < wildCards.length; w++) {
			for (int i = 0; i < 4; i++) {
				if (d < cards) {
					String faceValue = wildCards[w];
					int p = 50;
					deck[d] = new Card(d, faceValue, p);
					d++;
				}
			}
		}
	}

	// This constructor is for setting the Game deck as empty once all the cards
	// have been dealt
	public Deck(int i) {
		this.deck = new Card[i];
	}

	// Shuffle the deck - NOT TESTED IF WILL WORK ON RESHUFFLING THE DISCARD PILE
	public Card[] shuffle() {
		for (int i = 0; i < deck.length; i++) {
			int random = (int) (Math.random() * deck.length);
			Card move = deck[i];
			deck[i] = deck[random];
			deck[random] = move;
		}
		return deck;
	}

	// Get deck
	public Card[] getDeck() {
		return deck;
	}

	// Set deck
	public void setDeck(Card[] deck) {
		this.deck = deck;
	}

	// Read out deck data - should always read that the deck is empty for where it
	// is called in the driver program
	public void readDeck() {
		if (this.deck.length == 0) {
			System.out.println("The deck is empty.");
		} else {
			for (int i = 0; i < deck.length; i++) {
				Card card = deck[i];
				int id = card.getCardID();
				String color = card.getColor();
				String value = card.getFaceValue();
				// int points = card.getPointValue();
				if (color == " ") {
					System.out.println(id + " " + value);
				} else {
					System.out.println(id + " " + color + "-" + value);
				}
			}
		}
	}
}