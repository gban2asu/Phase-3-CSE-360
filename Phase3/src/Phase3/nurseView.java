package Phase3;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class nurseView extends Application {

    public void start(Stage primaryStage) {
        primaryStage.setTitle("Nurse Dashboard");

        VBox mainLayout = new VBox(10);
        mainLayout.setPadding(new Insets(10));
        mainLayout.setAlignment(Pos.TOP_CENTER);

        TabPane tabs = new TabPane();
        Tab homeTab = new Tab("Home", createHomeContent());
        Tab patientHistoryTab = new Tab("Patient History", createPatientHistoryContent());
        Tab contactsTab = new Tab("Contacts", createContactsContent());
        tabs.getTabs().addAll(homeTab, patientHistoryTab, contactsTab);
        mainLayout.getChildren().add(tabs);

        Scene scene = new Scene(mainLayout, 800, 600);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private GridPane createHomeContent() {
        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(10));

        
        addFormField(grid, "Name", 0);
        addFormField(grid, "Height", 1);
        addFormField(grid, "Weight", 2);
        addFormField(grid, "Temperature", 3);
        addFormField(grid, "Blood Pressure", 4);
        addFormField(grid, "Symptoms", 5);

        
        Button saveButton = new Button("Save Vitals");
        saveButton.setOnAction(e -> {/* Implement save logic */});
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

    private void addFormField(GridPane grid, String label, int row) {
        grid.add(new Label(label + ":"), 0, row);
        TextField textField = new TextField();
        textField.setPromptText("Enter " + label);
        grid.add(textField, 1, row);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
