package Phase3;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class controller extends Application {
	@Override
	private loginController loginControl = new loginController();
	private doctorController doctorControl = new doctorController();
	private patientController patientControl = new patientController();
	
	public void start(Stage primaryStage) throws Exception {
		
		
		
		Scene loginScene = new Scene(loginControl.showLoginPage(), 800, 400);
		primaryStage.setScene(loginScene);
		primaryStage.setTitle("Medconnect Login);");
		primaryStage.show();
	}
	
	
	
	public static void main(String[] args) {
		launch(args);
	}
}