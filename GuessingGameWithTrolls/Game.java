import java.util.Scanner;

public class Game {

	public static void main(String[] args) {

		// Create Scanner object
		Scanner input = new Scanner(System.in);

		// Random number generator
		int random = (int) (Math.random() * 100000);
		if (random < 1) {
			random = random * 10;
		}
		if (random > 10000) {
			random = random / 10;
		}

		// Declare and initialize variables
		int guess = 0;
		int lowLimit = 1;
		int highLimit = 10000;

		// Make fun of stupid users #forthelolz
		String insult[] = { "No, stupid!", "Can you even read?", "Do you need glasses?", "Try harder!",
				"Can you even count, bro?", "Wrong again!", "What?", "Why???", "Short term memory much?",
				"LOL. Dummy!" };

		// Welcome message
		System.out.println(
				"Welcome to Guess the Random Number! The game will remind you each round of your highest and lowest guesses. If you guess outside of that parameter, you will be made fun of.");

		// Runs while users guess is wrong
		while (guess != random) {
			if (guess == 0 || (guess >= lowLimit && guess <= highLimit)) {

				// Ask user for guess
				System.out.println("Guess a number between " + lowLimit + " and " + highLimit + ": ");

				// Input user data
				guess = input.nextInt();

				// Output feedback to user
				if (guess < random) {
					if (guess > lowLimit) {
						lowLimit = guess;
					}
					System.out.println("HIGHER");
				} else if (guess > random) {

					if (guess < highLimit) {
						highLimit = guess;
					}
					System.out.println("LOWER");
				}

			} else {

				int r = (int) (Math.random() * 10);
				System.out.println(insult[r]);
				guess = lowLimit;

			}

		}
		// System.out.println("The number was:" + random); // For testing only

		// Runs when user guesses correctly
		if (guess == random) {

			System.out.println("WINNER");
			input.close();
		}

	}

}
