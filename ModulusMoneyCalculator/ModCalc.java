import java.util.Scanner;

public class ModCalc {

	/*
	 * How to use modulus with the double primitive for money
	 */

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);

		// Normal modulus usage with an int
		int a = 15;
		int b = 4;
		System.out.println("Normal modulus usage with an int outputs the remainder of a division problem, for example: "
				+ a + " % " + b + " = " + (a % b));

		// Handling money the wrong way
		System.out.println(
				"But what if you want to divide money between a certain number of people and output how much will be left over?");
		System.out.println("Enter amount of money: ");
		double money = input.nextDouble();
		System.out.println("Enter number of people");
		int people = input.nextInt();

		input.close();

		// Wrong way to do
		double moneyEach = money / people; // Dividing
		double moneyLeft = money % people; // Remainder

		System.out.println("The same methods for handling ints do not work correctly:");
		// Accurate except for long decimal of a cent.
		System.out.println("Amount for each person - doesn't work with change invloved: $" + moneyEach);
		// Why can't this be divided evenly among the people but with a smaller remainder?
		System.out.println("Amount of money left over - not accurate for purpose: $" + moneyLeft); 
		System.out.println(
				"Note that the last step only works if you want to give each person whole dollars but still doesn't coincide with previous calculation");
		System.out.println(
				"if amount of money is less whole dollars than the number of people. Also, because of rounding, there may be a long decimal here as well.");

		// Correct way to do it, or at least one way that works
		System.out.println("Corrected output for exact change:");

		// Convert to a whole number (cents), removing excessive decimals with
		// Math.round()
		double accurateCentsEach = (Math.round(money * 100)) / people;
		// Divide by 100 to get Dollar and Cent amount for each person in correct format
		double accurateDollarsEach = accurateCentsEach / 100;

		// ***HERE IS WHERE WE ARE USING MODULUS WITH A DOUBLE***

		// Step 1 to produce remainder amount in Dollars.Cents format
		double accuracyLeftStep1 = (money % accurateDollarsEach);
		// Step 2 - Round previous output to whole Cent
		double accuracyLeftStep2 = Math.round(accuracyLeftStep1 * 100);
		// Final step to accurate amount remaining
		double accuracyLeftFinal = accuracyLeftStep2 / 100;

		// System.out.println(accurateCentsEach);
		System.out.println("Accurate amount for each person: $" + accurateDollarsEach);
		// System.out.println(accuracyLeftStep1);
		// System.out.println(accuracyLeftStep2);
		System.out.println("Accurate amount left over: $" + accuracyLeftFinal);

	}

}