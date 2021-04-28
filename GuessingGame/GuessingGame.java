import java.util.Scanner;

public class GuessingGame {

	public static void main(String[] args) {

		// Create Scanner object
		Scanner input = new Scanner(System.in);

		// Random number generator for 1 - 10,000
		int random = 1 + (int) (Math.random() * 10000);

		// Declare and initialize valid range numbers
		int lowLimit = 1;
		int highLimit = 10000;

		// Ask user for guess
		System.out.println("Guess a number between " + lowLimit + " and " + highLimit + ": ");

		// Input user data
		int guess = input.nextInt();

		// Loop through user's guesses and output feedback
		while (guess != random) {

			// If guess is lower than random
			if (guess < random) {
				if (guess > lowLimit) {
					lowLimit = guess;
				}
				System.out.println("HIGHER");
			}

			// If guess is higher than random
			if (guess > random) {
				if (guess < highLimit) {
					highLimit = guess;
				}
				System.out.println("LOWER");
			}

			// Ask user for guess
			System.out.println("Guess a number between " + lowLimit + " and " + highLimit + ": ");

			// Input user data
			guess = input.nextInt();

		}

		// Runs when user guesses correctly
		if (guess == random) {

			System.out.println("WINNER");
			input.close();
		}

	}

}
