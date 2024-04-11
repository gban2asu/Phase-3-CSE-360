package Phase3;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class nurseController{

    private Stage primaryStage;
    private database database;

    public void showNursePage() {
        

        VBox mainLayout = new VBox(10);
        mainLayout.setPadding(new Insets(10));
        mainLayout.setAlignment(Pos.TOP_CENTER);

        TabPane tabs = new TabPane();
        Tab homeTab = new Tab("Home", createHomeContent());
        Tab patientHistoryTab = new Tab("Patient History", createPatientHistoryContent());
        Tab contactsTab = new Tab("Contacts", createContactsContent());
        tabs.getTabs().addAll(homeTab, patientHistoryTab, contactsTab);
        mainLayout.getChildren().add(tabs);

        primaryStage.setTitle("Nurse Dashboard");
        Scene scene = new Scene(mainLayout, 800, 600);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private GridPane createHomeContent() {
        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(10));

        
        grid.add(new Label("Name:"), 0, 0);
        TextField nameField = new TextField();
        nameField.setPromptText("Enter Name");
        grid.add(nameField, 1, 0);
        
        grid.add(new Label("Height:"), 0, 1);
        TextField heightField = new TextField();
        heightField.setPromptText("Enter Height");
        grid.add(heightField, 1, 1);
        
        grid.add(new Label("Weight:"), 0, 2);
        TextField weightField = new TextField();
        weightField.setPromptText("Enter Weight");
        grid.add(weightField, 1, 2);
        
        grid.add(new Label("Temperature:"), 0, 3);
        TextField temField = new TextField();
        temField.setPromptText("Enter Temperature");
        grid.add(temField, 1, 3);
        
        grid.add(new Label("Blood Pressure:"), 0, 4);
        TextField pressureField = new TextField();
        pressureField.setPromptText("Enter Blood Pressure");
        grid.add(pressureField, 1, 4);
        
        grid.add(new Label("Symptoms:"), 0, 5);
        TextField sympField = new TextField();
        sympField.setPromptText("Enter Symptoms");
        grid.add(sympField, 1, 5);

        
        Button saveButton = new Button("Save Vitals");
        saveButton.setOnAction(e -> {
        	String name = nameField.getText();
        	String height = heightField.getText();
        	String weight = weightField.getText();
        	String temperature = temField.getText();
        	String pressure = pressureField.getText();
        	String symptoms = sympField.getText();
            database.savePatientVitals(name, height, weight, temperature, pressure, symptoms);
        });
        grid.add(saveButton, 1, 6);

        return grid;
    }

    private VBox createPatientHistoryContent() {
        VBox vbox = new VBox(10);

        TextArea historyArea = new TextArea();
        historyArea.setPromptText("Enter patient's medical history...");
        vbox.getChildren().add(historyArea);

        return vbox;
    }

    private VBox createContactsContent() {
        VBox vbox = new VBox(10);

        TextArea contactsArea = new TextArea();
        contactsArea.setPromptText("Enter patient's contacts and insurance information...");
        vbox.getChildren().add(contactsArea);

        return vbox;
    }
}
