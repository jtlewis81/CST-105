
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

import java.util.Scanner;

public class Game {

	// Game variables and objects
	public static Scanner input = new Scanner(System.in);
	public static Deck deck;
	public static int playerCount;
	public static Player[] players;
	public static Player nextPlayer;
	public static boolean customNames;
	public static DiscardPile discardPile;
	public static Card validCard;
	public static DrawPile drawPile;
	public static boolean playOrderNormal = true;
	public static boolean playHasReversed;
	public static boolean playHasSkipped;
	public static boolean colorChosen;
	public static int nextPlayerDrawQty = 0;
	public static boolean nextPlayerDraw;
	public static boolean gameOver = false;
	public static int score;
	public static int pace;
	public static int turnCount = 0;

	// Main method - "throws InterruptedException" is for the Thread.sleep() method
	// used to control game speed
	public static void main(String[] args) throws InterruptedException {

		// Run setup method to build a deck, set user options, create players, deal
		// hands, start discard and
		// draw piles; and set first player, valid card, if first player has to draw
		// cards, and direction of play
		setup();

		// MAIN GAME LOOP
		while (gameOver != true) {

			// Announce next player
			System.out.println("Next Player is: " + nextPlayer.getPlayerID());

			// Announce if player must draw cards and how many
			if (nextPlayerDraw) {
				System.out.println(nextPlayer.getPlayerID() + " must draw " + nextPlayerDrawQty + " cards.");
			}

			// Pause to control game speed according to user's selection
			Thread.sleep(pace);

			// Player compares valid play to their hand if they do not have to draw cards at
			// start of turn
			if (nextPlayerDraw != true) {
				System.out.print("Valid play is a ");
				validCard.readValidCard();
				System.out.println(nextPlayer.getPlayerID() + " has:");
				nextPlayer.readPlayerHand();
			}
			Thread.sleep(pace);

			// Player draws cards if necessary or takes turn and then calls UNO if
			// applicable
			if (nextPlayerDraw) {
				nextPlayer.drawCard(nextPlayerDrawQty);
			} else {
				nextPlayer.takeTurn();
				if (nextPlayer.getPlayerHand().size() == 1) {
					nextPlayer.callUno();
				}
			}
			Thread.sleep(pace);

			// Add 1 to turnCount variable for statistics
			turnCount += 1;

			// Game is over when first player runs out of cards
			if (nextPlayer.getPlayerHand().size() == 0) {
				Game.gameOver = true;
			}

			// Announces winner and breaks out of main game loop if player runs out of cards
			if (gameOver) {
				break;
			}

			// Run method to setup next player's turn
			setNext();

			// Add a blank line in console to separate player turns, for better user
			// experience
			System.out.println("");

		}

		// Run method to calculate score for winner
		totalScore();
		System.out.println("");
		System.out.print("GAME OVER!!! " + nextPlayer.getPlayerID() + " WINS WITH.");
		for (int i = 0; i < 4; i++) {
			System.out.print(".");
			Thread.sleep(pace);
		}
		System.out.println(score + " POINTS!!!");
		System.out.println("");

		// Run method to generate game statistics report
		gameReport();
	}

	public static void setup() throws InterruptedException {

		// Build a new deck
		System.out.println("Building the game deck...");
		deck = new Deck();
		Thread.sleep(pace);
		System.out.println("The game deck is ready.");

		// Shuffle deck
		System.out.println("Shuffling the deck...");
		deck.shuffle();
		Thread.sleep(pace);
		System.out.println("The deck has been shuffled.");

		// Get user to choose number of players, gameplay speed, and offer to name
		// players
		setPlayerCount();
		setGameSpeed();
		customNames();

		// Deal a Hand to each player
		System.out.println("Dealing cards...");
		players = new Player[playerCount];
		for (int p = 0; p < playerCount; p++) {
			String id;

			// Get user to name players if they chose to or give them generic names
			// otherwise
			if (customNames) {
				System.out.println("Please choose a player name:");
				id = input.next();
			} else {
				id = "PLAYER " + (p + 1);
			}

			// Calls Hand constructor
			Hand playerHand = new Hand();

			// Calls Player constructor
			players[p] = new Player(p, id, playerHand);
		}

		// Close the Scanner after all available user input has been gotten
		input.close();

		// Read out each player's hand
		for (int i = 0; i < players.length; i++) {
			Thread.sleep(pace);
			System.out.println(players[i].getPlayerID() + " is holding: ");
			players[i].readPlayerHand();
			System.out.println("");
		}
		System.out.println("The hands have been dealt.");

		// Start Discard Pile
		System.out.println("Starting discard pile...");
		discardPile = new DiscardPile();
		validCard = discardPile.getLastPlayed();
		Thread.sleep(pace);

		// Set draw pile
		System.out.println("Placing draw pile...");
		drawPile = new DrawPile();
		Thread.sleep(pace);
		deck.readDeck();

		// Announce game ready and first card
		System.out.println("Ready to start the game!");
		System.out.print("The game's first card is ");
		validCard.readCard();

		if (validCard.getFaceValue() == "Reverse") {
			nextPlayer = players[3];
			playOrderNormal = false;
		} else if (validCard.getFaceValue() == "Wild") {
			nextPlayer = players[1];
			validCard.setColor(nextPlayer.chooseColor());
		} else if (validCard.getFaceValue() == "Skip") {
			nextPlayer = players[1];
		} else if (validCard.getFaceValue() == "Draw 2") {
			nextPlayer = players[0];
			nextPlayerDrawQty = 2;
			nextPlayerDraw = true;
		} else {
			nextPlayer = players[0];
		}

		// Announce first player
		System.out.println(nextPlayer.getPlayerID() + " will go first.");
		System.out.println("");
		Thread.sleep(pace);
	}

