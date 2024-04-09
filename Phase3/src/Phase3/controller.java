package Phase3;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class controller extends Application {
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		loginController loginControl = new loginController();
		
		Scene loginScene = new Scene(loginControl.showLoginPage(), 800, 400);
		primaryStage.setScene(loginScene);
		primaryStage.setTitle("Medconnect Login);");
		primaryStage.show();
	}
	
	
	
	public static void main(String[] args) {
		launch(args);
	}
}