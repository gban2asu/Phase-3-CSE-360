package Phase3;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class loginController {
	
	private String user;
	private String password;
	private String userType;
	private Stage primaryStage;
	private Label errorLabel;

	private doctorController doctorControl;
	private nurseController nurseControl;
	private patientController patientControl;
	private Database database;
	
	public void showLoginPage() {
    	HBox mainBox = new HBox(20);
    	Image leftImage = new Image("file:leftPhoto.jpg");
    	
    	ImageView imageView = new ImageView(leftImage);
    	VBox rightBox = new VBox(20);
    	Label titleLabel = new Label("Medconnect");
    	rightBox.setAlignment(Pos.CENTER);
    	titleLabel.setStyle("-fx-font-size: 24px;" + "-fx-font-weight: bold;");
    	
    	TextField loginField = new TextField();
    	loginField.setPromptText("Username");
    	TextField passwordField = new TextField();
    	passwordField.setPromptText("Password");
    	Button loginButton = new Button("Login");
    	errorLabel = new Label();
        errorLabel.setTextFill(Color.RED);
        loginButton.setOnAction(e -> validateLogin());
    	
    	rightBox.getChildren().addAll(titleLabel, loginField, passwordField, loginButton, errorLabel);
    	mainBox.getChildren().addAll(imageView, rightBox);
    	
    	Scene loginScene = new Scene(mainBox, 800, 400);
		primaryStage.setScene(loginScene);
    	primaryStage.setTitle("Login Page");
    	primaryStage.show();
    }
	
	private void validateLogin() {
		//Somehow get pwd and user
		
		if (password.equals(/*password */) && user.equals(/*user */)) {
			if (userType.equals("Doctor")) {
				doctorControl = new doctorController();
				doctorControl.showDoctorPage();
			}
			else if (userType.equals("Nurse")) {
				nurseControl = new nurseController();
				nurseControl.showNursePage();
			}
			else {
				patientControl = new patientController();
				patientControl.showPatientPage();
			}
		}
		else {
			errorLabel.setText("Invalid Login");
		}
	}
}