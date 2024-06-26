package Phase3;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class doctorController {
	
	private Stage primaryStage;
	private BorderPane root;
	public void showDoctorPage() {
		root = new BorderPane();
		HBox topBox = new HBox(20);
		
		Label viewLabel = new Label("Doctor Dashboard");
		Tab home = new Tab("Home", root.setRight(null));
		Tab patientHistory = new Tab("patientHistory", showPatientHistory());
		Tab contacts = new Tab("Contacts", showContacts());
		TabPane tabPane = new TabPane();

		tabPane.getTabs().addAll(home, patientHistory, contacts);
		TextField patientSearch = new TextField();
		patientSearch.setPromptText("Patient Search");
		
		topBox.getChildren().addAll(viewLabel, tabPane, patientSearch);
		
		primaryStage.setTitle("Doctor Dashboard");
        Scene scene = new Scene(root, 800, 600);
        primaryStage.setScene(scene);
        primaryStage.show();
		

	}

	private void showPatientHistory() {
		
	}
}