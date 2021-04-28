
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

public class Card {

	// Each Card will have an ID, color, face value, and point value
	// (except wild cards will not have a color)
	private int cardID;
	private String color = " "; // Empty default value for wild cards
	private String faceValue;
	private int pointValue;

	// Constructor must be passed values for each instantiated card
	public Card(int cardID, String color, String faceValue, int pointValue) {
		this.cardID = cardID;
		this.color = color;
		this.faceValue = faceValue;
		this.pointValue = pointValue;
	}

	// Constructor for wild cards
	public Card(int cardID, String faceValue, int pointValue) {
		this.cardID = cardID;
		this.faceValue = faceValue;
		this.pointValue = pointValue;
	}

	// Getters
	public int getCardID() {
		return cardID;
	}

	public String getColor() {
		return color;
	}

	public String getFaceValue() {
		return faceValue;
	}

	public int getPointValue() {
		return pointValue;
	}

	// Setters
	public void setCardID(int cardID) {
		this.cardID = cardID;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public void setFaceValue(String faceValue) {
		this.faceValue = faceValue;
	}

	public void setPointValue(int pointValue) {
		this.pointValue = pointValue;
	}

	// Read card color and value
	public void readCard() {
		if (this.faceValue == "Wild" || this.faceValue == "Wild Draw 4") {
			System.out.println(this.faceValue);
		} else {
			System.out.println(this.color + "-" + this.faceValue);
		}
	}

	// Read valid card play options
	public void readValidCard() {
		System.out.println(this.getColor() + " or a " + this.faceValue);
	}

	// Card match check for all cards except Wild Draw 4
	public boolean isPlayable() {

		if (Game.validCard.getColor() == this.color
				|| Game.validCard.getFaceValue() == this.faceValue && this.faceValue != "Wild Draw 4"
				|| this.faceValue == "Wild") {
			return true;
		} else {
			return false;
		}
	}

	// Card match check for Wild Draw 4
	public boolean isWD4() {
		if (this.getFaceValue() == "Wild Draw 4") {
			return true;
		} else {
			return false;
		}
	}
}
