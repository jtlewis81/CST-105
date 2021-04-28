
/*
 * Jamie Lewis
 * 
 * CST-105
 * 
 * Programming Exercise 8 - JavaFX Number Grid
 * 
 * Instructor: Amr Elchouemi
 * 
 * 
 * This program is a product of my own work.
 * 
 * LOOM Video: https://www.loom.com/share/210ee0baf9f047d089d0b063a0dc0f8c
 * 
 */

// Import all the things for JavaFX
import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;
import javafx.stage.Stage;

public class NumberGrid extends Application {
	
	// Main Method
	public static void main(String[] args) {
		
		// Call the launch method from the Application class
		Application.launch(args);
	}
	
	// Override the start method in the Application class
	@Override
	public void start(Stage primaryStage) {
		
		// Add a GridPane
		GridPane grid = new GridPane();
		
		// Set GridPane properties
		grid.setAlignment(Pos.CENTER);
		grid.setPadding(new Insets(10));
		grid.setHgap(0);
		grid.setVgap(0);
		
		// Use a loop to iterate through the elements we want to add to the grid
		for(int c = 0; c < 10; c++) {
			for(int r = 0; r < 10; r++) {
				
				// Create a Label Node containing a random number between 0 and 99 as a String
				int n = (int) (Math.random() * 100);
				Node num = new Label("" + n);
				
				// Create a Region Node - for background color
				Node cell = new Region();
				
				// Set properties for the Region and Label
				GridPane.setHalignment(num, HPos.CENTER);
				num.setStyle("-fx-padding: 10");
				num.setScaleX(1.2);
				num.setScaleY(1.2);
				cell.setStyle("-fx-border-width: 1; -fx-border-color: black");
				
				// Color the background a certain color whether it is divisible by 2, 3, or 6
				if (n % 6 == 0) {
					cell.setStyle("-fx-background-color: green; -fx-border-width: 1; -fx-border-color: black");
				} else if(n % 3 == 0) {
					cell.setStyle("-fx-background-color: yellow; -fx-border-width: 1; -fx-border-color: black");
				} else if(n % 2 == 0) {
					cell.setStyle("-fx-background-color: dodgerblue; -fx-border-width: 1; -fx-border-color: black");
				}
				
				// Add the Region to the grid column and row that the loop is on
				grid.add(cell, c, r);
				
				// Add the Label on top of the Region
				grid.add(num, c, r);
			}
		}
		
		// Create a new Scene
		Scene scene = new Scene(grid);
		
		// Set the Stage title
		primaryStage.setTitle("Number Grid");
		
		//Pass the Scene to the Stage
		primaryStage.setScene(scene);
		
		// Show the Stage
		primaryStage.show();
	}
}