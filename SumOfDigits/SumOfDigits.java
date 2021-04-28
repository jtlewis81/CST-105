import java.util.Scanner;

public class SumOfDigits {

	/* This program will take a 5-digit integer from user input and add the sum of
	 * the digits. For example, if the user enters 12345, the program will add:
	 * 1+2+3+4+5, and output the total: 15.
	 */

	// Main method
	public static void main(String[] args) {

		// Create a new Scanner object
		Scanner input = new Scanner(System.in);

		// Prompt user to enter a 5-digit positive integer
		System.out.print("Type a 5-digit positive whole number and press ENTER: ");

		// Declare and initialize input variable from user input
		int numIn = input.nextInt();

		// Close Scanner input (clears warning in Eclipse)
		input.close();

		// Declare and initialize a variable for each digit in the user's integer
		int a = numIn % 10;
		int b = (numIn % 100) / 10;
		int c = (numIn % 1000) / 100;
		int d = (numIn % 10000) / 1000;
		int e = (numIn % 100000) / 10000;

		// Output statement listing the digits and calculating the total
		System.out.print("The sum of the digits " + e + " + " + d + " + " + c + " + " + b + " + " + a + " = " + (a + b + c + d + e) + ".");
		
	}

}