	// Method runs at the end of a player's turn and sets booleans that control
	// player turns
	public static void setNext() {

		int n = nextPlayer.getPlayerIndex();

		// Set playorder for Reverse cards
		if (validCard.getFaceValue() == "Reverse" && playHasReversed == false) {
			if (playOrderNormal) {
				n--;
				playOrderNormal = false;
				playHasReversed = true;
			} else {
				n++;
				playOrderNormal = true;
				playHasReversed = true;
			}

			// Have player choose a color when playing a Wild card
		} else if (validCard.getFaceValue() == "Wild" && colorChosen == false) {
			validCard.setColor(nextPlayer.chooseColor());
			colorChosen = true;
			if (playOrderNormal) {
				n++;
			} else {
				n--;
			}

			// Skip players
		} else if (validCard.getFaceValue() == "Skip" && playHasSkipped == false) {
			if (playOrderNormal) {
				n += 2;
				playHasSkipped = true;
			} else {
				n -= 2;
				playHasSkipped = true;
			}

			// Handle Draw 2 cards
		} else if (validCard.getFaceValue() == "Draw 2") {
			nextPlayerDrawQty = 2;
			if (playOrderNormal) {
				n++;
			} else {
				n--;
			}

			// Handle Wild Draw 4 cards
		} else if (validCard.getFaceValue() == "Wild Draw 4" && colorChosen == false) {
			validCard.setColor(nextPlayer.chooseColor());
			colorChosen = true;
			nextPlayerDrawQty = 4;
			if (playOrderNormal) {
				n++;
			} else {
				n--;
			}

			// Normal player progression
		} else {
			if (playOrderNormal) {
				n++;
			} else {
				n--;
			}
		}

		if (n > playerCount - 1) {
			n -= playerCount;
		} else if (n < 0) {
			n += playerCount;
		}

		// Sets next player index according to above conditions
		nextPlayer = players[n];
	}

	// Calculates total score for the winning player
	public static void totalScore() {

		for (int p = 0; p < players.length; p++) {
			for (int c = 0; c < players[p].getPlayerHand().size(); c++) {
				score += players[p].getPlayerHand().getCard(c).getPointValue();
			}
		}
	}

	// Generates a statistics report for the total number of turns taken in the
	// game, and how many cards each player held and played during the game.
	public static void gameReport() {
		System.out.println("GAME SUMMARY:");
		System.out.println("");
		System.out.println("A total of " + turnCount + " turns were taken.\n");
		for (int p = 0; p < players.length; p++) {
			System.out.println(players[p].getPlayerID() + " held a total of " + players[p].getCardsHeld()
					+ " cards \n\tand played a total of " + players[p].getCardsPlayed() + " cards.");
		}
	}

	// Sets playerCount variable for the game from user input
	public static void setPlayerCount() {
		System.out.println("How many players would you like?\n(Please enter a number between 2 and 10)");
		int num = input.nextInt();
		if (num >= 2 && num <= 10) {
			Game.playerCount = num;
		} else {
			setPlayerCount();
		}
	}

	// Sets gameSpeed variable for the game from user input
	public static void setGameSpeed() {
		System.out.println(
				"How fast would you like the gameplay to be?\n1 - Slow, 2 - Normal, 3 - Fast, 4 - SuperSpeed, or 5 - Instant"
						+ "\n(Please enter a number from 1 to 5)");
		int speed = input.nextInt();
		switch (speed) {
		case 1:
			pace = 1600;
			break;
		case 2:
			pace = 1200;
			break;
		case 3:
			pace = 800;
			break;
		case 4:
			pace = 200;
			break;
		case 5:
			pace = 0;
			break;
		default:
			System.out.println("Please try again.");
			setGameSpeed();
		}
	}

	// Gives the user an option to name players - sets a boolean that is used when
	// players are being generated
	public static void customNames() {
		System.out.println("Would you like to give the players custom names?\nPlease enter 1 for Yes or 2 for No.");
		int choice = input.nextInt();
		switch (choice) {
		case 1:
			customNames = true;
			break;
		case 2:
			customNames = false;
			break;
		default:
			System.out.println("Please try again.");
			customNames();
		}
	}

}