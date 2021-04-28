
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

//import java.util.ArrayList;

public class Player {

	// Private data fields
	// Each player should have an index, id and a hand
	private int playerIndex;
	private String playerID;
	private Hand playerHand;

	// Statistics variables
	private int cardsPlayed = 0;
	private int cardsHeld = 0;

	// Constructor
	public Player(int playerIndex, String playerID, Hand playerHand) {
		this.playerIndex = playerIndex;
		this.playerID = playerID;
		this.playerHand = playerHand;
		this.cardsHeld = 7;
		this.cardsPlayed = 0;
	}

	// playerIndex getter
	public int getPlayerIndex() {
		return playerIndex;
	}

	// playerIndex setter
	public void setPlayerIndex(int playerIndex) {
		this.playerIndex = playerIndex;
	}

	// playerID getter
	public String getPlayerID() {
		return playerID;
	}

	// playerID setter
	public void setPlayerID(String playerID) {
		this.playerID = playerID;
	}

	// playerHand getter
	public Hand getPlayerHand() {
		return playerHand;
	}

	// playerHand setter
	public void setPlayerHand(Hand playerHand) {
		this.playerHand = playerHand;
	}

	// Reads playerHand
	public void readPlayerHand() {
		for (int i = 0; i < playerHand.size(); i++) {
			playerHand.getCard(i).readCard();
		}
	}

	// Player tries to play card or draws a card if no playable card in hand
	public void takeTurn() {
		boolean played = false;
		for (int i = 0; i < this.playerHand.size(); i++) {
			Card playerCard = this.playerHand.getCard(i);

			// Check non-Wild Draw 4 cards first
			if (playerCard.isPlayable()) {
				this.playerHand.playCard(i);
				System.out.print(this.playerID + " plays: ");
				playerCard.readCard();
				this.cardsPlayed += 1;
				played = true;
				if (playerCard.getFaceValue() == "Wild") {
					Game.colorChosen = false;
				}
				if (playerCard.getFaceValue() == "Draw 2") {
					Game.nextPlayerDraw = true;
				}
				if (playerCard.getFaceValue() == "Reverse") {
					Game.playHasReversed = false;
				}
				if (playerCard.getFaceValue() == "Skip") {
					Game.playHasSkipped = false;
				}
				break;
			}
		}

		// Then check Wild Draw 4s if no other play available
		if (played == false) {
			for (int i = 0; i < this.playerHand.size(); i++) {
				Card playerCard = this.playerHand.getCard(i);
				if (playerCard.isWD4()) {
					this.playerHand.playCard(i);
					System.out.println(this.playerID + " plays " + playerCard.getFaceValue());
					this.cardsPlayed += 1;
					played = true;
					Game.colorChosen = false;
					Game.nextPlayerDraw = true;
					break;
				}
			}
		}

		// If no play available, draw a card
		if (played != true) {
			drawCard(1);
		}
	}

	// Draw a card from draw pile and add to player's hand
	public void drawCard(int c) {

		// Reset the draw pile if it gets below 4 cards
		if (Game.drawPile.getQty() > 0 && Game.drawPile.getQty() < 4) {
			Game.drawPile.reset();

			// You should never see this!
		} else if (Game.drawPile.getQty() == 0) {
			System.out.println("Something went wrong because the players seem to be holding all of the cards!");
		}

		// If only drawing one card...
		if (c == 1) {
			Card d = Game.drawPile.getCard();
			this.playerHand.addCard(d);
			Game.drawPile.removeCard();

			// Check and see if it is playable
			if (d.isPlayable() || d.isWD4()) {
				this.playerHand.playCard(playerHand.size() - 1);
				System.out.print(this.playerID + " draws and plays: ");
				d.readCard();
				this.cardsHeld += 1;
				this.cardsPlayed += 1;
				if (d.getFaceValue() == "Wild") {
					Game.colorChosen = false;
				}
				if (d.getFaceValue() == "Draw 2") {
					Game.nextPlayerDraw = true;
				}
				if (d.getFaceValue() == "Reverse") {
					Game.playHasReversed = false;
				}
				if (d.getFaceValue() == "Skip") {
					Game.playHasSkipped = false;
				}
				if (d.getFaceValue() == "Wild Draw 4") {
					Game.colorChosen = false;
					Game.nextPlayerDraw = true;
				}

			} else {
				System.out.println(this.playerID + " draws: ");
				d.readCard();
				this.cardsHeld += 1;
			}

			// If drawing more than one card
		} else {
			System.out.println(this.playerID + " draws: ");
			for (int i = 0; i < c; i++) {
				this.playerHand.addCard(Game.drawPile.getCard());
				Game.drawPile.getCard().readCard();
				Game.drawPile.removeCard();
				Game.nextPlayerDraw = false;
				Game.nextPlayerDrawQty = 0;
			}
			this.cardsHeld += c;
		}

	}

	// Player chooses a color for validCard - called when playing a Wild or Wild
	// Draw 4
	public String chooseColor() {
		String color = "You should not be seeing this!";
		for (int i = 0; i < this.playerHand.size(); i++) {
			if (this.playerHand.getCard(i).getFaceValue() != "Wild"
					&& this.playerHand.getCard(i).getFaceValue() != "Wild Draw 4") {
				color = this.playerHand.getCard(i).getColor();
				break;
			}
		}
		System.out.println(this.getPlayerID() + " chooses " + color);
		return color;
	}

	// Player calls UNO if their hand only contains one card
	public void callUno() {
		System.out.println(playerID + " calls UNO!");
	}

	// Statistic variable getters and setters
	public int getCardsPlayed() {
		return cardsPlayed;
	}

	public int getCardsHeld() {
		return cardsHeld;
	}

	public void setCardsPlayed(int cardsPlayed) {
		this.cardsPlayed = cardsPlayed;
	}

	public void setCardsHeld(int cardsHeld) {
		this.cardsHeld = cardsHeld;
	}
}
