package Phase3;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

public class loginController {
	
	private String user;
	private String password;
	private String userType;
	
	public HBox showLoginPage() {
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
    	Label errorLabel = new Label();
        errorLabel.setTextFill(Color.RED);
        loginButton.setOnAction(e ->  {
        	if (validateLogin()) {
        		//
        	}
        	else {
        		errorLabel.setText("Invalid Login");
        	}
        });
    	
    	rightBox.getChildren().addAll(titleLabel, loginField, passwordField, loginButton, errorLabel);
    	mainBox.getChildren().addAll(imageView, rightBox);
    	
    	return mainBox;
    }
	
	
	private boolean validateLogin() {
		
	}
}