package Phase3;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class controller extends Application {

	private loginController loginControl;
	private doctorController doctorControl;
	private patientController patientControl;
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		loginControl = new loginController();
		doctorControl = new doctorController();
		patientControl = new patientController();
		
		
		Scene loginScene = new Scene(loginControl.showLoginPage(), 800, 400);
		primaryStage.setScene(loginScene);
		primaryStage.setTitle("Medconnect Login);");
		primaryStage.show();
	}
	
	
	
	public static void main(String[] args) {
		launch(args);
	}
}