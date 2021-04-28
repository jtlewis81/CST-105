
/*
 * Jamie Lewis
 * 
 * CST-105 Programming Exercise 7
 * 
 * 5/16/2020
 * 
 * Instructor: Amr Elchouemi
 * 
 * 
 * This program is a product of my own work.
 * 
 * PLEASE NOTE: I am aware that the rubric for this assignment asks that each integer pass through both methods,
 * however it is illogical to pass an integer through a second test when it fails the first and will only be
 * used further if it passes both. My program does utilize both methods for those integers that cause the first
 * method to return true, and gives the expected output at the end.
 *  
 */

import java.util.ArrayList;

public class PalindromicPrime {

	public static void main(String[] args) {

		// Create empty array list to store each valid palindromic prime number in
		ArrayList<Integer> nums = new ArrayList<>();

		// loop through each number from 2 to 100,000
		for (int i = 2; i <= 100000; i++) {

			// Test if each integer is prime
			if (isPrime(i)) {

				// Test if each prime integer is a palindrome
				if (isPalindrome(i)) {

					// If integer is palindromic prime, add it to the array list
					nums.add(i);
				}
			}
		}

		// Print results
		System.out.println("Palindromic Prime integers up to positive 100,000 are:");
		for (int i = 0; i < nums.size(); i++) {
			System.out.print(nums.get(i) + "\t");

			// Each printed line only contains four integers as indicated in assignment
			// instructions
			if ((i + 1) % 4 == 0) {
				System.out.println("");
			}
		}
	}

	
	// Method to test if a number is prime, returns boolean
	public static boolean isPrime(int num) {

		// Assume number is prime
		boolean p = true;

		// Loop through dividing num by numbers from 2 to half of num
		for (int i = 2; i <= num / 2; i++) {

			// If the remainder is 0, num is not prime, set boolean to false and break out
			// of the loop
			if (num % i == 0) {
				p = false;
				break;
			}
		}
		// Return the boolean
		return p;
	}

	
	// Method to test if a number is a palindrome, returns boolean
	public static boolean isPalindrome(int num) {

		// Assume num is a palindrome
		boolean p = true;

		// Convert num to a string to use charAt()
		String n = String.valueOf(num);

		// The indexes of the first and last characters in the string
		int a = 0;
		int b = n.length() - 1;

		// Loop through string and check if first and last chars match, then go to next
		// chars toward center, etc.
		while (a < b) {

			// If chars do not match, num is not a palindrome, set boolean to false and
			// break out of the loop
			if (n.charAt(a) != n.charAt(b)) {
				p = false;
				break;
			}

			// Increment and decrement chars to be checked
			a++;
			b--;
		}

		// Return the boolean
		return p;
	}
}
