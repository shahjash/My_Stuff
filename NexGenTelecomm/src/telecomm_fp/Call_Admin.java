package telecomm_fp;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import telecomm_controller.Admin;

public class Call_Admin extends Application {

	public void start(Stage primaryStage) {
		try {
			// Create a loader for the UI components
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/telecomm_view/Welcome_Admin.fxml"));
			// Inflate the view using the loader
			AnchorPane root = (AnchorPane) loader.load();
			// Set window title
			primaryStage.setTitle("Welcome Admin");
			// Create a scene with the inflated view
			Scene scene = new Scene(root);
			// Set the scene to the stage
			primaryStage.setScene(scene);
			// Get the controller instance from the loader
			Admin controller = loader.getController();
			// Set the parent stage in the controller
			controller.setDialogStage(primaryStage);
			// Show the view
			primaryStage.show();
		}

		catch (Exception e) {
			System.out.println("Error from Call_Admin: " + e.getMessage());
		}
	}

}
