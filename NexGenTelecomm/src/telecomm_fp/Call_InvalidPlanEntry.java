package telecomm_fp;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import telecomm_controller.InvalidPlanController;
import telecomm_controller.InvalidUserController;

public class Call_InvalidPlanEntry {

	public void start(Stage primaryStage) {

		try {
			// Create a loader for the UI components
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/telecomm_view/Invalid_PlanDetails.fxml"));
			// Inflate the view using the loader
			AnchorPane root = (AnchorPane) loader.load();
			// Set window title
			primaryStage.setTitle("Invalid Entry");
			// Create a scene with the inflated view
			Scene scene = new Scene(root);
			// Set the scene to the stage
			primaryStage.setScene(scene);
			// Get the controller instance from the loader
			InvalidPlanController controller = loader.getController();
			// Set the parent stage in the controller
			controller.setDialogStage(primaryStage);
			// Show the view
			primaryStage.show();
		}

		catch (Exception e) {
			System.out.println("InvalidPlanController " + e.getMessage());
		}

	}

}
