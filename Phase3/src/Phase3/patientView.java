package Phase3;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class patientView extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Patient Dashboard");

        VBox mainLayout = new VBox(10);
        mainLayout.setPadding(new Insets(15, 15, 15, 15));

        
        Label patientNameLabel = new Label("Hello, <Patient Name>"); 
        Button updateContactInfoButton = new Button("Update Contact Information");
        Button viewVisitHistoryButton = new Button("View Visit History");
        Button messageBoxButton = new Button("Open Message Box");
        Button viewInsuranceButton = new Button("View Insurance Information");
        
        // Event handlers for buttons would go here
        // ...

       
        mainLayout.getChildren().addAll(patientNameLabel, updateContactInfoButton, viewVisitHistoryButton, messageBoxButton, viewInsuranceButton);
        mainLayout.setAlignment(Pos.CENTER);

        
        Scene scene = new Scene(mainLayout, 800, 600);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
