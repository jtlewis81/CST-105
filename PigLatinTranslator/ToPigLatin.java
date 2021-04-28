import java.util.Scanner;
import java.io.File;

public class ToPigLatin {

	public static void main(String[] args) throws Exception {
		
		/*
		 *   The tab spacing in this program handles words with up to 14 letters.
		 *   15-letter or longer words will be out of alignment, but I did not think
		 *   that handling any of that fell within the scope of the assignment.
		 */

		// Access file with text
		File file = new File("test.txt");

		// Pass file to Scanner
		Scanner input = new Scanner(file);

		String piglat = "";

		// Process each word in a loop
		while (input.hasNext()) {

			// Get text from file
			String word = input.next();

			// Format word to all upper case
			piglat = word.toUpperCase();
			
			// Returns the index of a certain character within a word
			int a = piglat.indexOf('A');
			int e = piglat.indexOf('E');
			int i = piglat.indexOf('I');
			int o = piglat.indexOf('O');
			int u = piglat.indexOf('U');
			int c;

			// Translate each word to Pig Latin
			for (c = 0; c <= word.length(); c++) {

				// single letter words and words starting with a vowel
				if (c == 0 && (c == a || c == e || c == i || c == o || c == u)) {
					piglat = piglat + "WAY";
					break;

					// vowel found after first character
				} else if (c > 0 && (c == a || c == e || c == i || c == o || c == u)) {
					piglat = piglat.substring(c) + piglat.substring(0, c) + "AY";
					break;

					// no vowels found unless last letter
				} else if (c == word.length()) {
					piglat = piglat + "WAY";
				}

			}
			
			// Handle tab spacing of longer versus shorter words			
			String tab = " \t ";
			
			if (word.length() <= 6) {
				tab = " \t \t ";
			}
			
			// Print original word, tab over, print Pig Latin word
			System.out.println(word + tab + piglat);

		}

		input.close();

	}

}
