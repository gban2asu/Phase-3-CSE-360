package Phase3;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;

public class doctorController {
	
	public void showDoctorPage() {
		BorderPane root = new BorderPane();
		HBox topBox = new HBox(20);
		
		Label viewLabel = new Label("Doctor Dashboard");
		Button home = new Button("Home");
		Button patientHistory = new Button("patientHistory");
		Button contacts = new Button("Contacts");
		
		TextField patientSearch = new TextField();
		patientSearch.setPromptText("Patient Search");
		
		topBox.getChildren().addAll(viewLabel, home, patientHistory, contacts, patientSearch);
		
	}
}