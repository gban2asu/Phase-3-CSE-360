package Phase3;

import javafx.application.Application;
import javafx.stage.Stage;

public class controller extends Application {

	private loginController loginControl;
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		loginControl = new loginController();
		loginControl.showLoginPage();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}