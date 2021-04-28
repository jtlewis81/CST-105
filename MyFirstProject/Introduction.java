
public class Introduction {
	

	
	// Declare class variables
	static String name;
	static String color;
	static String lottoWin;

	// Main method
	public static void main (String[] args) {

		// Define variables for use in output
		name = "Jamie Lewis";
		color = "cyan";
		lottoWin = "be debt free";
		
		// Produce output with defined variables
		System.out.println("My name is " + name + ".");
		System.out.println("My favorite color is " + color + ".");
		System.out.println("If I won the lottery, I would " + lottoWin + ".");
	
	}
	
/*
	OR we can do it this way (comment out lines 4 through 26 by moving 26 to 4 and 43 to 28):


   public static void main(String []args) {
      
      Introduction myInroduction = new Introduction("Jamie Lewis", "cyan", "be debt free");
      
   }
   
   public Introduction(String name, String color, String lottoWin) {
	      
		   System.out.println("My name is " + name + ".");
		   System.out.println("My favorite color is " + color + ".");
		   System.out.println("If I won the lottery, I would " + lottoWin + ".");
	}
   
*/

	
}


