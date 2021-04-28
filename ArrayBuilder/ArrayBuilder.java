/* 
 * Name: Jamie Lewis
 * 
 * Class: CST-105
 * 
 * Programming Exercise 5 - 2-D Arrays
 * 
 * The code contained in this project is my own work.
 */

import java.util.Scanner;
import java.io.File;

public class ArrayBuilder {

	public static void main(String[] args) throws Exception {

		// Create File and Scanner objects
		File file = new File("text.txt");
		Scanner input = new Scanner(file);

		// Get text from file
		String text = input.nextLine();

		// Create empty 6 row x 7 column char array
		int row = 6;
		int col = 7;
		char[][] charArray = new char[row][col];

		// Declare generic variables for use in loops
		int r;
		int c;
		int i = 0;

		// For convenience of this assignment, the original text from the input file is:
		// "My name is Jamie and I love programming."

		// Build 2-D array in row-major order
		for (r = 0; r < row; r++) {
			for (c = 0; c < col; c++) {
				if (i < text.length()) {
					charArray[r][c] = text.charAt(i);
					i++;
				} else {
					charArray[r][c] = '*';
				}
			}
		}
		
		// Output the array as it was built by the program but with an indicator for spaces
		System.out.print("The array was built as (with hyphen indicating spaces):");
		for (r = 0; r < row; r++) {
			for (c = 0; c < col; c++) {
				char b = charArray[r][c];
				if (b == ' ') {
					b = '-';
				}
				if (c == 0) {
					System.out.print("\r" + b);
				} else {
					System.out.print(b);
				}
			}
		}
		
		// Create new String to build from array
		String output = "";

		// Build output string by reading from charArray in column-major order
		for (c = 0; c < col; c++) {
			for (r = 0; r < row; r++) {
				output += charArray[r][c];
			}
		}

		System.out.println(" ");

		// Output the expected string literally (I worked it out on paper to test)
		System.out.println("Output should read:\t" + "M iIpmyie ri s lonn aoggaJnvr.madea*em  m*");

		// Output new string from variable
		System.out.println("Output variable reads:\t" + output);

		// Close Scanner
		input.close();

	}

}
