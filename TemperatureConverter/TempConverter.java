import java.util.Scanner;

public class TempConverter {

	/* This program converts temperatures from Fahrenheit to Celcius and vice-versa.
	 * It first asks user for a temperature in Fahrenheit, then outputs the Celcius
	 * equivalent. Then it asks for a temperature in Celcius and outputs the
	 * Fahrenheit equivalent.
	 */

	// Main method
	public static void main(String[] args) {

		// Create a new Scanner object
		Scanner temp = new Scanner(System.in);

		// Prompt user for a temperature in Fahrenheit
		System.out.print("Type a temperature in degrees Fahrenheit and press ENTER: ");

		// Declare and initialize input variable from user input
		double f1 = temp.nextDouble();

		// Convert Fahrenheit to Celcius
		double c1 = (f1 - 32) * (5.0 / 9);

		// Output Celcius temperature
		System.out.println(f1 + " degrees Fahrenheit is equal to " + c1 + " degrees Celsius");

		// Prompt user for a temperature in Celcius
		System.out.print("Type a temperature in degrees Celsius and press ENTER: ");

		// Declare and initialize input variable from user input
		double c2 = temp.nextDouble();

		// Convert Celcius to Fahrenheit
		double f2 = (9.0 / 5) * c2 + 32;

		// Output Fahrenheit temperature
		System.out.println(c2 + " degrees Celsius is equal to " + f2 + " degrees Fahrenheit");

		// Close Scanner input (clears warning in Eclipse)
		temp.close();

	}

}